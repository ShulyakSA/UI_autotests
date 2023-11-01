package config;

import lombok.extern.slf4j.Slf4j;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

@Slf4j
public class ConfigProvider {
    public static Properties properties;

    /**
     * @param key название переменной тип String
     * @return значение переменной
     */
    public static String getProperty(String key) {
        String value = null;
        properties = new Properties();
        try {
            properties.load(new FileInputStream("src/test/resources/config.properties"));
            value = properties.getProperty(key);
        } catch (IOException e) {
            log.error("Файл свойств отсутствует!");
            e.printStackTrace();
        }
        return value;
    }
}
