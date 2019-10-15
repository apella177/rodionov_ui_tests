package com.andersen.rodionov.uilearning.yandex;

import com.andersen.rodionov.uilearning.drivers.DriverChrome;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestYandexPage {

    private WebDriver driver;
    private MainPage mainPage;
    private GeoLocationPage geoLocationPage;

    @BeforeTest
    public void setInit() {

        mainPage = new MainPage();
        geoLocationPage = new GeoLocationPage();

        driver = DriverChrome.getInstance();
        driver.get("https://yandex.ru");
    }

    @Test
    public void testComparisonMoreMenu() {
        mainPage.init(driver);
        mainPage.clickGeoLocation();

        geoLocationPage.init(driver);
        geoLocationPage.clearCityInput();
        geoLocationPage.setGeoLocation("Лондон");
        geoLocationPage.clickFirstElementGeoList(driver);

        mainPage.init(driver);
        mainPage.clickMoreButton(driver);
        List<String> elements1 = mainPage.getMoreElements(driver);
        mainPage.clickGeoLocation();

        geoLocationPage.init(driver);
        geoLocationPage.clearCityInput();
        geoLocationPage.setGeoLocation("Париж");
        geoLocationPage.clickFirstElementGeoList(driver);

        mainPage.init(driver);
        mainPage.clickMoreButton(driver);
        List<String> elements2 = mainPage.getMoreElements(driver);

        Assert.assertEquals(elements1, elements2, "Коллекции не совпадают");
    }

    @AfterTest
    public void close() { driver.quit();
    }
}
