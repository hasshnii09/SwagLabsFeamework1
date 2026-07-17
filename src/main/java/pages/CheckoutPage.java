package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage {

    WebDriver driver;

    // Constructor
    public CheckoutPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    // ==========================
    // Cart Page
    // ==========================

    @FindBy(id = "checkout")
    private WebElement btnCheckout;

    // ==========================
    // Checkout Information
    // ==========================

    @FindBy(id = "first-name")
    private WebElement txtFirstName;

    @FindBy(id = "last-name")
    private WebElement txtLastName;

    @FindBy(id = "postal-code")
    private WebElement txtPostalCode;

    @FindBy(id = "continue")
    private WebElement btnContinue;

    // ==========================
    // Checkout Overview
    // ==========================

    @FindBy(className = "title")
    private WebElement lblPageTitle;

    @FindBy(id = "finish")
    private WebElement btnFinish;

    // ==========================
    // Checkout Complete
    // ==========================

    @FindBy(className = "complete-header")
    private WebElement lblConfirmationMessage;

    // ==========================
    // Methods
    // ==========================

    // Click Checkout Button
    public void clickCheckout() {

        btnCheckout.click();

    }

    // Enter First Name
    public void enterFirstName(String firstName) {

        txtFirstName.clear();
        txtFirstName.sendKeys(firstName);

    }

    // Enter Last Name
    public void enterLastName(String lastName) {

        txtLastName.clear();
        txtLastName.sendKeys(lastName);

    }

    // Enter Postal Code
    public void enterPostalCode(String postalCode) {

        txtPostalCode.clear();
        txtPostalCode.sendKeys(postalCode);

    }

    // Click Continue
    public void clickContinue() {

        btnContinue.click();

    }

    // Verify Checkout Overview Page
    public boolean isCheckoutOverviewDisplayed() {

        return lblPageTitle.getText().equals("Checkout: Overview");

    }

    // Click Finish
    public void clickFinish() {

        btnFinish.click();

    }

    // Get Confirmation Message
    public String getConfirmationMessage() {

        return lblConfirmationMessage.getText();

    }

}