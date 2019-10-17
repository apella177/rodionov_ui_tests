package com.andersen.rodionov.uilearning.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

class GeoLocationPage {
    private WebDriver driver;

    @FindBy (css = "#city__front-input")
    private WebElement cityInput;

    @FindBy (css = ".popup__items li:first-child")
    private WebElement firstElementGeoList;

    public GeoLocationPage (WebDriver driver) {
        this.driver = driver;

    }
    void clickFirstElementGeoList() {
        initPageElements();
        new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(firstElementGeoList));
        firstElementGeoList.click();
    }

    private void initPageElements() { PageFactory.initElements(driver, this);
    }


    void setGeoLocation(String city) {
        initPageElements();
        cityInput.clear();
        cityInput.sendKeys(city);
    }
}

