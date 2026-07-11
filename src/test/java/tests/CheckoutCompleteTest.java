package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class CheckoutCompleteTest extends BaseTest {

    @Test
    public void checkoutCompleteTest() {

        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        shoppingPage.addBackpack();
        shoppingPage.openCart();

        cartPage.clickCheckout();

        checkoutPage.enterFirstName("Hasshnii");
        checkoutPage.enterLastName("M");
        checkoutPage.enterPostalCode("600001");

        checkoutPage.clickContinue();

        checkoutCompletePage.clickFinish();

        Assert.assertEquals(
                checkoutCompletePage.getConfirmationMessage(),
                "Thank you for your order!"
        );
    }
}

