package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {


    @Test(groups = {"Smoke"}, retryAnalyzer = Retry.class,
            description = "Критический путь пользователя")
    public void successBuyProduct() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCardButton("Sauce Labs Backpack");
        productsPage.clickAddToCardButton("Sauce Labs Bike Light");
        productsPage.clickToBasket();
        yourCartPage.clickToCheckout();
        yourInformationPage.setFirstNameValue("Slava");
        yourInformationPage.setLastNameValue("Jyk");
        yourInformationPage.setZipCodeValue("123");
        yourInformationPage.clickToContinueButton();
        checkoutPage.clickToFinishButton();
        Assert.assertTrue(completePage.isDisplaySuccessMessage());
    }
}
