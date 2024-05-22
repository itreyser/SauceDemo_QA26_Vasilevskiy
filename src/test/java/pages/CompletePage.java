package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CompletePage extends BasePage{
    private final By SUCCESS_MESSAGE = By.cssSelector("h2[data-test=complete-header]");
    private final By BACK_HOME_BUTTON = By.id("back-to-products");


    public CompletePage(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplaySuccessMessage() {
        return driver.findElement(SUCCESS_MESSAGE).isDisplayed();
    }

    public void clickToBackHomeButton() {
        driver.findElement(BACK_HOME_BUTTON).click();
    }

}
