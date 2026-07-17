package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ConfigReader;
import utils.DataProviderClass;

public class CheckoutTest extends BaseTest {

    @Test(dataProvider = "CheckoutData",
          dataProviderClass = DataProviderClass.class)
    public void checkoutTest(String testCaseID,
                             String firstName,
                             String lastName,
                             String postalCode) {

        System.out.println("==============================");
        System.out.println("Executing : " + testCaseID);

        // Login
        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        // Verify Login
        Assert.assertEquals(
                shoppingPage.getProductsTitle(),
                "Products");

        // Add Product
        shoppingPage.addBackpack();

        // Verify Cart Count
        Assert.assertEquals(
                shoppingPage.getCartCount(),
                "1");

        // Open Cart
        shoppingPage.openCart();

        // Checkout
        checkoutPage.clickCheckout();

        // Customer Details
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterPostalCode(postalCode);

        // Continue
        checkoutPage.clickContinue();

        // Verify Overview Page
        Assert.assertTrue(
                checkoutPage.isCheckoutOverviewDisplayed());

        System.out.println(testCaseID + " Passed");
    }
}