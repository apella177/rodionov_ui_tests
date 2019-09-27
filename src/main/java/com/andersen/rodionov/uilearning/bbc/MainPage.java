package com.andersen.rodionov.uilearning.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    @FindBy(css = "#orb-search-q")
    private WebElement searchInput;

    @FindBy(css = "#orb-nav-links li:nth-child(2)")
    private WebElement newsButton;


    public void waitUntilPageLoaded(WebDriver driver) {
        try {
            new WebDriverWait(driver, 5);
            init(driver);
        } catch (Exception ignore) {}
    }

    public void setToSearchInput(String text) {
        searchInput.click();
        searchInput.sendKeys(text);
    }

    public void clickNewsButton() {
        newsButton.click();
    }

    private void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isDisplayedSearchField() {
        return searchInput.isDisplayed();
    }
}


