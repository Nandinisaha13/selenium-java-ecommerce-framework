package com.nandini.automation.pages;


import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {
    WebDriver driver;
    By productName = By.className("inventory_item_name");
    public CartPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public String getProductName()
    {
        return driver.findElement(By.className("inventory_item_name")).getText();
    }
    public List<String> getAllProductNames()
    {
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        List<String> productNames = new ArrayList<>();
        for(WebElement product: products)
        {
            productNames.add(product.getText().trim());
        }
        return productNames;
    }
    public boolean isProductPresent(String expectedProduct)
    {
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));

            for(WebElement product : products)
            {
                if(product.getText().equals(expectedProduct))
                {
                    return true;
                }
            }
    return false;
    }
}
