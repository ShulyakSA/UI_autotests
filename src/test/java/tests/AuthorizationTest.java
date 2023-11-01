package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static config.TestConfig.*;

public class AuthorizationTest extends BaseTest {
    @Test(description = "Проверка авторизации")
    public void authorizationTest() throws InterruptedException {
        mainPage.onNavBar()
                .clickResources()
                .clickPracticeSiteTwo();
        practiceSiteTwoPage.clickRegistrationFormLink();
        authorizationPage
                .switchToThisWindow()
                .inputUsername(getUsername())
                .inputPassword(getPassword())
                .inputUsernameDescription(getUsernameDescription())
                .clickButtonLogin();
        Assert.assertEquals(authorizationPage.getSuccessMessageText(), authorizationPage.SUCCESS_MASSAGE);
    }
}
