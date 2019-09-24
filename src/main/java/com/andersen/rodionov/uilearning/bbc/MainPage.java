package com.andersen.rodionov.uilearning.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    @FindBy ( css = "#orb-search-q")
    private WebElement searchBox;

    @FindBy(css = "#orb-nav-links li:nth-child(3)")
    private WebElement newsButton;

    public MainPage() {
    }

    public void waitUntilPageLoaded(WebDriver driver) {
        try {
            new WebDriverWait(driver, 3);
            init(driver);
        } catch (Exception e) {
            System.out.println("Ошибка загрузки страницы");
        }
    }

    public void clickSearchBox() {
        searchBox.click();
    }

    public void sendKeysToSearchBox(String text) {
        searchBox.sendKeys(text);
    }

    public void clickNewsButton() {
        newsButton.click();
    }

    private void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isSearchDisplayed() {
        return searchBox.isDisplayed();
    }

    public boolean isSearchEnabled() {
        return searchBox.isEnabled();
    }
}

