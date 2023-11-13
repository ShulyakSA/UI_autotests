package tests;

import helpers.TestListener;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.*;
import pages.*;

import static config.WebConfig.getClearCookies;
import static helpers.WebDriverFactory.createWebDriver;
import static steps.MainSteps.clearCookies;

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
    void clearCookiesAndLocalStorage() {
        if (getClearCookies()) {
            clearCookies(driver);
        }
    }

    @AfterTest
    @Step("Закрытие браузера")
    public void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }
}
