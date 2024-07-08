package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YourCardTest extends BaseTest {


    @Test(groups = {"Smoke"},
            description = "Успешное добавление продукта в корзину",
            dataProvider = "testDataForAddProductToCard")
    @Description("Проверка добавление продукта '{product}'")
    @Severity(SeverityLevel.CRITICAL)
    public void addProductToCard(String product) {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCardButton(product);
        productsPage.clickToBasket();
        Assert.assertTrue(yourCartPage.productInCard(product), "проверка продукта");
    }

    @Test(groups = {"Regression"},
    description = "Удаление продукта из корзины")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteProductFromCard() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCardButton("Sauce Labs Backpack");
        productsPage.clickToBasket();
        Assert.assertTrue(yourCartPage.productInCard("Sauce Labs Backpack"), "проверка продукта в корзине");
        yourCartPage.clickToRemoveButton("Sauce Labs Backpack");
        Assert.assertFalse(yourCartPage.productInCard("Sauce Labs Backpack"), "проверка удаления продукта");

    }

    @DataProvider
    public Object[][] testDataForAddProductToCard() {
        return new Object[][]{
                {"Sauce Labs Backpack"},
                {"Sauce Labs Bike Light"},
                {"Sauce Labs Bolt T-Shirt"},
                {"Sauce Labs Fleece Jacket"},
                {"Sauce Labs Onesie"},
                {"Test.allTheThings() T-Shirt (Red)"}
        };

    }
}
