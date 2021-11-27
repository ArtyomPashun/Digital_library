package by.epamtc.pashunArtyom.digitalLibrary.dao.properties;

import java.util.HashMap;
import java.util.Map;

public class PropertiesHolder {
    private static final Map<String, String> properties = new HashMap<>();

    static {
        properties.put("USERS_FILE_PATH", "src/resources/users.txt");
        properties.put("BOOKS_FILE_PATH", "src/resources/library.txt");
    }

    public static String getProperty(String key) {
        return properties.get(key);
    }

    public static void addProperty(String key, String value) {
        PropertiesHolder.properties.put(key, value);
    }
}
