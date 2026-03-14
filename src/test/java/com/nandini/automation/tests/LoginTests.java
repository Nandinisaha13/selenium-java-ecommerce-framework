package com.nandini.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.nandini.automation.base.BaseTest;
import com.nandini.automation.pages.CartPage;
import com.nandini.automation.pages.InventoryPage;
import com.nandini.automation.pages.LoginPage;

public class LoginTests extends BaseTest {
    @Test
    public void verifyLogin()
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");
    }
    @Test
    public void verifyAddToCart()
    {
        LoginPage loginPage= new LoginPage(driver);
        loginPage.login("standard_user","secret_sauce");   
        InventoryPage inventoryPage= new InventoryPage(driver);
        inventoryPage.addProductToCart();
        inventoryPage.openCart();

        CartPage cartPage= new CartPage(driver);
        String product= cartPage.getProductName();
        Assert.assertEquals(product, "Sauce Labs Backpack");
    }
    
}
