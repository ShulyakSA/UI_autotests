package tests;

import config.TestConfigFactory;
import helpers.TestListener;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.*;

import java.net.MalformedURLException;

import static helpers.WebDriverFactory.createWebDriver;
import static steps.MainSteps.clearCookies;

@Listeners(TestListener.class)
public class BaseTest {
    protected static TestConfigFactory config = TestConfigFactory.getInstance();
    public InheritableThreadLocal<WebDriver> driver = new InheritableThreadLocal<>();
    protected MainPage mainPage;
    protected PracticeSiteOnePage practiceSiteOnePage;
    protected PracticeSiteTwoPage practiceSiteTwoPage;
    protected AuthorizationPage authorizationPage;
    protected SqlExPage sqlExPage;

    @BeforeClass
    @Step("Открытие браузера")
    void init() throws MalformedURLException {
        if (driver.get() == null) {
            driver.set(createWebDriver());
        }
        mainPage = new MainPage(driver.get());
        practiceSiteOnePage = new PracticeSiteOnePage(driver.get());
        practiceSiteTwoPage = new PracticeSiteTwoPage(driver.get());
        authorizationPage = new AuthorizationPage(driver.get());
        sqlExPage = new SqlExPage(driver.get());
    }

    @AfterClass
    void  clearCookiesAndLocalStorage() {
        if (config.getWebConfig().isClearCookies()) {
            clearCookies(driver.get());
        }
    }

    @AfterClass(alwaysRun = true)
    @Step("Закрытие браузера")
    void tearDown() {
        if (driver.get() != null) {
            driver.get().quit();
        }
    }
}
