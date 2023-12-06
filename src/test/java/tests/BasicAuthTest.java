package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static steps.Checkers.checkElementIsDisplayed;

@Epic(value = "httpwatch.com")
@Feature(value = "Basic Authentication")
public class BasicAuthTest extends BaseTest {
    @BeforeClass
    public void openPage() {
        httpAuthenticationPage.openHttpAuthPage();
    }

    @Story(value = "Проверка базовой авторизации")
    @Severity(CRITICAL)
    @Test(description = "Проверка результата авторизации")
    public void checkBasicAuth() {
        httpAuthenticationPage.clickDisplayImageButton();
        Assert.assertTrue(checkElementIsDisplayed(httpAuthenticationPage.getDownloadImg()));
    }
}
