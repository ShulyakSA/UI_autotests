package tests;

import helpers.TestListener;
import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;

import static config.WebConfig.getClearCookies;
import static helpers.WebDriverFactory.createWebDriver;

@Listeners(TestListener.class)
public class BaseTest {
    public WebDriver driver;
    protected MainPage mainPage;
    protected PracticeSiteOnePage practiceSiteOnePage;
    protected PracticeSiteTwoPage practiceSiteTwoPage;
    protected static AuthorizationPage authorizationPage;
    protected static SqlExPage sqlExPage;

    @BeforeTest
    @Step("Открытие браузера")
    public void init() {
        driver = createWebDriver();
        mainPage = new MainPage(driver);
        practiceSiteOnePage = new PracticeSiteOnePage(driver);
        practiceSiteTwoPage = new PracticeSiteTwoPage(driver);
        authorizationPage = new AuthorizationPage(driver);
        sqlExPage = new SqlExPage(driver);
    }

    @AfterTest
    @Step("Очистка кэша")
    void clearCookiesAndLocalStorage() {
        if (getClearCookies()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterTest
    @Step("Закрытие браузера")
    public void tearDown() {
        driver.quit();
    }
}
