package com.andersen.rodionov.uilearning.yandexPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeoPage {
    @FindBy(css = "#city__front-input")
    private WebElement cityInput;

    @FindBy(css = ".popup__items li:nth-child(1)")
    private WebElement firstElementPopup;

    private WebDriver driver;

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void setGeoLocation(String city) {
        cityInput.click();
        cityInput.clear();
        cityInput.sendKeys(city);
    }

    public void clickFirstElementGeoList() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(firstElementPopup));
        firstElementPopup.click();
    }
}
