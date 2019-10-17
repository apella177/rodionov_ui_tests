package com.andersen.rodionov.uilearning.yandex;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

class MainPage {

    @FindBy(className = "geolink__reg")
    private WebElement geoLocation;

    @FindBy(css = ".home-link.home-tabs__more-switcher")
    private WebElement moreButton;

    @FindBy(css = ".home-tabs__more")
    private List<WebElement> moreElements;


    void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    private final WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    void clickMoreButton() {
        new WebDriverWait(driver, 1).until(ExpectedConditions.elementToBeClickable(moreButton));
        moreButton.click();
    }

    void clickGeoLocation() {
        geoLocation.click();
    }

    List<String> getMoreElements() {
        new WebDriverWait(driver, 1).until(ExpectedConditions.visibilityOfAllElements(moreElements));

        List<String> elements = new ArrayList<>();
        for (WebElement morePanel : moreElements)
            elements.add(morePanel.getText());
        return elements;
    }
}
