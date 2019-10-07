package com.andersen.rodionov.uilearning.bbc.chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
import org.testng.Assert;

public class TestMainPage {

    private WebDriver driver;

    @BeforeGroups(groups = {"smokeTests", "regressionTests"})
    public void setInit() {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.bbc.com");
    }


    @Test(groups = {"smokeTests", "regressionTests"})
    public void testcheckSearchInput() throws Exception {

        waitElementIsDisplayed(driver.findElement(By.cssSelector("#orb-search-q")));
        waitElementIsEnabled(driver.findElement(By.cssSelector("#orb-search-q")));

        Assert.assertTrue(driver.findElement(By.cssSelector("#orb-search-q")).isDisplayed(), "Элемент не доступен");
        Assert.assertTrue(driver.findElement(By.cssSelector("#orb-search-q")).isEnabled(), "Элемент не активен");

        driver.findElement(By.cssSelector("#orb-search-q")).clear();
        driver.findElement(By.cssSelector("#orb-search-q")).click();
        driver.findElement(By.cssSelector("#orb-search-q")).sendKeys("USA");

    }

    @Test(groups = {"smokeTests"})
    public void testclickNewsButton() {

        driver.findElement(By.cssSelector("#orb-nav-links li:nth-child(2)")).click();
    }

    private static void waitElementIsDisplayed(WebElement element) throws Exception {
        int maxCount = 50;
        int currentCount = 0;
        while (!element.isDisplayed() && currentCount < maxCount) {
            Thread.sleep(100);
            currentCount++;
        }
    }

    private static void waitElementIsEnabled(WebElement element) throws Exception {
        int maxCount = 50;
        int currentCount = 0;
        while (!element.isEnabled() && currentCount < maxCount) {
            Thread.sleep(100);
            currentCount++;
        }
    }

    @AfterGroups(groups = {"smokeTests", "regressionTests"})
    public void close() {
        driver.quit();
    }
}
