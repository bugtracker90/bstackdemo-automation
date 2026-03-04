package com.bstackdemo.tests;

import com.bstackdemo.base.BaseTest;
import com.bstackdemo.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void verifyValidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickSignIn();
        loginPage.selectUsername("demouser");
        loginPage.selectPassword("testingisfun99");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isUserLoggedIn(), 
                "Expected login success but failed");
    }

    @Test(groups = {"negative", "regression"})
    public void verifyInvalidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.clickSignIn();
        loginPage.selectUsername("demouser");
        loginPage.selectPassword("wrongpass");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isLoginModalStillOpen(),
                "Expected login failure but modal closed");
    }
}