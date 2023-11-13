package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static config.TestConfig.getCookieNameSqlEx;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static steps.Checkers.checkElementIsDisplayed;
import static steps.MainSteps.*;

@Epic(value = "sql-ex.ru")
@Feature(value = "Авторизация")
public class AuthorizationWithCookiesTest extends BaseTest {
    @Story(value = "Авторизация с сохранением cookies")
    @Severity(BLOCKER)
    @Test(description = "Проверка авторизации и сохранение cookies в файл", priority=1)
    public void authorizationWithSaveCookiesTest() {
        sqlExPage.openSqlExPage().basicAuth();
        Assert.assertTrue(checkElementIsDisplayed(sqlExPage.getProfileLink()));
        saveCookiesInFile(driver,getCookieNameSqlEx());
        clearCookies(driver);
    }

    @Story(value = "Авторизация с cookies")
    @Severity(BLOCKER)
    @Test(description = "Проверка авторизации c cookies", priority=2)
    public void authorizationWithCookiesTest() {
        sqlExPage.openSqlExPage().authorizationWithCookies();
        Assert.assertTrue(checkElementIsDisplayed(sqlExPage.getProfileLink()));
    }
}

