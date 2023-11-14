package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.qameta.allure.SeverityLevel.MINOR;
import static steps.Checkers.checkElementIsDisplayed;

@Epic(value = "Главная страница")
@Feature(value = "Отображение панели при скроллинге")
public class CheckNavBarScrollingTest extends BaseTest {
    @BeforeTest
    public void openPage() {
        mainPage.openMainPage();
    }

    @Story(value = "Видимость элементов при скроллинге")
    @Severity(MINOR)
    @Test(description = "Проверка, что при скроллинге отображается основное меню в шапке на главной")
    public void checkCourseBlockSlider() {
        mainPage.scrollToCourseBlock();
        Assert.assertTrue(checkElementIsDisplayed(mainPage.onNavBar().getHomeMenu()));
    }
}
