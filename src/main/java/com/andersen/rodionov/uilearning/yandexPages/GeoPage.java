package com.andersen.rodionov.uilearning.yandexPages;

import com.andersen.rodionov.uilearning.drivers.DriverChrome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeoPage {
    @FindBy(css = "#city__front-input")
    private WebElement cityInput;

    @FindBy(css = ".popup__items li:nth-child(1)")
    private WebElement firstElementPopup;

    public void setGeoLocation(String city) {
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void clickFirstElementGeoList() {
        new WebDriverWait(DriverChrome.getInstance(), 3).until(ExpectedConditions.elementToBeClickable(firstElementPopup));
        firstElementPopup.click();
    }
}
