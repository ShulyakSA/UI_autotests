package config;

import lombok.Data;

@Data
public class WebConfig {
    private String w2aUrl;
    private String sqlExUrl;
    private String browser;
    private boolean clearCookies;
    private int explicitWait;
}