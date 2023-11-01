package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import pages.AuthorizationPage;
import pages.MainPage;
import pages.PracticeSiteOnePage;
import pages.PracticeSiteTwoPage;

import static config.WebConfig.getClearCookies;
import static helpers.WebDriverFactory.createWebDriver;

public class BaseTest {
    public WebDriver driver;
    protected MainPage mainPage;
    protected PracticeSiteOnePage practiceSiteOnePage;
    protected PracticeSiteTwoPage practiceSiteTwoPage;
    protected AuthorizationPage authorizationPage;

    @BeforeClass
    public void init() {
        driver = createWebDriver();
        mainPage = new MainPage(driver);
        practiceSiteOnePage = new PracticeSiteOnePage(driver);
        practiceSiteTwoPage = new PracticeSiteTwoPage(driver);
        authorizationPage = new AuthorizationPage(driver);
    }

    @AfterClass
    void clearCookiesAndLocalStorage() {
        if (getClearCookies()) {
            JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
            driver.manage().deleteAllCookies();
            javascriptExecutor.executeScript("window.sessionStorage.clear()");
        }
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
