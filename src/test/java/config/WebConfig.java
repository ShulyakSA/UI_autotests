package config;

import helpers.WebDriverFactory;
import lombok.Data;

@Data
public class WebConfig {
    private String w2aUrl;
    private String sqlExUrl;
    private String remoteUrl;
    private WebDriverFactory.Browser browser;
    private boolean remoteDriver;
    private boolean headlessMode;
    private int retryCount;
    private boolean clearCookies;
    private int explicitWait;
}