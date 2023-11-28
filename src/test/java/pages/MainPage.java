package pages;

import elements.Footer;
import elements.Header;
import elements.NavBar;
import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static helpers.Waits.waitElementIsVisible;
import static steps.MainSteps.*;

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
    @FindBy(xpath = ".//div[@aria-label='Previous slide']")
    WebElement previousSlideButton;

    public MainPage(final WebDriver webDriver) {
        super(webDriver);
    }

    @Step("Открытие главной страницы way2automation.com")
    public MainPage openMainPage() {
        driver.get(config.getWebConfig().getW2aBaseUrl());
        return this;
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

    @Step("Поиск элемента '{text}'")
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

    @Step("Нажатие на кнопку слайдера 'Next slide'")
    public void clickButtonNextSlide() {
        clickButton(driver, nextSlideButton);
    }

    @Step("Нажатие на кнопку слайдера 'Next slide'")
    public void clickButtonPreviousSlide() {
        clickButton(driver, previousSlideButton);
    }

    @Step("Переход к блоку 'Most Popular Software Testing Courses'")
    public MainPage scrollToCourseBlock() {
        scrollToElement(driver, courseBlock);
        return this;
    }

    @Step("Переход к блоку 'Best Selenium Certification Course Online'")
    public MainPage scrollToCertificationBlock() {
        scrollToElement(driver, certificationBlock);
        return this;
    }
}
