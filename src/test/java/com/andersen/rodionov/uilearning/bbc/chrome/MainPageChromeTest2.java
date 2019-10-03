package com.andersen.rodionov.uilearning.bbc.chrome;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class MainPageChromeTest2 {

    @Test
    public void checkSearchInput() throws Exception {

        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bbc.com");

        waitElementIsDisplayed(driver.findElement(By.cssSelector("#orb-search-q")));
        waitElementIsEnabled(driver.findElement(By.cssSelector("#orb-search-q")));

        driver.findElement(By.cssSelector("#orb-search-q")).isDisplayed();
        driver.findElement(By.cssSelector("#orb-search-q")).clear();
        driver.findElement(By.cssSelector("#orb-search-q")).click();
        driver.findElement(By.cssSelector("#orb-search-q")).sendKeys("USA");
        driver.quit();
    }

    @Test
    public void clickNewsButton() {

        System.setProperty ("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.bbc.com");

        driver.findElement(By.cssSelector("#orb-nav-links li:nth-child(2)")).click();
        driver.quit();
    }

    private static void waitElementIsDisplayed(WebElement element) throws Exception {
        int maxCount = 50;
        int currentCount = 0;
        while (!element.isDisplayed() && currentCount < maxCount) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentCount++;
        }
        if (currentCount >= maxCount) {
            throw new Exception("Элемент не найден");
        }
    }

    private static void waitElementIsEnabled(WebElement element) throws Exception {
        int maxCount = 50;
        int currentCount = 0;
        while (!element.isEnabled() && currentCount < maxCount) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            currentCount++;
        }
        if (currentCount >= maxCount) {
            throw new Exception("Элемент не доступен");
        }
    }
}
