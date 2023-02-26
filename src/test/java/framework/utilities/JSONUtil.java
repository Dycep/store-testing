package framework.utilities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class JSONUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();


    public static <T> T parseJsonToCLass(String filePath, Class<T> clazz){
        try {
            return objectMapper.readValue(new File(filePath), clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static <T> T[] parseJsonArrayToObjectsArray(String filePath, Class<T> clazz){
        try {
            T[] tArray = (T[]) objectMapper.readValue(new File(filePath), clazz);
            return tArray;
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getValueFromJsonFileByKey(String filePath, String key){
        Map<?,?> map;
        try {
            map = objectMapper.readValue(new File(filePath), Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        for (Map.Entry<?, ?> entry : map.entrySet()) {
            if(entry.getKey()==key)
                return (String) entry.getValue();
        }
        return null;
    }

    public static Map<?,?> getMapFromJsonFile(String filePath){
        try {
            return objectMapper.readValue(new File(filePath), Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

}
