package tests;

import io.qameta.allure.*;
import org.testng.Assert;

import org.testng.annotations.*;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static steps.MainSteps.switchToWindow;

@Epic(value = "Форма регистрации")
@Feature(value = "Авторизация")
public class AuthorizationTest extends BaseTest {

    @BeforeClass(description = "Переход на форму")
    public void gotoRegistrationForm() {
        mainPage.openMainPage()
                .onNavBar()
                .clickResources()
                .clickPracticeSiteTwo();
        practiceSiteTwoPage.scrollToRegistrationFormLink().clickRegistrationFormLink();
        switchToWindow(driver.get());
    }

    @DataProvider(name = "Auth")
    public Object[][] authData() {
        return new Object[][]{
                {config.getTestConfig().getUsernameW2A(), config.getTestConfig().getPassW2A(), config.getTestConfig().getDescriptionW2A(), authorizationPage.SUCCESS_MESSAGE},
                {"Petrovich", config.getTestConfig().getPassW2A(), config.getTestConfig().getDescriptionW2A(), authorizationPage.FAILED_MESSAGE},
                {config.getTestConfig().getUsernameW2A(), "QWERTY", config.getTestConfig().getDescriptionW2A(), authorizationPage.FAILED_MESSAGE},
                {config.getTestConfig().getUsernameW2A(), config.getTestConfig().getPassW2A(), "Ivan Petrovich", authorizationPage.SUCCESS_MESSAGE},
        };
    }

    @Story(value = "Заполнение формы регистрации")
    @Severity(BLOCKER)
    @Test(description = "Проверка авторизации", dataProvider = "Auth", singleThreaded = true)
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
