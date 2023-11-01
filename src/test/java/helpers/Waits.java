package helpers;

import lombok.SneakyThrows;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static config.WebConfig.getExplicitWait;

public class Waits {
    private static Waits instance;
    private final WebDriverWait wait;

    public static Waits getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new Waits(driver);
        }
        return instance;
    }

    public Waits(WebDriver driver) {
        wait = new WebDriverWait(driver, getExplicitWait());
    }

    @SneakyThrows(NoSuchElementException.class)
    public static WebElement waitElementIsVisible(WebDriver driver, final WebElement element) {
        getInstance(driver).wait.until(ExpectedConditions.visibilityOf(element));
        return element;
    }

    @SneakyThrows(NoSuchElementException.class)
    public static WebElement waitElementIsClickable(WebDriver driver, final WebElement element) {
        getInstance(driver).wait.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }
}
