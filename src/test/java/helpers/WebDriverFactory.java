package helpers;

import config.TestConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static org.openqa.selenium.UnexpectedAlertBehaviour.ACCEPT;

public class WebDriverFactory {
    protected static TestConfigFactory config = TestConfigFactory.getInstance();

    public enum Browser {
        CHROME, IE, FIREFOX, EDGE
    }

    /**
     * Выбор браузра в зависимости от значения, указанного в файле 'properties.conf'
     *
     * @return возвращает драйвер в зависимости от выбранного браузера
     */
    public static WebDriver createWebDriver() throws MalformedURLException {
        switch (config.getWebConfig().getBrowser()) {
            case CHROME:
                return getChromedriver();
            case FIREFOX:
                return getFirefoxDriver();
            case EDGE:
                return getEdgeDriver();
            case IE:
                return getIEDriver();
            default:
                return getChromedriver();
        }
    }

    /**
     * Настройка Chrome-драйвера
     *
     * @return возвращает экземпляр Chrome-драйвера
     */
    private static WebDriver getChromedriver() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions()
                .addArguments("--remote-allow-origins=*")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage")
                .addArguments("--disable-extensions")
                .addArguments("--window-size=1920,1080");
        if (config.getWebConfig().isHeadlessMode()) {
            chromeOptions.addArguments("--headless=new");
        }
        if (config.getWebConfig().isRemoteDriver()) {
            chromeOptions.setCapability("platformName", "windows");
            return new RemoteWebDriver(new URL(config.getWebConfig().getRemoteUrl()), chromeOptions);
        } else return new ChromeDriver(chromeOptions);
    }

    /**
     * Настройка Firefox-драйвера
     *
     * @return возвращает экземпляр Firefox-драйвера
     */
    private static WebDriver getFirefoxDriver() throws MalformedURLException {
        FirefoxOptions firefoxOptions = new FirefoxOptions()
                .addArguments("-width=1920")
                .addArguments("-height=1080");
        if (config.getWebConfig().isHeadlessMode()) {
            firefoxOptions.addArguments("-headless");
        }
        if (config.getWebConfig().isRemoteDriver()) {
            firefoxOptions.setCapability("platformName", "windows");
            return new RemoteWebDriver(new URL(config.getWebConfig().getRemoteUrl()), firefoxOptions);
        } else return new FirefoxDriver(firefoxOptions);
    }

    /**
     * Настройка Edge-драйвера
     *
     * @return возвращает экземпляр Edge-драйвера
     */
    private static WebDriver getEdgeDriver() throws MalformedURLException {
        EdgeOptions edgeOptions = new EdgeOptions()
                .addArguments("--remote-allow-origins=*")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage")
                .addArguments("--disable-extensions")
                .addArguments("--window-size=1920,1080");
        if (config.getWebConfig().isHeadlessMode()) {
            edgeOptions.addArguments("-headless");
        }
        if (config.getWebConfig().isRemoteDriver()) {
            edgeOptions.setCapability("platformName", "windows");
            return new RemoteWebDriver(new URL(config.getWebConfig().getRemoteUrl()), edgeOptions);
        } else return new EdgeDriver(edgeOptions);
    }

    /**
     * Настройка  Internet Explorer-драйвера
     *
     * @return возвращает экземпляр  Internet Explorer-драйвера
     */
    private static WebDriver getIEDriver() throws MalformedURLException {
        InternetExplorerOptions ieOptions = new InternetExplorerOptions();
        ieOptions.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING, false);
        ieOptions.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
        ieOptions.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);
        ieOptions.setUnhandledPromptBehaviour(ACCEPT);
        ieOptions.destructivelyEnsureCleanSession();
        ieOptions.ignoreZoomSettings();
        ieOptions.introduceFlakinessByIgnoringSecurityDomains();
        if (config.getWebConfig().isRemoteDriver()) {
            ieOptions.setCapability("platformName", "windows");
            return new RemoteWebDriver(new URL(config.getWebConfig().getRemoteUrl()), ieOptions);
        } else return new InternetExplorerDriver(ieOptions);
    }
}
