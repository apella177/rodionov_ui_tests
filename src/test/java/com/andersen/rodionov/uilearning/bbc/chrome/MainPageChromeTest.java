package com.andersen.rodionov.uilearning.bbc.chrome;

import com.andersen.rodionov.uilearning.bbc.MainPage;
import com.andersen.rodionov.uilearning.bbc.NewsPage;
import com.andersen.rodionov.uilearning.drivers.DriverChrome;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainPageChromeTest {
    private WebDriver driver;
    private MainPage mainPage;
    private NewsPage newsPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");

        mainPage = new MainPage();
        newsPage = new NewsPage();
        driver = DriverChrome.getInstance();
    }

    @Test
    public void checkSearchInput() {

        driver.get("https://www.bbc.com/");
        mainPage.waitUntilPageLoaded(driver);

        Assert.assertTrue(mainPage.isSearchDisplayed(), "Строка поиска не отображается");

        mainPage.clickSearchInput();
        mainPage.setToSearchInput("USA");
    }

    @Test
    public void clickNewsButton() {

        driver.get("https://www.bbc.com/");
        mainPage.waitUntilPageLoaded(driver);

        mainPage.clickNewsButton();
        newsPage.waitUntilPageLoaded(driver);
    }

    @AfterTest
    public void close() {
        driver.quit();
    }

}
