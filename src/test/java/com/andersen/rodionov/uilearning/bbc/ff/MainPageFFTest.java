package com.andersen.rodionov.uilearning.bbc.ff;

import com.andersen.rodionov.uilearning.bbc.MainPage;
import com.andersen.rodionov.uilearning.bbc.NewsPage;
import com.andersen.rodionov.uilearning.drivers.DriverFF;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainPageFFTest {
    private WebDriver driver;
    private MainPage mainPage;
    private NewsPage newsPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");

        mainPage = new MainPage();
        newsPage = new NewsPage();
        driver = DriverFF.getInstance();
        System.out.println("Запуск теста");
    }

    @Test
    public void firstTest() {
        driver.get("https://www.bbc.com/");
        mainPage.waitUntilPageLoaded(driver);

        Assert.assertTrue(mainPage.isSearchDisplayed(), "Строка поиска не отображается");
        Assert.assertTrue(mainPage.isSearchEnabled(), "Строка поиска неактивна");

        mainPage.clickSearchBox();
        mainPage.sendKeysToSearchBox("USA");

        mainPage.clickNewsButton();
        newsPage.waitUntilPageLoaded(driver);
    }

    @AfterTest
    public void close() {
        driver.quit();
        System.out.println("Окончание теста");
    }

}
