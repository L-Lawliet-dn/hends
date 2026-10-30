package JUnit;

import java.util.ArrayList;

public class HO_9 {

    public void insert(ArrayList<String> list, String value) {
        list.add(value);
    }

    public void replace(ArrayList<String> list, int index, String value) {
        list.set(index, value);
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("red");
        list.add("green");

        HO_9 activity = new HO_9();
        activity.insert(list, "blue");
        activity.replace(list, 0, "orange");

        System.out.println(list);
    }
}