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
        System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");

        mainPage = new MainPage();
        driver = DriverEdge.getInstance();
        System.out.println("Запуск теста");
    }

    @Test
    public void firstTest() throws InterruptedException {
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
