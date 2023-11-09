package pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import steps.MainSteps;

import static helpers.Waits.waitElementIsVisible;
import static steps.MainSteps.*;

@Slf4j
public class AuthorizationPage extends BasePage {
    public final String SUCCESS_MESSAGE = "You're logged in!!";
    public final String FAILED_MESSAGE = "Username or password is incorrect";
    @FindBy(id = "username")
    WebElement username;
    @FindBy(id = "password")
    WebElement password;
    @FindBy(xpath = "//input[contains(@id, 'input_username_0')]")
    WebElement usernameDescription;
    @FindBy(xpath = "//button[contains(text(),'Login')]")
    WebElement loginButton;
    @FindBy(xpath = "//p[text()=\"You're logged in!!\"]")
    WebElement successMessage;
    @FindBy(xpath = "//a[@href='#/login']")
    WebElement logoutLink;
    @FindBy(xpath = "//div[@ng-if='Auth.error']")
    WebElement failedMessage;

    public AuthorizationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Ввод значения '{text}' в поле 'Username'")
    public AuthorizationPage inputUsername(String text) {
        waitElementIsVisible(driver, username);
        clearAndType(username, text);
        return this;
    }

    @Step("Ввод значения '{text}' в поле 'Password'")
    public AuthorizationPage inputPassword(String text) {
        waitElementIsVisible(driver, password);
        clearAndType(password, text);
        return this;
    }

    @Step("Ввод значения '{text}' в поле 'Username *'")
    public AuthorizationPage inputUsernameDescription(String text) {
        clearAndType(usernameDescription, text);
        return this;
    }

    @Step("Клик на кнопку 'Login'")
    public void clickButtonLogin() {
        clickButton(driver, loginButton);
    }

    @Step("Клик на ссылку 'Logout'")
    public void clickLogoutLink() {
        clickButton(driver, logoutLink);
    }

    @Step("Переключение на окно авторизации")
    public AuthorizationPage switchToThisWindow() {
        MainSteps.switchToWindow(driver);
        return this;
    }

    @Step("Получение текста сообщения об успешном входе: '" + SUCCESS_MESSAGE + "'")
    public String getSuccessMessageText() {
        waitElementIsVisible(driver, successMessage);
        return successMessage.getText();
    }

    @Step("Получение текста сообщения об ошибке: '" + FAILED_MESSAGE + "'")
    public String getFailedMessageText() {
        waitElementIsVisible(driver, failedMessage);
        return failedMessage.getText();
    }
}
