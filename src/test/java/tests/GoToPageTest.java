package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class GoToPageTest extends BaseTest {
    @Test(description = "Проверка перехода по меню на любую из страниц")
    public void goToPage() {
        mainPage.onNavBar().clickResources().clickPracticeSiteOne();
        Assert.assertEquals(practiceSiteOnePage.getTitleLoadForm(), practiceSiteOnePage.TITLE_LOAD_FORM_);
    }
}
