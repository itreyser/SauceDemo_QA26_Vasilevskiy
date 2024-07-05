package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.*;
import pages.*;

import java.time.Duration;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver driver;
    protected LoginPage loginPage;
    protected ProductsPage productsPage;
    protected YourCartPage yourCartPage;
    protected YourInformationPage yourInformationPage;
    protected CheckoutPage checkoutPage;
    protected CompletePage completePage;

    @Parameters("browserName")
    @BeforeClass(alwaysRun = true)
    public void preCondForClass(@Optional("chrome") String browser) throws Exception {
        if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("edge")) {
            driver = new EdgeDriver();
        } else {
            throw new Exception("Unsupported browser...");
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        yourCartPage = new YourCartPage(driver);
        yourInformationPage = new YourInformationPage(driver);
        checkoutPage = new CheckoutPage(driver);
        completePage = new CompletePage(driver);
    }


    @AfterMethod()
    public void postCondition() {
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass(alwaysRun = true)
    public void postConditionForClass() {
        driver.quit();
    }

}
