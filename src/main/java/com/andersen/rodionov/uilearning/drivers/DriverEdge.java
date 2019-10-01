package com.andersen.rodionov.uilearning.drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DriverEdge {
    private static WebDriver driver;

    private DriverEdge() {
    }

    public static WebDriver getInstance() {
        if (driver == null) {
            driver = new EdgeDriver();
        }
        return driver;
    }
}

