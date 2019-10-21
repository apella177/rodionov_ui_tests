package com.andersen.rodionov.uilearning.yandexPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class YandexPage {
    @FindBy(css = ".geolink__reg")
    private WebElement geoLocationButton;

    @FindBy(css = ".home-link.home-tabs__more-switcher")
    private WebElement moreButton;

    @FindBy(css = "div.home-tabs__more")
    private List<WebElement> moreElementsPopup;

    private WebDriver driver;

    public void init(final WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    void clickGeo() {
        geoLocationButton.click();
    }

    void clickMoreButton() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(moreButton));
        moreButton.click();
    }

    List<String> getMoreElementMenu() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElements(moreElementsPopup));

        List<String> elements = new ArrayList<>();
        for (WebElement moreMenu : moreElementsPopup)
            elements.add(moreMenu.getText());
        return elements;
    }
}