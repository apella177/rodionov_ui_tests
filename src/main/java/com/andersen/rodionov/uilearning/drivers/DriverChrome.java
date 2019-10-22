package com.andersen.rodionov.uilearning.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverChrome {
    private static WebDriver driver;

    private DriverChrome() {
    }
    public static WebDriver getInstance() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
            driver = new ChromeDriver();
        }
        return driver;
    }
}
