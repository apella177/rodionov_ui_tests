package com.andersen.rodionov.uilearning.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

    public class MainPage {
    @FindBy (css = "#orb-search-q")
    private WebElement searchBox;
    
    @FindBy (css = "#orb-nav-links li:nth-child(3)")
    private WebElement navigateBlock;

        public MainPage() {
        }

        public void clickOnSearch() {
        searchBox.click();
    }

    public void sendKeysOnSearch(String text) {
        searchBox.sendKeys(text);
    }

    public void clickNavigateElement() {
        navigateBlock.click();
    }

    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isSearchDisplayed() {
        return searchBox.isDisplayed();
    }

    public boolean isSearchEnabled() {
        return searchBox.isEnabled();
    }
}

