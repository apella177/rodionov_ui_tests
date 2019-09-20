package com.andersen.rodionov.uilearning.bbc.chrome;

import com.andersen.rodionov.uilearning.bbc.MainPage;
import com.andersen.rodionov.uilearning.drivers.DriverChrome;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainPageTestChrome {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        mainPage = new MainPage();
        driver = DriverChrome.getInstance();
        System.out.println("Запуск теста");
    }

    @Test
    public void firstTest() throws InterruptedException {
        driver.get("https://www.bbc.com/");
        mainPage.init(driver);
        System.out.println(mainPage.isSearchDispalyed());
        System.out.println(mainPage.isSearchEnabled());
        mainPage.clickOnSearch();
        mainPage.sendKeysOnSearch("USA");

        Thread.sleep(5000);
        mainPage.clickElement();
        Thread.sleep(3000);
    }

    @AfterTest
    public void close() {
        driver.quit();
        System.out.println("Окончание теста");
    }

}
