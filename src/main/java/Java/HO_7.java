package Java;

import java.util.HashMap;
import java.util.Map;

public class HO_7 {
    public static void main(String[] args) {
        Map<String, Integer> colors = new HashMap<>();

        colors.put("Red", 0);
        colors.put("Green", 1);
        colors.put("Blue", 2);

        colors.remove("Blue");
        System.out.println(colors.containsValue(2));

        System.out.println(colors.size());
    }
}
