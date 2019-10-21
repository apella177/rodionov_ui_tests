package com.andersen.rodionov.uilearning.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeoPage {
    @FindBy(css = "#city__front-input")
    private WebElement setCity;

    @FindBy(css = ".popup__items li:nth-child(1)")
    private WebElement firstElementGeoList;

    private WebDriver driver;

    public GeoPage(WebDriver driver) {
        this.driver = driver;
    }

    void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    void setGeoLocation(String city) {
        setCity.click();
        setCity.clear();
        setCity.sendKeys(city);
    }

    void clickFirstElementGeoList() {
        new WebDriverWait(driver, 3).until(ExpectedConditions.elementToBeClickable(firstElementGeoList));
        firstElementGeoList.click();
    }
}
