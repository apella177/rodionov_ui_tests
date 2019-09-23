package com.andersen.rodionov.uilearning.bbc.edge;

import com.andersen.rodionov.uilearning.bbc.MainPage;
import com.andersen.rodionov.uilearning.drivers.DriverEdge;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MainPageTestEdge {
    private WebDriver driver;
    private MainPage mainPage;

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
        mainPage.init(driver);
        System.out.println(mainPage.isSearchDisplayed());
        System.out.println(mainPage.isSearchEnabled());
        mainPage.clickOnSearch();
        mainPage.sendKeysOnSearch("USA");

        Thread.sleep(5000);
        mainPage.clickNavigateElement();
        Thread.sleep(3000);
    }

    @AfterTest
    public void close() {
        driver.quit();
        System.out.println("Окончание теста");
    }

}
