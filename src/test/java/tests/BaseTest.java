package tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import pages.*;
import utils.DriverFactory;
import utils.InvokedListener;
import utils.TestListener;

@Listeners({TestListener.class, InvokedListener.class})
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
    public void preCondForClass(@Optional("chrome") String browser, ITestContext iTestContext) throws Exception {
        driver = DriverFactory.getDriver(browser);
        iTestContext.setAttribute("driver", driver);
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
