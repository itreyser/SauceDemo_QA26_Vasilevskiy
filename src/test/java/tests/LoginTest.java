package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void positiveLoginTest() {

        loginPage.login("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isShoppingCardDisplay());
    }

    @Test
    public void negativeLoginTest(){
        loginPage.login("sdf", "4324fsd");
        Assert.assertTrue(loginPage.isDisplayMessageError());
        Assert.assertTrue(loginPage.checkErrorText());
    }

}
