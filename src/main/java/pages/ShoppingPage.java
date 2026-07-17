package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingPage {

    WebDriver driver;

    public ShoppingPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    // Products Page Title
    @FindBy(className = "title")
    WebElement lblProductsTitle;

    // Add to Cart Buttons
    @FindBy(id = "add-to-cart-sauce-labs-backpack")
    WebElement btnBackpack;

    @FindBy(id = "add-to-cart-sauce-labs-bike-light")
    WebElement btnBikeLight;

    // Cart Badge
    @FindBy(className = "shopping_cart_badge")
    WebElement cartBadge;

    // Cart Icon
    @FindBy(className = "shopping_cart_link")
    WebElement cartIcon;

    // ------------------- Methods -------------------

    public String getProductsTitle() {
        return lblProductsTitle.getText();
    }

    public void addBackpack() {
        btnBackpack.click();
    }

    public void addBikeLight() {
        btnBikeLight.click();
    }

    public String getCartCount() {
        return cartBadge.getText();
    }

    public void openCart() {
        cartIcon.click();
    }

}
