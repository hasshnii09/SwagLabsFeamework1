package base;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.CartPage;
import pages.CheckoutCompletePage;
import pages.CheckoutPage;
import pages.LoginPage;
import pages.ShoppingPage;
import utils.ConfigReader;

public class BaseTest {

    public WebDriver driver;

    public LoginPage loginPage;
    public ShoppingPage shoppingPage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    public CheckoutCompletePage checkoutCompletePage;

    @BeforeMethod
    public void setUp() {

        ChromeOptions options = new ChromeOptions();

        HashMap<String, Object> prefs = new HashMap<>();

        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-notifications");

        driver = new ChromeDriver(options);

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(
                Duration.ofSeconds(
                        Integer.parseInt(
                                ConfigReader.getProperty("implicitWait"))));

        driver.get(ConfigReader.getProperty("url"));

        // Initialize Page Objects
        loginPage = new LoginPage(driver);
        shoppingPage = new ShoppingPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutCompletePage = new CheckoutCompletePage(driver);
    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }
}

