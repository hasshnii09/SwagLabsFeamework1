package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;

    // Locators
    By checkoutButton = By.id("checkout");
    By continueShoppingButton = By.id("continue-shopping");
    By removeButton = By.id("remove-sauce-labs-backpack");

    // Constructor
    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Click Checkout
    public void clickCheckout() {
        driver.findElement(checkoutButton).click();
    }

    // Continue Shopping
    public void clickContinueShopping() {
        driver.findElement(continueShoppingButton).click();
    }

    // Remove Product
    public void removeProduct() {
        driver.findElement(removeButton).click();
    }
}