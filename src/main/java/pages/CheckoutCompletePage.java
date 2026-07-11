package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage {

    WebDriver driver;

    // Locators
    By finishButton = By.id("finish");
    By backHomeButton = By.id("back-to-products");
    By confirmationMessage = By.className("complete-header");

    // Constructor
    public CheckoutCompletePage(WebDriver driver) {
        this.driver = driver;
    }

    // Click Finish
    public void clickFinish() {
        driver.findElement(finishButton).click();
    }

    // Get Confirmation Message
    public String getConfirmationMessage() {
        return driver.findElement(confirmationMessage).getText();
    }

    // Click Back Home
    public void clickBackHome() {
        driver.findElement(backHomeButton).click();
    }
}
