package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class YourInformationPage extends BasePage {

    private final By CONTINUE_BUTTON = By.cssSelector("input[id=continue]");
    private final By CANCEL_BUTTON = By.cssSelector("button[id=cancel]");
    private final By INPUT_FIRST_NAME = By.cssSelector("input[id=first-name]");
    private final By INPUT_LAST_NAME = By.cssSelector("input[id=last-name]");
    private final By INPUT_ZIP_CODE = By.cssSelector("input[id=postal-code]");


    public YourInformationPage(WebDriver driver) {
        super(driver);
    }

    @Step("Перейти к форме оплаты")
    public void clickToContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void clickToCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    @Step("Ввести имя '{firstName}'")
    public void setFirstNameValue(String firstName) {
        driver.findElement(INPUT_FIRST_NAME).sendKeys(firstName);
    }

    @Step("Ввести фамилию '{lastName}'")
    public void setLastNameValue(String lastName) {
        driver.findElement(INPUT_LAST_NAME).sendKeys(lastName);
    }

    @Step("Ввести zipCode =  '{zipCode}'")
    public void setZipCodeValue(String zipCode) {
        driver.findElement(INPUT_ZIP_CODE).sendKeys(zipCode);
    }


}
