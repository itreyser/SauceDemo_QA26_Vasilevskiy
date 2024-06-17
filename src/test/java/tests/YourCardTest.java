package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YourCardTest extends BaseTest {


    @Test(description = "Успешное добавление продукта в корзину",
            groups = "withSuccessLogin", dataProvider = "testDataForAddProductToCard")
    public void addProductToCard(String product) {
        productsPage.clickAddToCardButton(product);
        productsPage.clickToBasket();
        Assert.assertTrue(yourCartPage.productInCard(product), "проверка продукта");
    }

    @Test(groups = "withSuccessLogin",
    description = "Удаление продукта из корзины")
    public void deleteProductFromCard() {
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
