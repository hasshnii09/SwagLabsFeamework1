package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ConfigReader;
import utils.DataProviderClass;

public class SwagLabsEndToEndTest extends BaseTest {

    @Test(dataProvider = "CheckoutData",
          dataProviderClass = DataProviderClass.class)
    public void endToEndTest(String testCaseID,
                             String firstName,
                             String lastName,
                             String postalCode) {

        System.out.println("\n========================================");
        System.out.println("Executing Test Case : " + testCaseID);
        System.out.println("========================================");

        // Login
        System.out.println("Step 1: Logging into Swag Labs...");
        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));
        System.out.println("Login details entered.");

        // Verify Login
        Assert.assertEquals(
                shoppingPage.getProductsTitle(),
                "Products",
                "Login Failed!");
        System.out.println("âœ… Login Successful.");

        // Add Product
        System.out.println("Step 2: Adding Backpack to Cart...");
        shoppingPage.addBackpack();
        System.out.println("Backpack added.");

        // Verify Cart Count
        Assert.assertEquals(
                shoppingPage.getCartCount(),
                "1",
                "Product was not added to cart.");
        System.out.println("âœ… Cart Count Verified : " + shoppingPage.getCartCount());

        // Open Cart
        System.out.println("Step 3: Opening Cart...");
        shoppingPage.openCart();
        System.out.println("Cart opened.");

        // Checkout
        System.out.println("Step 4: Clicking Checkout...");
        checkoutPage.clickCheckout();
        System.out.println("Checkout page opened.");

        // Customer Details
        System.out.println("Step 5: Entering Customer Details...");
        checkoutPage.enterFirstName(firstName);
        checkoutPage.enterLastName(lastName);
        checkoutPage.enterPostalCode(postalCode);
        System.out.println("Customer Details:");
        System.out.println("First Name : " + firstName);
        System.out.println("Last Name  : " + lastName);
        System.out.println("Postal Code: " + postalCode);

        // Continue
        System.out.println("Step 6: Clicking Continue...");
        checkoutPage.clickContinue();

        // Verify Checkout Overview
        Assert.assertTrue(
                checkoutPage.isCheckoutOverviewDisplayed(),
                "Checkout Overview page is not displayed.");
        System.out.println(" Checkout Overview Displayed.");

        // Finish Order
        System.out.println("Step 7: Finishing Order...");
        checkoutPage.clickFinish();

        // Verify Confirmation
        Assert.assertEquals(
                checkoutPage.getConfirmationMessage(),
                "Thank you for your order!",
                "Order confirmation message is incorrect.");
        System.out.println(" Order Confirmation Verified.");

        System.out.println("----------------------------------------");
        System.out.println(" End-to-End Test Passed Successfully");
        System.out.println("----------------------------------------");
    }
}