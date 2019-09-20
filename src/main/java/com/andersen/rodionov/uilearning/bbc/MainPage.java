package com.andersen.rodionov.uilearning.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    @FindBy(css = "#orb-search-q")
    private WebElement search;
    @FindBy(css = "#orb-nav-links li:nth-child(2)")
    private WebElement navigelement;

    public void clickOnSearch() {
        search.click();
    }

    public void sendKeysOnSearch(String a) {
        search.sendKeys(a);
    }

    public void clickElement() {
        navigelement.click();
    }

    public void init(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public boolean isSearchDispalyed () {
        return search.isDisplayed();
    }
    public boolean isSearchEnabled () {
        return search.isEnabled();
    }
}

