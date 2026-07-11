package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CartPage;
public class CartTest extends BaseTest {

    @Test
    public void cartFlowTest() {

        // Login
        loginPage.enterUsername("standard_user");
        loginPage.enterPassword("secret_sauce");
        loginPage.clickLogin();

        // Add Product
        shoppingPage.addBackpack();

        // Open Cart
        shoppingPage.openCart();

        // Verify Cart Item Count
        Assert.assertEquals(
                shoppingPage.getCartCount(),
                "1"
        );

        // Remove Product
        CartPage cartPage = new CartPage(driver);
        cartPage.removeProduct();

        System.out.println("Cart Test Passed Successfully");
    }
}
