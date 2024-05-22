package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage {
    private final By SHOPPING_BASKET = By.className("shopping_cart_link");
    private final By ADD_TO_CARD_BUTTON = By.cssSelector("button[id^='add-to-cart']");
    private final By ITEM_PRICE = By.cssSelector("div.inventory_item_price");
    private final By ITEM_DESCRIPTION = By.className("inventory_item_desc");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isShoppingCardDisplay() {
        return driver.findElement(SHOPPING_BASKET).isDisplayed();
    }

    public void clickToBasket() {
        driver.findElement(SHOPPING_BASKET).click();
    }

    public void clickAddToCardButton(String productName) {
        getProductCardByName(productName).findElement(ADD_TO_CARD_BUTTON).click();
    }

    public String getProductPrice(String productName) {
        return getProductCardByName(productName).findElement(ITEM_PRICE).getText();
    }

    public String getProductDescription(String productName) {
        return getProductCardByName(productName).findElement(ITEM_DESCRIPTION).getText();
    }

    private WebElement getProductCardByName(String productName) {
        String locator = String.format("//div[text()='%s']/ancestor::div[@class='inventory_item']", productName);
        return driver.findElement(By.xpath(locator));
    }
}
