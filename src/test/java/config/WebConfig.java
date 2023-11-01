package config;

import java.time.Duration;

import static java.lang.Long.parseLong;
import static java.time.Duration.ofSeconds;

public class WebConfig extends ConfigProvider {
    public static String getUrl() {
        return getProperty("baseUrl");
    }

    public static String getBrowser() {
        return getProperty("browser");
    }

    public static Boolean getClearCookies() {
        return Boolean.valueOf(getProperty("clear_cookies"));
    }

    public static Duration getExplicitWait() {
        return ofSeconds(parseLong(getProperty("explicit_wait")));
    }
}
