package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import static steps.Checkers.checkElementIsDisplayed;
import static steps.Checkers.checkElementIsPresent;

public class MainPageElementsTest extends BaseTest {

    @Test(description = "Проверка наличия элементов хедера с реквизитами для связи")
    public void checkHeaderElementsPresent() {
        mainPage.onHeader().scrollToHeader();
        SoftAssert assertContacts = new SoftAssert();
        assertContacts.assertTrue(checkElementIsPresent(mainPage.onHeader().getFirstWhatsAppNumber()));
        assertContacts.assertTrue(checkElementIsPresent(mainPage.onHeader().getSecondWhatsAppNumber()));
        assertContacts.assertTrue(checkElementIsPresent(mainPage.onHeader().getPhoneNumber()));
        assertContacts.assertTrue(checkElementIsPresent(mainPage.onHeader().getSkypeContact()));
        assertContacts.assertTrue(checkElementIsPresent(mainPage.onHeader().getEmail()));
        assertContacts.assertAll();
    }

    @Test(description = "Проверка наличия элементов горизонтального меню")
    public void checkNavBarElementsPresent() {
        mainPage.onNavBar().scrollToNavbar();
        SoftAssert assertNavBar = new SoftAssert();
        assertNavBar.assertTrue(checkElementIsPresent(mainPage.onNavBar().getHomeMenu()));
        assertNavBar.assertTrue(checkElementIsPresent(mainPage.onNavBar().getAllCoursesMenu()));
        assertNavBar.assertTrue(checkElementIsPresent(mainPage.onNavBar().getVideoTutorialMenu()));
        assertNavBar.assertTrue(checkElementIsPresent(mainPage.onNavBar().getResourcesMenu()));
        assertNavBar.assertTrue(checkElementIsPresent(mainPage.onNavBar().getCareers()));
        assertNavBar.assertTrue(checkElementIsPresent(mainPage.onNavBar().getLifetimeMembership()));
        assertNavBar.assertTrue(checkElementIsPresent(mainPage.onNavBar().getBlog()));
        assertNavBar.assertTrue(checkElementIsPresent(mainPage.onNavBar().getForum()));
        assertNavBar.assertTrue(checkElementIsPresent(mainPage.onNavBar().getMemberLogin()));
        assertNavBar.assertAll();
    }

    @Test(description = "Проверка наличия элементов блока с сертификацией")
    public void checkCertificationElementsPresent() {
        mainPage.scrollToCertificationBlock();
        SoftAssert assertCertBlock = new SoftAssert();
        assertCertBlock.assertTrue(checkElementIsPresent(mainPage.getCertificationTitle()));
        assertCertBlock.assertTrue(checkElementIsPresent(mainPage.getLifetimeMembership()));
        assertCertBlock.assertTrue(checkElementIsPresent(mainPage.getOnlineTraining()));
        assertCertBlock.assertTrue(checkElementIsPresent(mainPage.getVideoTutorials()));
        assertCertBlock.assertTrue(checkElementIsPresent(mainPage.getCorporateTraining()));
        assertCertBlock.assertAll();
    }

    @Test(description = "Проверка наличия элементов слайдера в блоке с курсами")
    public void checkCourseBlockSlider() {
        mainPage.scrollToCourseBlock().clickButtonNextSlide();
        Assert.assertTrue(checkElementIsDisplayed(mainPage.getAppiumCourse()));
    }

    @Test(description = "Проверка наличия элементов футера")
    public void checkFooterElementsPresent() {
        mainPage.onFooter().scrollToFooter();
        SoftAssert assertFooter = new SoftAssert();
        assertFooter.assertTrue(checkElementIsPresent(mainPage.onFooter().getImportantLinks()));
        assertFooter.assertTrue(checkElementIsPresent(mainPage.onFooter().getCourses()));
        assertFooter.assertTrue(checkElementIsPresent(mainPage.onFooter().getAboutUs()));
        assertFooter.assertAll();
    }
}
