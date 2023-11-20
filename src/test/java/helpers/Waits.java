package helpers;

import config.TestConfigFactory;
import lombok.SneakyThrows;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;

public class Waits {
    private static Waits instance;
    private final WebDriverWait wait;
    protected static TestConfigFactory config = TestConfigFactory.getInstance();


    public static Waits getInstance(WebDriver driver) {
        if (instance == null) {
            instance = new Waits(driver);
        }
        return instance;
    }

    public Waits(WebDriver driver) {
        wait = new WebDriverWait(driver, ofSeconds(config.getWebConfig().getExplicitWait()));
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
