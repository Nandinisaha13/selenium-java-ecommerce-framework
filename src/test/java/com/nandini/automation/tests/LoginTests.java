package com.nandini.automation.tests;

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
    // @Test(dataProvider="loginData")
    // public void verifyLogin()
    // {
    //     ConfigReader config = new ConfigReader();

    //     String username = config.getProperty("username");
    //     String password = config.getProperty("password");
    //     LoginPage loginPage = new LoginPage(driver);
    //     loginPage.login(username, password);
    // }
    
    @Test(dataProvider="loginData")
    public void verifyAddToCart(String username, String password)
    {
        //ConfigReader config = new ConfigReader();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        InventoryPage inventoryPage= new InventoryPage(driver);
        inventoryPage.addProductToCart();
        inventoryPage.openCart();

        CartPage cartPage= new CartPage(driver);
        String product= cartPage.getProductName();
        Assert.assertEquals(product, "Sauce Labs Backpack", "Product name mismatch");
    }
    @DataProvider(name="loginData")
    public Object[][] getLoginData(){

    return ExcelReader.getLoginData();

}
    
}
