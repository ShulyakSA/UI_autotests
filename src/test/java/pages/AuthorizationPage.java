package pages;

import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import steps.MainSteps;

import static config.WebConfig.getUrl;
import static helpers.Waits.waitElementIsVisible;
import static steps.MainSteps.*;

@Slf4j
public class AuthorizationPage extends BasePage {
    public final String SUCCESS_MASSAGE = "You're logged in!!";
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(id = "formly_1_input_username_0")
    WebElement usernameDescription;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;
    @FindBy(xpath = "//p[text()=\"You're logged in!!\"]")
    WebElement successMessage;

    public AuthorizationPage(WebDriver webDriver) {
        super(webDriver);
        openMainPage();
    }

    void openMainPage() {
        driver.get(getUrl());
    }

    public AuthorizationPage inputUsername(String text) {
        clearAndType(driver, username, text);
        return this;
    }

    public AuthorizationPage inputPassword(String text) {
        clearAndType(driver, password, text);
        return this;
    }

    public AuthorizationPage inputUsernameDescription(String text) {
        clearAndType(driver, usernameDescription, text);
        return this;
    }

    public void clickButtonLogin() {
        clickButton(driver, loginButton);
    }

    public AuthorizationPage switchToThisWindow() {
        MainSteps.switchToWindow(driver);
        return this;
    }

    public String getSuccessMessageText() {
        waitElementIsVisible(driver, successMessage);
        return successMessage.getText();
    }
}
