package com.bstackdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CartPage {

    WebDriver driver;
    WebDriverWait wait;

    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    

    // Cart icon
    private By cartIcon = By.className("bag");

    // Checkout button
    private By checkoutButton = By.cssSelector(".buy-btn");

    public void openCart() {
        wait.until(ExpectedConditions.elementToBeClickable(cartIcon));
        driver.findElement(cartIcon).click();
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
        driver.findElement(checkoutButton).click();
    }
    private By removeItemBtn = By.className("shelf-item__del");

    public void removeItem() {

        wait.until(ExpectedConditions.elementToBeClickable(removeItemBtn));
        driver.findElement(removeItemBtn).click();
    }
}