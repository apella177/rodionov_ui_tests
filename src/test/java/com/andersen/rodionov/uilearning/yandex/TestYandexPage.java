package com.andersen.rodionov.uilearning.yandex;

import com.andersen.rodionov.uilearning.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class TestYandexPage extends BaseTest {

    private MainPage mainPage;
    private GeoLocationPage geoLocationPage;

    @BeforeTest
    public void setInit() {
        super.setInit();
        mainPage = new MainPage(driver);
        geoLocationPage = new GeoLocationPage(driver);

        driver.get("https://yandex.ru");
    }

    @Test
    public void testComparisonMoreMenu() {

        mainPage.clickGeoLocation();

        geoLocationPage.setGeoLocation("Лондон");
        geoLocationPage.clickFirstElementGeoList();

        mainPage.clickMoreButton();
        List<String> elements1 = mainPage.getMoreElements();
        mainPage.clickGeoLocation();

        geoLocationPage.setGeoLocation("Париж");
        geoLocationPage.clickFirstElementGeoList();

        mainPage.clickMoreButton();
        List<String> elements2 = mainPage.getMoreElements();

        Assert.assertEquals(elements1, elements2, "Коллекции не совпадают");
    }
}
