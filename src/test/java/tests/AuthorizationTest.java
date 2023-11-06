package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static config.TestConfig.*;
import static io.qameta.allure.SeverityLevel.BLOCKER;

@Epic(value ="Форма регистрации")
@Feature(value = "Авторизация")
public class AuthorizationTest extends BaseTest {

    @BeforeMethod
    public void gotoRegistrationForm(){
        mainPage.onNavBar()
                .clickResources()
                .clickPracticeSiteTwo();
        practiceSiteTwoPage.clickRegistrationFormLink();
    }

    @Story(value = "Заполнение формы регистрации")
    @Severity(BLOCKER)
    @Test(description = "Проверка авторизации")
    public void authorizationTest() {
        authorizationPage
                .switchToThisWindow()
                .inputUsername(getUsername())
                .inputPassword(getPassword())
                .inputUsernameDescription(getUsernameDescription())
                .clickButtonLogin();
        Assert.assertEquals(authorizationPage.getSuccessMessageText(), authorizationPage.SUCCESS_MASSAGE);
    }
}
