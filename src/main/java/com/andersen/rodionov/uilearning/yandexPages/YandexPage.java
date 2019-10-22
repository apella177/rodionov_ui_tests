package com.andersen.rodionov.uilearning.yandexPages;

import com.andersen.rodionov.uilearning.drivers.DriverChrome;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
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


    public void clickGeo() {
        geoLocationButton.click();
    }

    public void clickMoreButton() {
        new WebDriverWait(DriverChrome.getInstance(), 2).until(ExpectedConditions.elementToBeClickable(moreButton));
        moreButton.click();
    }

    public List<String> getMoreElementMenu() {
        new WebDriverWait(DriverChrome.getInstance(), 2).until(ExpectedConditions.visibilityOfAllElements(moreElementsPopup));

        List<String> elements = new ArrayList<>();
        for (WebElement moreMenu : moreElementsPopup)
            elements.add(moreMenu.getText());
        return elements;
    }
}
