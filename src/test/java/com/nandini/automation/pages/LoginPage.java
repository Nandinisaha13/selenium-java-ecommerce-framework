package com.nandini.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void enterUsername(String userName)
    {
        driver.findElement(By.name("user-name")).sendKeys(userName);

    }
    public void enterPassword(String pass)
    {
        driver.findElement(By.id("password")).sendKeys(pass);
    }
    public void clickLogin()
    {
        driver.findElement((By.className("submit-button"))).click();
    }
    public void login(String userName, String pass)
    {
        enterUsername(userName);
        enterPassword(pass);
        clickLogin();
    }
}

