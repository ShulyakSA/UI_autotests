package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static steps.Checkers.checkElementIsDisplayed;

@Epic(value = "sql-ex.ru")
@Feature(value = "Авторизация")
public class AuthorizationWithCookiesTest extends BaseTest {
    @BeforeTest
    public void openPage() {
        sqlExPage.openSqlExPage();
    }

    @Story(value = "Авторизация с Cookie")
    @Severity(BLOCKER)
    @Test(description = "Проверка авторизации c Cookies")
    @Parameters("invocationCount")
    public void authorizationWithCookiesTest(int invocationCount) {
        if (invocationCount == 1) {
            sqlExPage.basicAuth();
        } else sqlExPage.authorizationWithCookies();
        Assert.assertTrue(checkElementIsDisplayed(sqlExPage.getProfileLink()));
    }
}
