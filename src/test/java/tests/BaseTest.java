package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected YourCartPage yourCartPage;
    protected YourInformationPage yourInformationPage;
    protected CheckoutPage checkoutPage;
    protected CompletePage completePage;

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        yourInformationPage = new YourInformationPage(driver);
        checkoutPage = new CheckoutPage(driver);
        completePage = new CompletePage(driver);
    }

    @AfterMethod(alwaysRun = true)
    public void postCondition() {
        driver.quit();
    }
}
