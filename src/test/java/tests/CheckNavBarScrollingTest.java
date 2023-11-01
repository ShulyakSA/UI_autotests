package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static steps.Checkers.checkElementIsDisplayed;

public class CheckNavBarScrollingTest extends BaseTest {
    @Test(description = "Проверка, что при скроллинге отображается основное меню в шапке на главной")
    public void checkCourseBlockSlider() {
        mainPage.scrollToCourseBlock();
        Assert.assertTrue(checkElementIsDisplayed(mainPage.onNavBar().getHomeMenu()));
    }
}
