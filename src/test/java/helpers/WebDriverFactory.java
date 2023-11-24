package helpers;

import config.TestConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {
    protected static TestConfigFactory config = TestConfigFactory.getInstance();

    /**
     * Выбор браузра в зависимости от значения, указанного в файле 'config.properties'
     *
     * @return возвращает драйвер в зависимости от выбранного браузера
     */
    public static WebDriver createWebDriver() throws MalformedURLException {
        switch (config.getWebConfig().getBrowser()) {
            case "CHROME":
                return getChromedriver();
            case "MOZILLA":
                return getFirefoxDriver();
            default:
                return getChromedriver();
        }
    }

    /**
     * Настройка Chrome-драйвера
     *
     * @return возвращает экземпляр chrome-драйвера
     */
    private static WebDriver getChromedriver() throws MalformedURLException {
        ChromeOptions chromeOptions = new ChromeOptions()
                .addArguments("--remote-allow-origins=*")
                .addArguments("--no-sandbox")
                .addArguments("--disable-dev-shm-usage")
                .addArguments("--disable-extensions")
                .addArguments("--window-size=1920,1080")
                .addArguments("--headless=new");
        chromeOptions.setCapability("platformName", "windows");
        return new RemoteWebDriver(new URL(config.getWebConfig().getRemoteUrl()), chromeOptions);
    }

    /**
     * Настройка Firefox-драйвера
     *
     * @return возвращает экземпляр firefox-драйвера
     */
    private static WebDriver getFirefoxDriver() throws MalformedURLException {
        FirefoxOptions firefoxOptions = new FirefoxOptions()
                .addArguments("-width=1920")
                .addArguments("-height=1080")
                .addArguments("-headless");
        return new RemoteWebDriver(new URL(config.getWebConfig().getRemoteUrl()), firefoxOptions);
    }
}
