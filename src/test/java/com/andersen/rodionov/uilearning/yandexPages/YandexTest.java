package com.andersen.rodionov.uilearning.yandexPages;

import com.andersen.rodionov.uilearning.BaseTest;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;

public class YandexTest extends BaseTest {

    private YandexPage yandexPage;
    private GeoPage geoPage;

    @BeforeClass
    public void setInit() {
        yandexPage = PageFactory.initElements(driver, YandexPage.class);
        geoPage = PageFactory.initElements(driver, GeoPage.class);
    }

    @Test
    public void testMoreMenu() {
        driver.get("https://yandex.ru");
        yandexPage.clickGeo();

        geoPage.setGeoLocation("Лондон");
        geoPage.clickFirstElementGeoList();

        yandexPage.clickMoreButton();
        List<String> collectionMoreMenuLondon = yandexPage.getMoreElementMenu();
        yandexPage.clickGeo();

        geoPage.setGeoLocation("Париж");
        geoPage.clickFirstElementGeoList();

        yandexPage.clickMoreButton();
        List<String> collectionMoreMenuParis = yandexPage.getMoreElementMenu();

        Assert.assertEquals(collectionMoreMenuLondon, collectionMoreMenuParis, "Коллекции не совпадают!");
    }

}

