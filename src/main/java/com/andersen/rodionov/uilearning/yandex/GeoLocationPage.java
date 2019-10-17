package com.andersen.rodionov.uilearning.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class GeoLocationPage {

    @FindBy(css = "#city__front-input")
    private WebElement cityInput;

    @FindBy(css = ".popup__items li:first-child")
    private WebElement firstElementGeoList;

    private final WebDriver driver;

    void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public GeoLocationPage(WebDriver driver) {
        this.driver = driver;
    }

    void clickFirstElementGeoList() {
        new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(firstElementGeoList));
        firstElementGeoList.click();
    }

    void setGeoLocation(String city) {
        cityInput.clear();
        cityInput.sendKeys(city);
    }
}

