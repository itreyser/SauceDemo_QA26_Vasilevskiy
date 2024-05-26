package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutPage extends BasePage {

    private final By FINISH_BUTTON = By.cssSelector("button[id=finish]");
    private final By CANCEL_BUTTON = By.cssSelector("button[id=cancel]");
    private final By ITEM_PRICE = By.cssSelector("div.inventory_item_price");
    private final By ITEM_DESCRIPTION = By.className("inventory_item_desc");
    private final By TAX_PRICE = By.className("summary_tax_label");
    private final By TOTAL_PRICE = By.className("summary_total_label");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public Double getProductPrice(String productName) {
        String price = getProductCardByName(productName).findElement(ITEM_PRICE).getText().replaceAll("[^0-9\\.]", "");
        return Double.parseDouble(price);
    }

    public String getProductDescription(String productName) {
        return getProductCardByName(productName).findElement(ITEM_DESCRIPTION).getText();
    }

    private WebElement getProductCardByName(String productName) {
        String locator = String.format(ALL_CART, productName);
        return driver.findElement(By.xpath(locator));
    }

    public void clickToFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void clickToCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public double getTotalPrice() {
        String price = driver.findElement(TOTAL_PRICE).getText().replaceAll("[^0-9\\.]", "");
        return Double.parseDouble(price);
    }

    public double getTaxPrice() {
        String price = driver.findElement(TAX_PRICE).getText().replaceAll("[^0-9\\.]", "");
        return Double.parseDouble(price);
    }


}
