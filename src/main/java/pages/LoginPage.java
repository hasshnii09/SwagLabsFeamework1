package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    // Constructor
    public LoginPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    // =========================
    // Web Elements
    // =========================

    @FindBy(id = "user-name")
    private WebElement txtUsername;

    @FindBy(id = "password")
    private WebElement txtPassword;

    @FindBy(id = "login-button")
    private WebElement btnLogin;

    @FindBy(css = "h3[data-test='error']")
    private WebElement lblErrorMessage;

    // =========================
    // Methods
    // =========================

    // Enter Username
    public void enterUsername(String username) {

        txtUsername.clear();
        txtUsername.sendKeys(username);

    }

    // Enter Password
    public void enterPassword(String password) {

        txtPassword.clear();
        txtPassword.sendKeys(password);

    }

    // Click Login Button
    public void clickLogin() {

        btnLogin.click();

    }

    // Complete Login
    public void login(String username, String password) {

        enterUsername(username);
        enterPassword(password);
        clickLogin();

    }

    // Get Error Message
    public String getErrorMessage() {

        return lblErrorMessage.getText();

    }

    // Verify Error Message is Displayed
    public boolean isErrorDisplayed() {

        return lblErrorMessage.isDisplayed();

    }

    // Clear Login Fields (Optional)
    public void clearFields() {

        txtUsername.clear();
        txtPassword.clear();

    }
}
