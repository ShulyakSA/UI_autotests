package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static config.TestConfig.*;
import static io.qameta.allure.SeverityLevel.BLOCKER;

@Epic(value = "Форма регистрации")
@Feature(value = "Авторизация")
public class AuthorizationTest extends BaseTest {

    @BeforeTest
    public void gotoRegistrationForm() {
        mainPage.openMainPage()
                .onNavBar()
                .clickResources()
                .clickPracticeSiteTwo();
        practiceSiteTwoPage.clickRegistrationFormLink();
        authorizationPage.switchToThisWindow();
    }

    @DataProvider(name = "Auth")
    public static Object[][] AuthData() {
        return new Object[][]{
                {getUsernameW2A(), getPasswordW2A(), getUsernameDescriptionW2A(), authorizationPage.SUCCESS_MESSAGE},
                {"Petrovich", getPasswordW2A(), getUsernameDescriptionW2A(), authorizationPage.FAILED_MESSAGE},
                {getUsernameW2A(), "QWERTY", getUsernameDescriptionW2A(), authorizationPage.FAILED_MESSAGE},
                {getUsernameW2A(), getPasswordW2A(), "Ivan Petrovich", authorizationPage.SUCCESS_MESSAGE},
        };
    }

    @Story(value = "Заполнение формы регистрации")
    @Severity(BLOCKER)
    @Test(description = "Проверка авторизации", dataProvider = "Auth")
    public void authorizationTest(String userName, String password, String description, String expectedMessage) {
        authorizationPage
                .inputUsername(userName)
                .inputPassword(password)
                .inputUsernameDescription(description)
                .clickButtonLogin();
        if (expectedMessage == authorizationPage.SUCCESS_MESSAGE) {
            Assert.assertEquals(authorizationPage.getSuccessMessageText(), expectedMessage);
            authorizationPage.clickLogoutLink();
        } else {
            Assert.assertEquals(authorizationPage.getFailedMessageText(), expectedMessage);
        }
    }
}
