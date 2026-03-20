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
        System.out.println(productName + " already added");
        return;
    }

    // If add button exists → click
    if (driver.findElements(addBtn).size() > 0)
    {
        WaitUtils.waitForElementClickable(driver, addBtn).click();
    }
    else
    {
        System.out.println("Add button not found for: " + productName);
    }
}
    
    public void goToCart()
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
