package JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class Activity1Test {

    static ArrayList<String> list;
    static HO_9 activity;

    @BeforeAll
    static void setUp() {
        list = new ArrayList<>();
        list.add("red");
        list.add("green");

        activity = new HO_9();
    }

    @Test
    void insertTest() {
        activity.insert(list, "blue");

        assertEquals("blue", list.get(2));
        assertEquals(3, list.size());
    }

    @Test
    void replaceTest() {
        activity.replace(list, 0, "orange");

        assertEquals("orange", list.get(0));
    }
}