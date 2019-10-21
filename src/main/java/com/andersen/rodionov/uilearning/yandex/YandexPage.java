package com.andersen.rodionov.uilearning.yandex;

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
    private WebElement geoLocation;

    @FindBy(css = ".home-link.home-tabs__more-switcher")
    private WebElement moreButton;

    @FindBy(css = "div.home-tabs__more")
    private List<WebElement> moreElementsMenu;

    private WebDriver driver;

    YandexPage(WebDriver driver) {
        this.driver = driver;
    }

    void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    void clickGeo() {
        geoLocation.click();
    }

    void clickMoreButton() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(moreButton));
        moreButton.click();
    }

    List<String> getMoreElementMenu() {
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOfAllElements(moreElementsMenu));

        List<String> elements = new ArrayList<>();
        for (WebElement moreMenu : moreElementsMenu)
            elements.add(moreMenu.getText());
        return elements;
    }
}
