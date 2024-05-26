package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class YourCartPage extends BasePage {

    private final By REMOVE_BUTTON = By.cssSelector("button[id=remove-sauce-labs-backpack]");
    private final By CHECKOUT_BUTTON = By.cssSelector("button[id=checkout]");
    private final By CONTINUE_SHOPPING_BUTTON = By.cssSelector("button[id=checkout]");
    private final By ITEM_PRICE = By.cssSelector("div.inventory_item_price");
    private final By ITEM_DESCRIPTION = By.className("inventory_item_desc");

    private final By ALL_ITEM = By.className("inventory_item_name");


    public YourCartPage(WebDriver driver) {
        super(driver);
    }

    public void getProductPrice(String productName) {
        getProductCardByName(productName).findElement(ITEM_PRICE).getText();
    }

    public String getProductDescription(String productName) {
        return getProductCardByName(productName).findElement(ITEM_DESCRIPTION).getText();
    }

    private WebElement getProductCardByName(String productName) {
        String locator = String.format(ALL_CART, productName);
        return driver.findElement(By.xpath(locator));
    }

    public void clickToRemoveButton(String productName) {
        getProductCardByName(productName).findElement(REMOVE_BUTTON).click();
    }

    public void clickToContinueShopping() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void clickToCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public boolean productInCard(String productName) {
        List<WebElement> webElementList = driver.findElements(ALL_ITEM);
        boolean flag = false;
        for (WebElement i : webElementList) {
            if (i.getText().equals(productName)) {
                flag= true;
            }
        }
        return flag;
    }

}
