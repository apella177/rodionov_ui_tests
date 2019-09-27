package com.andersen.rodionov.uilearning.bbc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewsPage {
    public void waitUntilPageLoaded(WebDriver driver) {
        try {
            new WebDriverWait(driver, 5);
        } catch (Exception ignore) {
        }
    }
}
