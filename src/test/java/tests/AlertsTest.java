package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

@Epic(value = "Форма Alert")
@Feature(value = "Работа с алертами")
public class AlertsTest extends BaseTest {
    @BeforeClass
    public void openPage() {
        alertPage.openAlertPage();
    }

    @Story(value = "Заполнение и подтверждение алерта")
    @Severity(CRITICAL)
    @Test(description = "Проверка заполнения и подтверждения Алерта")
    public void checkInputAcceptAlerts() {
        alertPage.clickInputAlertLink()
                .switchToAlertFrame()
                .clickDemoButton()
                .inputAndAcceptAlert(config.getTestConfig().getDescriptionW2A());
        Assert.assertEquals(alertPage.getDemoText(), "Hello " + config.getTestConfig().getDescriptionW2A() + "! How are you today?");
    }
}
