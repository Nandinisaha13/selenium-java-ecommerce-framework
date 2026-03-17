package com.nandini.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.nandini.automation.utils.WaitUtils;


public class LoginPage {
    WebDriver driver;
    // WebElement username; //because sometimes it may throw error as we would have declared it in constructor, page might have not loaded while the constructor is loaded so better use by
    // WebElement password;
    // WebElement loginbtn;
    By username= By.name("user-name");
    By passWord= By.id("password");
    By loginbtn= By.className("submit-button");
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }
    public void enterUsername(String userName)
    {
        WaitUtils.waitForElementVisible(driver, username);
        driver.findElement(username).sendKeys(userName);
    }
    public void enterPassword(String password)
    {
        WaitUtils.waitForElementVisible(driver, passWord);
        driver.findElement(passWord).sendKeys(password);
    }
    public void clicklogin()
    {
        WaitUtils.waitForElementVisible(driver, loginbtn);
        driver.findElement(loginbtn).click();
    }
    
    
    public void login(String userName, String pass)
    {
        enterUsername(userName);
        enterPassword(pass);
        clicklogin();
        
    }
}

