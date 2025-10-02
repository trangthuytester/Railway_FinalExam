package common.utility;
import java.util.HashMap;
import java.util.Map;

public class TestDataConfig {
    private static final Map<String, JsonDataReader> readers = new HashMap<>();
    static {
        readers.put("global", new JsonDataReader("src/test/resources/data/global.json"));
        readers.put("messages", new JsonDataReader("src/test/resources/data/messages.json"));
        readers.put("station", new JsonDataReader("src/test/resources/data/station.json"));
        readers.put("time", new JsonDataReader("src/test/resources/data/time.json"));
        readers.put("user", new JsonDataReader("src/test/resources/data/user.json"));
    }

    public static String getString(String fileKey, String jsonKey) {
        return readers.get(fileKey).getString(jsonKey);
    }

    public static int getInt(String fileKey, String jsonKey) {
        return readers.get(fileKey).getInt(jsonKey);
    }
}
