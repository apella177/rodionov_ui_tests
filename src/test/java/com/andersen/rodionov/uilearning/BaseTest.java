package com.andersen.rodionov.uilearning;

import com.andersen.rodionov.uilearning.drivers.DriverChrome;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    protected static WebDriver driver;

    @BeforeClass
    public void setup() {
        driver = DriverChrome.getInstance();
    }

    @AfterTest
    public void close() {
        driver.quit();
    }
}
