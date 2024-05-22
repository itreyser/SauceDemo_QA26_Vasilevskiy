package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class YourCardTest extends BaseTest {

    @Test
    public void addProductToCard() {
        String firstProduct = "Sauce Labs Backpack";
        String secondProduct = "Sauce Labs Bike Light";
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCardButton(firstProduct);
        productsPage.clickAddToCardButton(secondProduct);
        productsPage.clickToBasket();
        Assert.assertTrue(yourCardPage.productInCard(firstProduct), "проверка первого продукта");
        Assert.assertTrue(yourCardPage.productInCard(secondProduct), "проверка второго продукта");
    }

    @Test
    public void deleteProductFromCard() {
        loginPage.login("standard_user", "secret_sauce");
        productsPage.clickAddToCardButton("Sauce Labs Backpack");
        productsPage.clickToBasket();
        Assert.assertTrue(yourCardPage.productInCard("Sauce Labs Backpack"), "проверка продукта в корзине");
        yourCardPage.clickToRemoveButton("Sauce Labs Backpack");
        Assert.assertFalse(yourCardPage.productInCard("Sauce Labs Backpack"), "проверка удаления продукта");

    }
}
