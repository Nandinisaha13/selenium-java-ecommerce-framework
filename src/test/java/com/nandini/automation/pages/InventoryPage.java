package com.nandini.automation.pages;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.nandini.automation.utils.WaitUtils;

public class InventoryPage {
    WebDriver driver;
    By cartBadge = By.className("shopping_cart_badge");
    public InventoryPage(WebDriver driver)
    {
        this.driver=driver;
        
    }
    public void waitForCartCountToBe(int expectedCount)
{
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(driver -> {
        try {
            return getCartCount() == expectedCount;
        } catch (Exception e) {
            return false;
        }
    });
}

public void addProductToCart(String productName)
{
    String formattedName = productName.toLowerCase().replace(" ", "-");

    By addBtn = By.id("add-to-cart-" + formattedName);
    By removeBtn = By.id("remove-" + formattedName);

    if (driver.findElements(removeBtn).size() > 0)
    {
        return;
    }
    int beforeCount = getCartCount();
    WaitUtils.waitForElementClickable(driver, addBtn).click();
    waitForCartCountToBe(beforeCount + 1);
}
    
    
    public void goToCart()
    {
        By cartLink = By.className("shopping_cart_link");
        WaitUtils.waitForElementClickable(driver, cartLink).click();
    }
    

    public int getCartCount()
    {
        if (driver.findElements(cartBadge).isEmpty()) {
            return 0;
        }

        try {
            return Integer.parseInt(
                WaitUtils.waitForElementVisible(driver, cartBadge).getText()
            );
        } catch (Exception e) {
            return 0;
    }
    }
public void removeProduct(String productName)
{
    String formattedName = productName.toLowerCase().replace(" ", "-");

    By removeBtn = By.id("remove-" + formattedName);
    By addBtn = By.id("add-to-cart-" + formattedName);

    int beforeCount = getCartCount();

    WebElement removeElement = WaitUtils.waitForElementClickable(driver, removeBtn);
    removeElement.click();

    WaitUtils.waitForElementVisible(driver, addBtn);

    waitForCartCountToBe(beforeCount - 1);
}
}
