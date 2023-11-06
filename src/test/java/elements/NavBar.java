package elements;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static helpers.Waits.waitElementIsVisible;
import static steps.MainSteps.clickButton;
import static steps.MainSteps.scrollToElement;

@Slf4j
public class NavBar {
    WebDriver driver;
    private final String HOME_MENU = "Home";
    private final String ALL_COURSES_MENU = "All Courses";
    private final String VIDEO_TUTORIAL_MENU = "Video Tutorial";
    private final String RESOURCES_MENU = "Resources";
    private final String CAREERS = "Careers";
    private final String LIFETIME_MEMBERSHIP = "Lifetime Membership";
    private final String BLOG = "Blog";
    private final String FORUM = "Forum";
    private final String MEMBER_LOGIN = "Member Login";

    @FindBy(xpath = "//div[@class='ast-main-header-wrap main-header-bar-wrap ']")
    WebElement headerNavBar;
    @FindBy(xpath = "//*[@id='menu-item-27618']/a/span[text()='Practice Site 1']")
    WebElement practiceSiteOne;
    @FindBy(xpath = "//*[@id='menu-item-27619']/a/span[text()='Practice Site 2']")
    WebElement practiceSiteTwo;

    public NavBar(final WebDriver webDriver) {
        try {
            PageFactory.initElements(webDriver, this);
            this.driver = webDriver;
        } catch (IllegalStateException e) {
            throw new RuntimeException(e);
        }
    }

    @Step("Поиск элемента '{text}'")
    public WebElement findNavBarElementsByText(String text) throws NoSuchElementException {
        try {
            waitElementIsVisible(driver, headerNavBar);
            return headerNavBar.findElement(By.xpath(String.format(".//*[text()='%s']", text)));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error("'" + text + "' ELEMENT IS NOT FOUND");
            return null;
        }
    }

    public WebElement getHomeMenu() {
        return findNavBarElementsByText(HOME_MENU);
    }

    public WebElement getAllCoursesMenu() {
        return findNavBarElementsByText(ALL_COURSES_MENU);
    }

    public WebElement getVideoTutorialMenu() {
        return findNavBarElementsByText(VIDEO_TUTORIAL_MENU);
    }

    public WebElement getResourcesMenu() {
        return findNavBarElementsByText(RESOURCES_MENU);
    }

    public WebElement getCareers() {
        return findNavBarElementsByText(CAREERS);
    }

    public WebElement getLifetimeMembership() {
        return findNavBarElementsByText(LIFETIME_MEMBERSHIP);
    }

    public WebElement getBlog() {
        return findNavBarElementsByText(BLOG);
    }

    public WebElement getForum() {
        return findNavBarElementsByText(FORUM);
    }

    public WebElement getMemberLogin() {
        return findNavBarElementsByText(MEMBER_LOGIN);
    }

    @Step("Переход к панели навигации")
    public NavBar scrollToNavbar() {
        scrollToElement(driver, headerNavBar);
        return this;
    }

    @Step("Нажатие на элемент '"+RESOURCES_MENU+"'")
    public NavBar clickResources() {
        clickButton(driver, getResourcesMenu());
        return this;
    }

    @Step("Нажатие на элемент 'Practice Site 2'")
    public NavBar clickPracticeSiteTwo() {
        clickButton(driver, practiceSiteTwo);
        return this;
    }

    @Step("Нажатие на элемент 'Practice Site 1'")
    public NavBar clickPracticeSiteOne() {
        clickButton(driver, practiceSiteOne);
        return this;
    }
}
