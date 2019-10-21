package com.andersen.rodionov.uilearning;

import com.andersen.rodionov.uilearning.drivers.DriverChrome;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    protected WebDriver driver;

    @BeforeTest
    public void setInit() {
        driver = DriverChrome.getInstance();
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
