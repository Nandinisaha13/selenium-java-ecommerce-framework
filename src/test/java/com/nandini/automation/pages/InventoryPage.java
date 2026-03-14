package com.nandini.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    WebDriver driver;
    public InventoryPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void addProductToCart()
    {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }
    public void openCart()
    {
        driver.findElement(By.className("shopping_cart_link")).click();
    }
}
