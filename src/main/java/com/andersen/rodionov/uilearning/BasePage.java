package com.andersen.rodionov.uilearning;

import com.andersen.rodionov.uilearning.drivers.DriverChrome;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected void scrollToElement(WebElement element) {
        ((JavascriptExecutor) DriverChrome.getInstance()).executeScript("document.scrollIntoView(true);", element);
    }

    protected void waitJQuery() {
        (new WebDriverWait(DriverChrome.getInstance(), 5000)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                return (Boolean) js.executeScript("return jQuery.active == 0");
            }
        });
    }
}
