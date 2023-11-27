package steps;

import io.qameta.allure.Step;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

import java.io.*;

import java.util.Scanner;

import static helpers.Waits.waitElementIsClickable;
import static helpers.Waits.waitElementIsVisible;

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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        new Actions(driver).moveToElement(element).perform();
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

    @Step("Сохранение cookies '{cookieName}' в файл")
    public static void saveCookiesInFile(WebDriver driver, String cookieName) {
        File file = new File("src/test/resources/cookies.data");
        try {
            file.delete();
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            fileWrite.write(driver.manage().getCookieNamed(cookieName).getValue());
            fileWrite.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Step("Чтение куки '{cookieName}' из файла")
    public static void addCookiesFromFile(WebDriver driver, String cookieName) {
        try {
            File file = new File("src/test/resources/cookies.data");
            FileReader fileReader = new FileReader(file);
            Scanner scan = new Scanner(fileReader);
            String value = scan.nextLine();
            Cookie cookie = new Cookie(cookieName, value);
            driver.manage().addCookie(cookie);
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Step("Очистка кэша и cookies браузера")
    public static void clearCookies(WebDriver driver) {
        driver.manage().deleteAllCookies();
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("window.sessionStorage.clear()");
    }

    @Step("Обновление страницы")
    public static void refreshPage(WebDriver driver) {
        driver.navigate().refresh();
    }

    @Step("Добавление куки '{cookieName}' в текущую сессию")
    public static void addCookiesOnCurrentSession(WebDriver driver, String cookieName) {
        clearCookies(driver);
        addCookiesFromFile(driver, cookieName);
        refreshPage(driver);
    }

    @Step("Снятие фокуса с элемента '{elementName}'")
    public static void unFocus(WebDriver driver, WebElement element, String elementName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].blur();", element);
    }

    @Step("Вертикальная прокрутка страницы на {pixels} пискелей")
    public static void scrollBy(WebDriver driver, String pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,arguments[0])", pixels);
    }

    @Step("Получение текущей координаты по Y")
    public static String getActualYCoordinate(WebDriver driver) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (js.executeScript("return window.pageYOffset")).toString();
    }
}
