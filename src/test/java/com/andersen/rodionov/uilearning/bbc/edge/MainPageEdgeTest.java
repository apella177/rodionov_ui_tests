package com.andersen.rodionov.uilearning.bbc.edge;

import com.andersen.rodionov.uilearning.bbc.MainPage;
import com.andersen.rodionov.uilearning.bbc.NewsPage;
import com.andersen.rodionov.uilearning.drivers.DriverEdge;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainPageEdgeTest {
    private WebDriver driver;
    private MainPage mainPage;
    private NewsPage newsPage;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.edge.driver", "src\\main\\resources\\msedgedriver.exe");

        mainPage = new MainPage();
        newsPage = new NewsPage();
        driver = DriverEdge.getInstance();
    }
    @Test
    public void checkSearchInput() {

        driver.get("https://www.bbc.com/");
        mainPage.waitUntilPageLoaded(driver);

        Assert.assertTrue(mainPage.isDisplayedSearchField(), "Строка поиска не отображается");

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
