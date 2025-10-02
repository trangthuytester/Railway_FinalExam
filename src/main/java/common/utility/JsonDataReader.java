package common.utility;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

public class JsonDataReader {
    private Map<String, Object> data;

    public JsonDataReader(String filePath) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            data = mapper.readValue(new File(filePath), Map.class);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read JSON file: " + filePath, e);
        }
    }

    public String getString(String key) {
        Object value = data.get(key);
        if (value == null) return null;
        if ("RANDOM_EMAIL".equals(value.toString())) {
            return generateRandomEmail();
        }
        return value.toString();
    }

    public int getInt(String key) {
        Object value = data.get(key);
        return value != null ? Integer.parseInt(value.toString()) : 0;
    }

    private String generateRandomEmail() {
        String randomString = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
        return "user" + randomString + "@gmail.com";
    }

    @SuppressWarnings("unchecked")
    public Map<String, Object> getMap(String key) {
        Object value = data.get(key);
        if (value instanceof Map) {
            return (Map<String, Object>) value;
        }
        throw new IllegalArgumentException("Value for key '" + key + "' is not a Map");
    }
}
