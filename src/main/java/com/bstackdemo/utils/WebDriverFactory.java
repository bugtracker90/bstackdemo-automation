package com.bstackdemo.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverFactory {

    public static WebDriver createDriver() {

        String browser = ConfigReader.getProperty("browser");

        if (browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else {

            throw new RuntimeException("Browser not supported: " + browser);
        }
    }
}