package com.bstackdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Checkout form fields
    private By firstName = By.id("firstNameInput");
    private By lastName = By.id("lastNameInput");
    private By address = By.id("addressLine1Input");
    private By province = By.id("provinceInput");
    private By postalCode = By.id("postCodeInput");
    private By placeOrderBtn = By.cssSelector(".buy-btn");

    private By submitOrderBtn = By.id("checkout-shipping-continue");
    // Order success message
    private By successHeader = By.id("confirmation-message");

    public void fillCheckoutForm(String fName, String lName,
                                 String addr, String state, String zip) {

        wait.until(ExpectedConditions.visibilityOfElementLocated(firstName));

        driver.findElement(firstName).sendKeys(fName);
        driver.findElement(lastName).sendKeys(lName);
        driver.findElement(address).sendKeys(addr);
        driver.findElement(province).sendKeys(state);
        driver.findElement(postalCode).sendKeys(zip);
    }

    public void submitOrder() {

        wait.until(ExpectedConditions.elementToBeClickable(submitOrderBtn));
        driver.findElement(submitOrderBtn).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    }  	public String getSuccessMessage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(successHeader));
        return driver.findElement(successHeader).getText();
    }
}