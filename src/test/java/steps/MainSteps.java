package steps;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import pages.BasePage;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;

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

    public static void clearAndType(WebElement element, String text) {
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

    public static void saveCookiesInFile(WebDriver driver) {
        File file = new File("src/test/resources/cookies.data");
        try {
            file.delete();
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter bWrite = new BufferedWriter(fileWrite);
            for (Cookie cookie : driver.manage().getCookies()) {
                bWrite.write((cookie.getName() + "|" + cookie.getValue() + "|" + cookie.getDomain() + "|" + cookie.getPath() + "|" + cookie.getExpiry() + "|" + cookie.isSecure()));
                bWrite.newLine();
            }
            bWrite.close();
            bWrite.flush();
            fileWrite.close();
            fileWrite.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void addCookiesFromFile(WebDriver driver) {
        try {
            File file = new File("src/test/resources/cookies.data");
            FileReader fileReader = new FileReader(file);
            BufferedReader bReader = new BufferedReader(fileReader);
            String strline;
            while ((strline = bReader.readLine()) != null) {
                StringTokenizer token = new StringTokenizer(strline, "|");
                while (token.hasMoreTokens()) {
                    String name = token.nextToken();
                    String value = token.nextToken();
                    String domain = token.nextToken();
                    String path = token.nextToken();
                    Date expiry = null;
                    String val;
                    if (!(val = token.nextToken()).equals("null")) {
                        expiry = new SimpleDateFormat("EEE MMM dd H:mm:ss zzz yyyy", Locale.US).parse(val);
                    }
                    Boolean isSecure = new Boolean(token.nextToken()).booleanValue();
                    Cookie cookie = new Cookie.Builder(name, value)
                            .path(path)
                            .domain(domain)
                            .expiresOn(expiry)
                            .isSecure(isSecure)
                            .build();
                    driver.manage().addCookie(cookie);
                }
            }
            bReader.close();
            fileReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addCookiesOnCurrentSession(WebDriver driver) {
        driver.manage().deleteAllCookies();
        addCookiesFromFile(driver);
        driver.navigate().refresh();
    }
}
