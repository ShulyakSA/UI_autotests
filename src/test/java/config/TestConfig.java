package config;

public class TestConfig extends ConfigProvider {
    public static String getUsernameW2A() {
        return getProperty("usernameW2A");
    }

    public static String getPasswordW2A() {
        return getProperty("passW2A");
    }

    public static String getUsernameDescriptionW2A() {
        return getProperty("descriptionW2A");
    }

    public static String getUsernameSqlEx() {
        return getProperty("usernameSqlEx");
    }

    public static String getPasswordSqlEx() {
        return getProperty("passSqlEx");
    }
}
