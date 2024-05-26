package pages;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;
    protected final String ALL_CART = "//div[text()='%s']/ancestor::div[@class='cart_item']";
    public BasePage(WebDriver driver) {
        this.driver = driver;
    }
}
