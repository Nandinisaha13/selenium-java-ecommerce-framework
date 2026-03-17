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
        String formatted_name= productName.toLowerCase().replace(" ", "-");
        String productId= "add-to-cart-" + formatted_name;
        By addToCartBtn= By.id(productId);
        WaitUtils.waitForElementClickable(driver, addToCartBtn).click();
    }
    public void openCart()
    {
         driver.findElement(By.className("shopping_cart_link")).click();

    }
    // Get cart count
    public int getCartCount()
    {
        if(driver.findElements(cartBadge).size() == 0)
        {
            return 0; // No badge = empty cart
        }

    return Integer.parseInt(driver.findElement(cartBadge).getText());
    }
    public void removeProduct(String productName)
    {
        String formattedName = productName.toLowerCase().replace(" ", "-");
        //System.out.println(formattedName);
        String productId= "remove-" + formattedName;
       // By removeBtn = By.id("remove-" + formattedName);
        By removeBtn= By.id(productId);
        WaitUtils.waitForElementClickable(driver, removeBtn).click();
    }
}
