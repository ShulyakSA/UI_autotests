package config;

public class TestConfig extends ConfigProvider {
    public static String getUsername() {
        return getProperty("username");
    }

    public static String getPassword() {
        return getProperty("pass");
    }

    public static String getUsernameDescription() {
        return getProperty("description");
    }
}
