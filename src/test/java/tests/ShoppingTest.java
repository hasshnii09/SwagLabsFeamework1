package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;

public class ShoppingTest extends BaseTest {

    @Test
    public void shoppingFlowTest() {

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Verify Products Page
        Assert.assertEquals(shoppingPage.getProductsTitle(), "Products");

        // Add Backpack
        shoppingPage.addBackpack();
        Assert.assertEquals(shoppingPage.getCartCount(), "1");

        // Add Bike Light
        shoppingPage.addBikeLight();
        Assert.assertEquals(shoppingPage.getCartCount(), "2");

        // Open Cart
        shoppingPage.openCart();

        System.out.println("Shopping Flow Completed Successfully");
    }
}
