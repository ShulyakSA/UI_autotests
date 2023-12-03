package config;

import helpers.WebDriverFactory;
import lombok.Data;

@Data
public class WebConfig {
    private String w2aBaseUrl;
    private String w2aDropPageUrl;
    private String sqlExUrl;
    private String remoteUrl;
    private String w2aFramesAndWindowsUrl;
    private WebDriverFactory.Browser browser;
    private boolean remoteDriver;
    private boolean headlessMode;
    private int retryCount;
    private boolean clearCookies;
    private int explicitWait;
}