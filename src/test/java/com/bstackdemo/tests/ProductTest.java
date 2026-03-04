package com.bstackdemo.tests;

import com.bstackdemo.base.BaseTest;
import com.bstackdemo.pages.CartPage;
import com.bstackdemo.pages.CheckoutPage;
import com.bstackdemo.pages.LoginPage;
import com.bstackdemo.pages.ProductPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductTest extends BaseTest {

    // TC_004: Add single item to cart
    @Test(groups = {"smoke", "regression"})
    public void verifyAddProductToCart() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignIn();
        loginPage.selectUsername("demouser");
        loginPage.selectPassword("testingisfun99");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isUserLoggedIn(),
                "Login failed, cannot proceed");

        // Add product
        ProductPage productPage = new ProductPage(driver);
        productPage.addFirstProductToCart();

        // Verify cart count
        String cartCount = productPage.getCartCount();
        Assert.assertEquals(cartCount, "1",
                "Product was not added to cart properly");
    }


    // TC_007: Complete purchase flow
    @Test(groups = {"regression"})
    public void verifyCompletePurchaseFlow() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignIn();
        loginPage.selectUsername("demouser");
        loginPage.selectPassword("testingisfun99");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isUserLoggedIn(),
                "Login failed");

        // Add product
        ProductPage productPage = new ProductPage(driver);
        productPage.addFirstProductToCart();

        // Checkout
        CartPage cartPage = new CartPage(driver);
        cartPage.clickCheckout();

        // Fill checkout form
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        checkoutPage.fillCheckoutForm(
                "Sana",
                "Mohsin",
                "123 Street",
                "Maharashtra",
                "440001"
        );

        // Submit order
        checkoutPage.submitOrder();

        // Validate success message
        String successMsg = checkoutPage.getSuccessMessage();

        Assert.assertTrue(successMsg.contains("successfully placed"),
                "Order was not completed successfully");
    }


    // TC_005: Add multiple items to cart
    @Test(groups = {"regression"})
    public void verifyMultipleItemsAddedToCart() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignIn();
        loginPage.selectUsername("demouser");
        loginPage.selectPassword("testingisfun99");
        loginPage.clickLogin();

        Assert.assertTrue(loginPage.isUserLoggedIn());

        // Add multiple products
        ProductPage productPage = new ProductPage(driver);
        productPage.addProductByIndex(1);
        productPage.addProductByIndex(2);

        // Validate cart count
        String cartCount = productPage.getCartCount();

        Assert.assertEquals(cartCount, "2",
                "Cart count is incorrect");
    }


    // TC_006: Remove item from cart
    @Test(groups = {"regression"})
    public void verifyRemoveItemFromCart() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignIn();
        loginPage.selectUsername("demouser");
        loginPage.selectPassword("testingisfun99");
        loginPage.clickLogin();

        // Add product
        ProductPage productPage = new ProductPage(driver);
        productPage.addFirstProductToCart();

        // Remove product
        CartPage cartPage = new CartPage(driver);
        cartPage.removeItem();

        // Validate cart empty
        String cartCount = productPage.getCartCount();

        Assert.assertEquals(cartCount, "0",
                "Item was not removed from cart");
    }


    // TC_008: Checkout without adding items (Negative Test)
    @Test(groups = {"negative"})
    public void verifyCheckoutWithoutItems() {

        // Login
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickSignIn();
        loginPage.selectUsername("demouser");
        loginPage.selectPassword("testingisfun99");
        loginPage.clickLogin();

        // Open cart
        CartPage cartPage = new CartPage(driver);
        cartPage.openCart();

        // Validate checkout is not available
        Assert.assertFalse(driver.getPageSource().contains("Checkout"),
                 "Checkout should not be available with empty cart");
    }
}