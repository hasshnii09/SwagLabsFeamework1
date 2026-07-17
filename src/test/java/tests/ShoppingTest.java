package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utils.ConfigReader;

public class ShoppingTest extends BaseTest {

    @Test
    public void shoppingCartTest() {

        System.out.println("========================================");
        System.out.println("Shopping Test Started");

        // Login using config.properties
        loginPage.login(
                ConfigReader.getProperty("username"),
                ConfigReader.getProperty("password"));

        // Verify Products Page
        Assert.assertEquals(
                shoppingPage.getProductsTitle(),
                "Products",
                "Login Failed!");

        // Add Backpack
        shoppingPage.addBackpack();

        Assert.assertEquals(
                shoppingPage.getCartCount(),
                "1",
                "Backpack was not added to cart.");

        // Add Bike Light
        shoppingPage.addBikeLight();

        Assert.assertEquals(
                shoppingPage.getCartCount(),
                "2",
                "Bike Light was not added to cart.");

        // Open Cart
        shoppingPage.openCart();

        System.out.println("Shopping Test Passed Successfully");
    }
}