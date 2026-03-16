package com.nandini.automation.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import com.nandini.automation.utils.ConfigReader;

import io.github.bonigarcia.wdm.WebDriverManager;
@Listeners(com.nandini.automation.utils.TestListener.class)
public class BaseTest {
    public static WebDriver driver;

    @BeforeMethod
    
    public void setup()
    {
        ConfigReader config = new ConfigReader();
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();

        driver.manage().window().maximize();
        driver.get(config.getProperty("baseUrl"));

    }

    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

}
