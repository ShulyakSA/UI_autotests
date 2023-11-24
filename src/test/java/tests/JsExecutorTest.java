package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static steps.MainSteps.getActualYCoordinate;
import static steps.MainSteps.scrollBy;

@Epic(value = "Главная страница")
@Feature(value = "Выполнение скриптов на странице")
public class JsExecutorTest extends BaseTest {
    @BeforeClass
    public void openPage() {
        mainPage.openMainPage();
    }

    @Story(value = "JavaScript")
    @Severity(CRITICAL)
    @Test(description = "Проверка методов скролла и фокуса JavaScript")
    public void checkJsExecutor() {
        mainPage.onNavBar().clickResources().clickPracticeSiteOne();
        practiceSiteOnePage.inputName(config.getTestConfig().getUsernameW2A()).unFocusNameInput();
        practiceSiteOnePage.clickTestLink();
        scrollBy(driver.get(), "500");
        Assert.assertEquals(getActualYCoordinate(driver.get()), "500");
    }
}
