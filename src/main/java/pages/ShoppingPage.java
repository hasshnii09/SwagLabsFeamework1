package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingPage {

    WebDriver driver;

    // Constructor
    public ShoppingPage(WebDriver driver) {
        this.driver = driver;
    }

    // ==========================
    // Products Page Locators
    // ==========================

    By productsTitle = By.className("title");

    By backpackAddButton = By.id("add-to-cart-sauce-labs-backpack");
    By bikeLightAddButton = By.id("add-to-cart-sauce-labs-bike-light");

    By backpackRemoveButton = By.id("remove-sauce-labs-backpack");
    By bikeLightRemoveButton = By.id("remove-sauce-labs-bike-light");

    // ==========================
    // Cart Locators
    // ==========================

    By cartIcon = By.className("shopping_cart_link");
    By cartBadge = By.className("shopping_cart_badge");

    // ==========================
    // Menu & Logout Locators
    // ==========================

    By menuButton = By.id("react-burger-menu-btn");
    By logoutButton = By.id("logout_sidebar_link");

    // ==========================
    // Products Methods
    // ==========================

    public String getProductsTitle() {
        return driver.findElement(productsTitle).getText();
    }

    public void addBackpack() {
        driver.findElement(backpackAddButton).click();
    }

    public void addBikeLight() {
        driver.findElement(bikeLightAddButton).click();
    }

    public void removeBackpack() {
        driver.findElement(backpackRemoveButton).click();
    }

    public void removeBikeLight() {
        driver.findElement(bikeLightRemoveButton).click();
    }

    // ==========================
    // Cart Methods
    // ==========================

    public void openCart() {
        driver.findElement(cartIcon).click();
    }

    public String getCartCount() {
        return driver.findElement(cartBadge).getText();
    }

    // ==========================
    // Logout Methods
    // ==========================

    public void openMenu() {
        driver.findElement(menuButton).click();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }

    public void logout() {
        openMenu();
        clickLogout();
    }
}
