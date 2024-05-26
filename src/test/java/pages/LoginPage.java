package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private final By EMAIL_INPUT = By.name("user-name");
    private final By PASSWORD_INPUT = By.id("password");
    private final By LOGIN_BUTTON = By.id("login-button");

    private final By ERROR_MESSAGE = By.cssSelector("h3[data-test=error]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void setEmailValue(String email) {
        driver.findElement(EMAIL_INPUT).sendKeys(email);
    }

    public void setPasswordValue(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void login(String email, String password) {
        setEmailValue(email);
        setPasswordValue(password);
        clickLoginButton();
    }

    public boolean isDisplayMessageError() {
        return driver.findElement(ERROR_MESSAGE).isDisplayed();
    }

    public boolean checkErrorText(String errorText) {
        return errorText.equals(driver.findElement(ERROR_MESSAGE).getText());
    }


}

