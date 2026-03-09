package week.three;

import java.util.HashMap;
import java.util.Map;

public class ManualJson {
    public static void main(String[] args) {

        String json = "{\"name\":\"Ibrahim\",\"age\":25}";

        json = json.substring(1, json.length() - 1);

        String[] pairs = json.split(",");

        Map<String, String> map = new HashMap<>();

        for (String pair : pairs) {

            String[] keyValue = pair.split(":");

            String key = keyValue[0].trim().replace("\"", "");
            String value = keyValue[1].trim().replace("\"", "");

            map.put(key, value);
        }

        System.out.println(map);
    }
}
