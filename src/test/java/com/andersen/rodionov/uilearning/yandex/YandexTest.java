package com.andersen.rodionov.uilearning.yandex;

import com.andersen.rodionov.uilearning.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class YandexTest extends BaseTest {

    private YandexPage yandexPage;
    private GeoPage geoPage;

    @BeforeTest
    public void setInit() {
        super.setInit();

        yandexPage = new YandexPage(driver);
        geoPage = new GeoPage(driver);

        yandexPage.init(driver);
        geoPage.init(driver);
    }

    @Test
    public void testMoreMenu() {
        driver.get("https://yandex.ru");
        yandexPage.clickGeo();

        geoPage.setGeoLocation("Лондон");
        geoPage.clickFirstElementGeoList();

        yandexPage.clickMoreButton();
        List<String> elements1 = yandexPage.getMoreElementMenu();
        yandexPage.clickGeo();

        geoPage.setGeoLocation("Париж");
        geoPage.clickFirstElementGeoList();

        yandexPage.clickMoreButton();
        List<String> elements2 = yandexPage.getMoreElementMenu();

        Assert.assertEquals(elements1, elements2, "Коллекции не совпадают");
    }

}
