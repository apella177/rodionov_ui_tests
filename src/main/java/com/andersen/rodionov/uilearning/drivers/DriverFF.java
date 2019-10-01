package com.andersen.rodionov.uilearning.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class DriverFF {
        private static WebDriver driver;

        private DriverFF() {
        }

        public static WebDriver getInstance() {
            if (driver == null) {
                driver = new FirefoxDriver();
            }
            return driver;
        }
}
