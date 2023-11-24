package pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Waits.waitElementIsVisible;
import static steps.MainSteps.*;

@Slf4j
public class SqlExPage extends BasePage{
    @FindBy(xpath = "//form[@name='frmlogin']//input[@name='login']")
    WebElement loginInput;
    @FindBy(xpath = "//form[@name='frmlogin']//input[@name='psw']")
    WebElement passwordInput;
    @FindBy(xpath = ".//input[@name='subm1']")
    WebElement loginButton;
    @FindBy(xpath = "//b/a[@href='/personal.php']")
    WebElement profileLink;

    public SqlExPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Открытие страницы sql-ex.ru")
    public SqlExPage openSqlExPage() {
        driver.get(config.getWebConfig().getSqlExUrl());
        return this;
    }

    @Step("Ввод значения '{text}' в поле 'Логин'")
    public SqlExPage inputUsername(String text) {
        clearAndType(driver, loginInput, text);
        return this;
    }

    @Step("Ввод значения '{text}' в поле 'Пароль'")
    public SqlExPage inputPassword(String text) {
        clearAndType(driver, passwordInput, text);
        return this;
    }

    @Step("Нажатие на кнопку 'Вход'")
    public void clickLoginButton() {
        clickButton(driver, loginButton);
    }

    @Step("Базовая авторизация")
    public SqlExPage basicAuth() {
        inputUsername(config.getTestConfig().getUsernameSqlEx())
                .inputPassword(config.getTestConfig().getPassSqlEx())
                .clickLoginButton();
        return this;
    }

    @Step("Авторизация через Cookies")
    public SqlExPage authorizationWithCookies() {
        waitElementIsVisible(driver, loginInput);
        addCookiesOnCurrentSession(driver, config.getTestConfig().getCookieNameSqlEx());
        return this;
    }

    public WebElement getProfileLink() {
        return profileLink;
    }
}
