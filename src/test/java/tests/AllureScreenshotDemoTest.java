package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import static steps.Checkers.checkElementIsDisplayed;

@Epic(value="Демонстрации скриншотов в отчете Allure")
@Feature(value="Наличие элементов")
public class AllureScreenshotDemoTest extends BaseTest{
    @BeforeTest
    public void openPage(){
        mainPage.openMainPage();
    }

    @Story(value="Элементы блока с курсами, демонстрация фичи со скриншотами в Allure")
    @Severity(CRITICAL)
    @Test(description = "Проверка слайдера, падающий тест")
    public void checkCourseBlockSlider() {
        mainPage.scrollToCourseBlock().clickButtonPreviousSlide();
        Assert.assertTrue(checkElementIsDisplayed(mainPage.getAppiumCourse()));
    }

    @Story(value="Переходы по меню 'Resources', демонстрация фичи со скриншотами в Allure")
    @Severity(BLOCKER)
    @Test(description = "Проверка перехода по меню 'Resources' на страницу 'Practice Site 1', падающий тест")
    public void goToPage() {
        mainPage.onNavBar().scrollToNavbar().clickResources().clickPracticeSiteOne();
        Assert.assertEquals(practiceSiteOnePage.getTitleLoadForm(), "Title");
    }
}
