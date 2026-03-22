package com.nandini.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class WaitUtils 
{
    public static WebElement waitForElementVisible(WebDriver driver, By locator)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    public static WebElement waitForElementClickable(WebDriver driver, By locator)
    {
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
    public static void waitForTextToBePresent(WebDriver driver, By locator, String text) 
    {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.textToBePresentInElementLocated(locator, text));
    }

    public static boolean waitForElementInvisible(WebDriver driver, By locator) 
    {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }


public static void click(WebDriver driver, By locator) {
    WebElement element = waitForElementClickable(driver, locator);

    try 
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);element.click();
    }   
    catch (Exception e) 
    {
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
    }

}}
