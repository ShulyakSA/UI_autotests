package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Epic(value = "Главная страница")
@Feature(value = "Переходы по меню")
public class GoToPageTest extends BaseTest {
    @BeforeTest
    public void openPage() {
        mainPage.openMainPage();
    }

    @Story(value = "Переходы по меню 'Resources'")
    @Severity(BLOCKER)
    @Test(description = "Проверка перехода по меню 'Resources' на страницу 'Practice Site 1'")
    public void goToPage() {
        mainPage.onNavBar().clickResources().clickPracticeSiteOne();
        Assert.assertEquals(practiceSiteOnePage.getTitleLoadForm(), practiceSiteOnePage.TITLE_LOAD_FORM);
    }
}
