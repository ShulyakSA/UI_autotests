package steps;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import pages.BasePage;

@Slf4j
public class Checkers extends BasePage {
    WebDriver driver;

    public Checkers(final WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }

    @Step("Проверка видимости элемента")
    public static Boolean checkElementIsDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NullPointerException e) {
            log.error("ELEMENT IS NOT DISPLAYED");
            return false;
        }
    }

    @Step("Проверка наличия элемента")
    public static Boolean checkElementIsPresent(WebElement element) {
        try {
            return element.isEnabled();
        } catch (NullPointerException e) {
            log.error("ELEMENT IS NOT PRESENT");
            return false;
        }
    }
}
