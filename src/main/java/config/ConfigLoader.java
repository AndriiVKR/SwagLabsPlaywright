package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private static final Properties properties = new Properties();

    static {
        try (FileInputStream input = new FileInputStream("src/main/resources/config.properties")) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load config.properties", e);
        }
    }

    // Regular String getter
    public static String get(String key) {
        return properties.getProperty(key);
    }

    public static String getBaseUrl() {
        return get("base.url");
    }

    // Boolean getter
    public static boolean getBoolean(String key) {
        return Boolean.parseBoolean(properties.getProperty(key));
    }



}
