package com.bstackdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Locator for first product "Add to Cart" button
    private By firstAddToCartBtn =
            By.cssSelector(".shelf-item__buy-btn");

    // Locator for cart badge count
    private By cartBadge = By.className("bag__quantity");

    public void addFirstProductToCart() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.className("shelf-container")
        ));

        wait.until(ExpectedConditions.presenceOfElementLocated(firstAddToCartBtn));

        org.openqa.selenium.WebElement button =
                driver.findElement(firstAddToCartBtn);

        ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", button);
    }
    public void addProductByIndex(int index) {

        By productBtn = By.xpath("(//div[@class='shelf-item__buy-btn'])[" + index + "]");

        wait.until(ExpectedConditions.elementToBeClickable(productBtn));

        WebElement button = driver.findElement(productBtn);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", button);
    }
    public String getCartCount() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartBadge));
        return driver.findElement(cartBadge).getText();
    }
}