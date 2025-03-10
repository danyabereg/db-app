package ru.danyabereg.utils;

import java.io.IOException;
import java.util.Properties;

public final class PropertyUtils {
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    private static void loadProperties() {
        try (var inputStream = PropertyUtils.class.getClassLoader()
                .getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String get(String key) {
        return PROPERTIES.getProperty(key);
    }

    private PropertyUtils() {
    }
}
