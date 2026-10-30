package Java;

import java.util.ArrayList;
import java.util.List;

public class HO_6 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));

        System.out.println(list.add(11));
        System.out.println(list.remove(1));
        System.out.println(list.set(2,22));
        System.out.println(list.get(2));
        System.out.println(list.size());
    }
}
