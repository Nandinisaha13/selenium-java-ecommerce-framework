package com.nandini.automation.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import com.nandini.automation.utils.WaitUtils;

public class InventoryPage {
    WebDriver driver;
    By cartBadge = By.className("shopping_cart_badge");
    public InventoryPage(WebDriver driver)
    {
        this.driver=driver;
    }
public void addProductToCart(String productName)
{
    String formattedName = productName.toLowerCase().replace(" ", "-");

    By addBtn = By.id("add-to-cart-" + formattedName);
    By removeBtn = By.id("remove-" + formattedName);

    // If already added → skip
    if (driver.findElements(removeBtn).size() > 0)
    {
        return;
    }

    // If add button exists → click
    if (driver.findElements(addBtn).size() > 0)
    {
        WaitUtils.waitForElementClickable(driver, addBtn).click();
        //WaitUtils.waitForElementVisible(driver, removeBtn);
    }
    else
    {
        System.out.println("Add button not found for: " + productName);
    }
}
    
    public void goToCart()
    {
        By cartLink = By.className("shopping_cart_link");
        WaitUtils.waitForElementClickable(driver, cartLink).click();
        driver.findElement(cartLink).click();
        //WaitUtils.waitForElementVisible(driver, By.className("cart_item"));

    }
    
    // Get cart count
    public int getCartCount()
    {
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
    WaitUtils.waitForElementClickable(driver, removeBtn).click();
    //WaitUtils.waitForElementVisible(driver, addBtn);
    }
}
