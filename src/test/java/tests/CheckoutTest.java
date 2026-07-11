package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class CheckoutTest extends BaseTest {

    @Test
    public void completeOrderTest() {

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Verify Products Page
        Assert.assertEquals(shoppingPage.getProductsTitle(), "Products");

        // Add Product
        shoppingPage.addBackpack();

        // Open Cart
        shoppingPage.openCart();

        // Checkout
        checkoutPage.clickCheckout();

        // Customer Information
        checkoutPage.enterFirstName("Balamurugan");
        checkoutPage.enterLastName("K");
        checkoutPage.enterPostalCode("600048");

        checkoutPage.clickContinue();

        // Finish Order
        checkoutPage.clickFinish();

        // Verification
        Assert.assertEquals(
                checkoutPage.getConfirmationMessage(),
                "Thank you for your order!"
        );

        System.out.println("Order Placed Successfully");
    }
}
