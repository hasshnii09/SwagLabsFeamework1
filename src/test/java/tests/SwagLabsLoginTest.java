package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.DataProviderClass;

public class SwagLabsLoginTest extends BaseTest {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviderClass.class)
    public void loginTest(String testCaseID,
                          String type,
                          String username,
                          String password,
                          String expectedResult,
                          String passFail) {

        System.out.println("\n========================================");
        System.out.println(">>> START TEST : " + testCaseID);
        System.out.println("Scenario       : " + type);
        System.out.println("Username       : " + username);
        System.out.println("Expected       : " + expectedResult);
        System.out.println("Pass/Fail      : " + passFail);
        System.out.println("========================================");

        // Enter Login Details
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickLogin();

        if (passFail.equalsIgnoreCase("Pass")) {

            System.out.println("Valid Login - Verifying Products Page...");

            String actualTitle = shoppingPage.getProductsTitle();

            System.out.println("Actual Title   : " + actualTitle);

            Assert.assertEquals(actualTitle, "Products",
                    "Products page not displayed.");

            System.out.println("✅ " + testCaseID + " PASSED");

        } else {

            System.out.println("Invalid Login - Verifying Error Message...");

            String actualError = loginPage.getErrorMessage();

            System.out.println("Actual Error   : " + actualError);

            Assert.assertTrue(actualError.contains("Epic sadface"),
                    "Expected error message not displayed.");

            System.out.println("✅ " + testCaseID + " PASSED");
        }

        System.out.println(">>> END TEST : " + testCaseID);
        System.out.println("========================================\n");
    }
}