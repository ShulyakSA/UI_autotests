package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static config.TestConfig.getUsernameW2A;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static steps.MainSteps.getActualYCoordinate;
import static steps.MainSteps.scrollBy;

@Epic(value = "Главная страница")
@Feature(value = "Выполнение скриптов на странице")
public class JsExecutorTest extends BaseTest {
    @BeforeTest
    public void openPage() {
        mainPage.openMainPage();
    }

    @Story(value = "JavaScript")
    @Severity(CRITICAL)
    @Test(description = "Проверка методов скролла и фокуса JavaScript")
    public void checkJsExecutor() {
        mainPage.onNavBar().clickResources().clickPracticeSiteOne();
        practiceSiteOnePage.inputName(getUsernameW2A()).unFocusNameInput();
        practiceSiteOnePage.clickTestLink();
        scrollBy(driver, "500");
        Assert.assertEquals(getActualYCoordinate(driver), "500");
    }
}
