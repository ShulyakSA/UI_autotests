package config;

import com.typesafe.config.ConfigFactory;
import lombok.extern.slf4j.Slf4j;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigBeanFactory;

@Slf4j
public class TestConfigFactory {
    private volatile Config config;
    private volatile WebConfig webConfig;
    private volatile TestConfig testConfig;

    private TestConfigFactory() {
        config = ConfigFactory.systemProperties()
                .withFallback(ConfigFactory.systemEnvironment())
                .withFallback(ConfigFactory.parseResources("properties.conf"));
    }

    public synchronized WebConfig getWebConfig() {
        if (webConfig == null) {
            webConfig = ConfigBeanFactory.create(config.getConfig("web"), WebConfig.class);
        }
        return webConfig;
    }

    public synchronized TestConfig getTestConfig() {
        if (testConfig == null) {
            testConfig = ConfigBeanFactory.create(config.getConfig("testData"), TestConfig.class);
        }
        return testConfig;
    }

    public static synchronized TestConfigFactory getInstance() {
        return new TestConfigFactory();
    }
}