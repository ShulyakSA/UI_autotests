package steps;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

import static helpers.Waits.*;

@Slf4j
public class MainSteps extends BasePage {
    WebDriver driver;

    public MainSteps(final WebDriver webDriver) {
        super(webDriver);
        this.driver = webDriver;
    }

    public static void clickButton(WebDriver driver, WebElement element) {
        waitElementIsClickable(driver, element);
        element.click();
    }

    public static void scrollToElement(WebDriver driver, WebElement element) {
        waitElementIsVisible(driver, element);
        new Actions(driver).scrollToElement(element).build().perform();
    }

    public static void clearAndType(WebDriver driver, WebElement element, String text) {
        waitElementIsVisible(driver, element);
        element.clear();
        element.sendKeys(text);
    }

    public static void switchToWindow(WebDriver driver) {
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    public static String getText(WebDriver driver, WebElement element) {
        waitElementIsVisible(driver, element);
        return element.getText();
    }
}
