package pages;

import elements.Footer;
import elements.Header;
import elements.NavBar;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static config.WebConfig.getUrl;
import static helpers.Waits.waitElementIsVisible;
import static steps.MainSteps.clickButton;
import static steps.MainSteps.scrollToElement;

@Slf4j
public class MainPage extends BasePage {
    private final String LIFETIME_MEMBERSHIP = " Lifetime Membership ";
    private final String ONLINE_TRAINING = " Online Training ";
    private final String VIDEO_TUTORIALS = " Video Tutorials";
    private final String CORPORATE_TRAINING = " Corporate Training ";
    private final String APPIUM_COURSE = " Appium Mobile Automation Testing for Android and IOS ";
    @FindBy(xpath = "//h1[text()='Best Selenium Certification Course Online']")
    WebElement certificationTitle;
    @FindBy(xpath = "//*[@data-id='1e537621']")
    WebElement certificationBlock;
    @FindBy(xpath = "//*[@data-id='166618a']")
    WebElement courseBlock;
    @FindBy(xpath = ".//div[@aria-label='Next slide']")
    WebElement nextSlideButton;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
        openMainPage();
    }

    void openMainPage() {
        driver.get(getUrl());
    }

    public Header onHeader() {
        return new Header(driver);
    }

    public NavBar onNavBar() {
        return new NavBar(driver);
    }

    public Footer onFooter() {
        return new Footer(driver);
    }

    private WebElement findElementByText(String text, WebElement rootElement) throws NoSuchElementException {
        try {
            waitElementIsVisible(driver, rootElement);
            return rootElement.findElement(By.xpath(String.format(".//*[text()='%s']", text)));
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.error("'" + text + "' ELEMENT IS NOT FOUND");
            return null;
        }
    }

    private WebElement getCertificationBlockElement(String text) throws NoSuchElementException {
        return findElementByText(text, certificationBlock);
    }

    private WebElement getCoursesBlockElement(String text) throws NoSuchElementException {
        return findElementByText(text, courseBlock);
    }

    public WebElement getLifetimeMembership() {
        return getCertificationBlockElement(LIFETIME_MEMBERSHIP);
    }

    public WebElement getOnlineTraining() {
        return getCertificationBlockElement(ONLINE_TRAINING);
    }

    public WebElement getVideoTutorials() {
        return getCertificationBlockElement(VIDEO_TUTORIALS);
    }

    public WebElement getCorporateTraining() {
        return getCertificationBlockElement(CORPORATE_TRAINING);
    }

    public WebElement getCertificationTitle() {
        return certificationTitle;
    }

    public WebElement getAppiumCourse() {
        return getCoursesBlockElement(APPIUM_COURSE);
    }

    public void clickButtonNextSlide() {
        clickButton(driver, nextSlideButton);
    }

    public MainPage scrollToCourseBlock() {
        scrollToElement(driver, courseBlock);
        return this;
    }

    public MainPage scrollToCertificationBlock() {
        scrollToElement(driver, certificationBlock);
        return this;
    }
}