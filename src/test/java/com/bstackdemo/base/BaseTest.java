package com.bstackdemo.base;

import com.bstackdemo.utils.ConfigReader;
import com.bstackdemo.utils.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {

        // Create driver from WebDriverFactory
    	driver = WebDriverFactory.createDriver();

        // Maximize browser
        driver.manage().window().maximize();

        // Open application URL from config.properties
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}