package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {

    WebDriver driver;
    private By checkoutBtn = By.id("checkout");

    public void clickCheckout() {
        driver.findElement(checkoutBtn).click();
    }

    By removeButton = By.id("remove-sauce-labs-backpack");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void removeProduct() {
        driver.findElement(removeButton).click();
    }
}