package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class SwagLabsEndToEndTest extends BaseTest {

    @Test
    public void endToEndTest() {

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Verify Products Page
        Assert.assertEquals(
                shoppingPage.getProductsTitle(),
                "Products"
        );

        // Add Product to Cart
        shoppingPage.addBackpack();

        // Verify Cart Count
        Assert.assertEquals(
                shoppingPage.getCartCount(),
                "1"
        );

        // Open Cart
        shoppingPage.openCart();

        // Checkout
        checkoutPage.clickCheckout();

        // Customer Details
        checkoutPage.enterFirstName("Hasshnii");
        checkoutPage.enterLastName("M");
        checkoutPage.enterPostalCode("600001");

        // Continue Checkout
        checkoutPage.clickContinue();

        // Finish Order
        checkoutPage.clickFinish();

        // Verify Order Success
        String actualMessage =
                checkoutPage.getConfirmationMessage();

        Assert.assertEquals(
                actualMessage,
                "Thank you for your order!"
        );

        System.out.println("Swag Labs End To End Test Passed");
    }
}