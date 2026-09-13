package test;

import java.util.HashMap;
import java.util.Map;

public class testMap {
    Map<String, Integer> map = new HashMap<>();

    public void test() {
        map.put("a", 1);
        map.put("b", 2);
        String key = "a";
        if (map.containsKey(key)) {
            int value = map.get(key);
            System.out.println(value);
        } else {
            System.out.println("없는뎁숑");
        }
    }
}
