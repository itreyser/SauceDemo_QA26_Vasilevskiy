package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"Regression"},
            description = "Проверка полной стоимости продукта + таксы")
    @Description("Проверить стоимость продуктов Sauce Labs Backpack, Sauce Labs Bike Light")
    @Severity(SeverityLevel.CRITICAL)
    public void checkTotalPriceWithTax() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCardButton("Sauce Labs Backpack");
        productsPage.clickAddToCardButton("Sauce Labs Bike Light");
        productsPage.clickToBasket();
        yourCartPage.clickToCheckout();
        yourInformationPage.setFirstNameValue("Slava");
        yourInformationPage.setLastNameValue("Jyk");
        yourInformationPage.setZipCodeValue("123");
        yourInformationPage.clickToContinueButton();


        Double firstPriceProduct = checkoutPage.getProductPrice("Sauce Labs Backpack");
        Double secondPriceProduct = checkoutPage.getProductPrice("Sauce Labs Bike Light");
        Double tax = checkoutPage.getTaxPrice();

        Double totalPrice = checkoutPage.getTotalPrice();

        Assert.assertEquals(tax + firstPriceProduct + secondPriceProduct, totalPrice);


    }
}
