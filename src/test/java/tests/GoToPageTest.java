package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;

public class GoToPageTest extends BaseTest {
    @Epic(value="Навигационная панель")
    @Feature(value="Переходы по меню")
    @Story(value="Переходы по меню 'Resources'")
    @Severity(BLOCKER)
    @Test(description = "Проверка перехода по меню 'Resources' на страницу 'Practice Site 1'")
    public void goToPage() {
        mainPage.onNavBar().clickResources().clickPracticeSiteOne();
        Assert.assertEquals(practiceSiteOnePage.getTitleLoadForm(), practiceSiteOnePage.TITLE_LOAD_FORM_);
    }
}
