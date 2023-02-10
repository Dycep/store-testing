package utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JSONUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T getValueFromJsonFileByKey(String filePath, String key) {
        Map<?, ?> map;
        try {
            map = objectMapper.readValue(new File(filePath), Map.class);
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (entry.getKey() == key) return (T) entry.getValue();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    public static boolean isJson(String jsonString) {
        try {
            objectMapper.readTree(jsonString);
        } catch (JacksonException e) {
            return false;
        }
        return true;
    }

    public static <T> T parseJsonArrayToObjectsArray(String jsonString, Class<T> clazz) {
        try {
            return objectMapper.readValue(jsonString, clazz);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T getValueFromJsonFileByKey(String filePath, String key, Class<T> clazz) {
        Map<?, ?> map;
        try {
            map = objectMapper.readValue(new File(filePath), Map.class);
            for (Map.Entry<?, ?> entry : map.entrySet()) {
                if (entry.getKey() == key) return (objectMapper.convertValue(entry.getValue(), clazz));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
