package com.nandini.automation.tests;


import java.util.List;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.nandini.automation.base.BaseTest;
import com.nandini.automation.pages.CartPage;
import com.nandini.automation.pages.InventoryPage;
import com.nandini.automation.pages.LoginPage;
import com.nandini.automation.utils.ExcelReader;


public class LoginTests extends BaseTest {

        @Test(dataProvider="loginData")
        public void verifyLogin(String username, String password) {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);

    }
    
    @Test(dataProvider="loginData")
    public void verifyAddToCart(String username, String password)
    {
        //ConfigReader config = new ConfigReader();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        InventoryPage inventoryPage= new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.addProductToCart("Sauce Labs Onesie");
        int count = inventoryPage.getCartCount();
        Assert.assertEquals(count, 2);
        //inventoryPage.openCart();

        CartPage cartPage= new CartPage(driver);
        String product= cartPage.getProductName();
        Assert.assertTrue(cartPage.isProductPresent(product), "Product not displayed in cart");
        Assert.assertEquals(cartPage.getProductName(),"Sauce Labs Backpack", "Incorrect product in cart");
    }
    @Test(dataProvider="loginData") // added this because here it expects only 1 add to cart not like amazon where quantity increases
    public void verifyDuplicateProductNotAdded(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        Assert.assertTrue(driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed());
    }
    @Test(dataProvider="loginData")
    public void verifyRemoveProduct(String username, String password)
    {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        if(username.equals("problem_user"))
        {
            return; // skip because expected behaviour
        }
        else{
        InventoryPage inventoryPage = new InventoryPage(driver);
        inventoryPage.addProductToCart("Sauce Labs Backpack");
        inventoryPage.removeProduct("Sauce Labs Backpack");
        int count = inventoryPage.getCartCount();
        Assert.assertEquals(count, 0, "Cart is not empty after removing product");
        }
    }

    @Test(dataProvider = "loginData")
    public void verifyMultipleProductsInCart(String username, String password)
{
    if(username.equals("problem_user"))
    {
        return; // skip this test
    }

    LoginPage loginPage = new LoginPage(driver);
    loginPage.login(username, password);

    InventoryPage inventoryPage = new InventoryPage(driver);

    inventoryPage.addProductToCart("Sauce Labs Backpack");
    inventoryPage.addProductToCart("Sauce Labs Bike Light");
    
    inventoryPage.goToCart();
    // System.out.println("Cart count: " + inventoryPage.getCartCount());

    CartPage cartPage = new CartPage(driver);
    
    // System.out.println("Current URL: " + driver.getCurrentUrl());

    List<String> products = cartPage.getAllProductNames();

    // System.out.println("Products: " + products);

    Assert.assertTrue(products.contains("Sauce Labs Backpack"));
    Assert.assertTrue(products.contains("Sauce Labs Bike Light"));
}
        
    @DataProvider(name="loginData")
    public Object[][] getLoginData(){

    return ExcelReader.getLoginData();

}
    
}
