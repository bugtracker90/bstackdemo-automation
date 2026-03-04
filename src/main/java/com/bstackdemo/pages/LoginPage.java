package com.bstackdemo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class LoginPage {

    WebDriver driver;
    WebDriverWait wait;

public LoginPage(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
}    
    // Locators
    private By signInButton = By.id("signin");
    private By usernameDropdown = By.id("react-select-2-input");
    private By passwordDropdown = By.id("react-select-3-input");
    private By loginButton = By.id("login-btn");

    // Actions
    public void clickSignIn() {
        driver.findElement(signInButton).click();
    }

    public void selectUsername(String username) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameDropdown));
        driver.findElement(usernameDropdown).sendKeys(username);
        driver.findElement(usernameDropdown).sendKeys("\n");
    }

    public void selectPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordDropdown));
        driver.findElement(passwordDropdown).sendKeys(password);
        driver.findElement(passwordDropdown).sendKeys("\n");
    }
        public void clickLogin() {
        driver.findElement(loginButton).click();
    }
        public boolean isUserLoggedIn() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin")));
            String text = driver.findElement(By.id("signin")).getText().trim();
            return text.equals("Logout");
        }
        
        public boolean isLoginButtonVisible() {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signin")));
            String text = driver.findElement(By.id("signin")).getText().trim();
            return text.equals("Sign In");
        }
        
        public boolean isLogoutVisible() {
            String actualText = driver.findElement(By.id("signin")).getText();
            System.out.println("Actual text is: [" + actualText + "]");
            return actualText.equals("Logout");
        
        }
        public boolean isLoginModalStillOpen() {
            return driver.findElement(By.id("login-btn")).isDisplayed();
        }
        }
 