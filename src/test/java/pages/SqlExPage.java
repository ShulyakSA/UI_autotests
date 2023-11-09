package pages;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static config.TestConfig.getPasswordSqlEx;
import static config.TestConfig.getUsernameSqlEx;
import static config.WebConfig.getSqlExUrl;
import static helpers.Waits.waitElementIsVisible;
import static steps.MainSteps.*;

@Slf4j
public class SqlExPage {
    protected final WebDriver driver;

    @FindBy(xpath = "//form[@name='frmlogin']//input[@name='login']")
    WebElement loginInput;
    @FindBy(xpath = "//form[@name='frmlogin']//input[@name='psw']")
    WebElement passwordInput;
    @FindBy(xpath = ".//input[@name='subm1']")
    WebElement loginButton;
    @FindBy(xpath = "//b/a[@href='/personal.php']")
    WebElement profileLink;

    public SqlExPage(WebDriver webDriver) {
        try {
            PageFactory.initElements(webDriver, this);
            this.driver = webDriver;
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Открытие страницы sql-ex.ru")
    public SqlExPage openSqlExPage() {
        driver.get(getSqlExUrl());
        return this;
    }

    @Step("Ввод значения '{text}' в поле 'Логин'")
    public SqlExPage inputUsername(String text) {
        waitElementIsVisible(driver, loginInput);
        clearAndType(loginInput, text);
        return this;
    }

    @Step("Ввод значения '{text}' в поле 'Пароль'")
    public SqlExPage inputPassword(String text) {
        waitElementIsVisible(driver, passwordInput);
        clearAndType(passwordInput, text);
        return this;
    }

    @Step("Нажатие на кнопку 'Вход'")
    public void clickLoginButton() {
        clickButton(driver, loginButton);
    }

    @Step("Базовая авторизация")
    public SqlExPage basicAuth() {
        inputUsername(getUsernameSqlEx())
                .inputPassword(getPasswordSqlEx())
                .clickLoginButton();
        saveCookiesInFile(driver);
        return this;
    }

    @Step("Авторизация через Cookies")
    public SqlExPage authorizationWithCookies() {
        waitElementIsVisible(driver, loginInput);
        addCookiesOnCurrentSession(driver);
        return this;
    }

    public WebElement getProfileLink() {
        return profileLink;
    }
}
