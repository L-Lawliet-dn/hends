package Java;

import java.util.HashSet;

public class HO_70 {
    public static void main(String[] args) {
        // Create HashSet named hs
        HashSet<String> hs = new HashSet<>();

        // add()
        hs.add("Java");
        hs.add("Python");
        hs.add("C++");

        System.out.println("HashSet: " + hs);

        // contains()
        System.out.println("Contains Java? " + hs.contains("Java"));
        System.out.println("Contains Ruby? " + hs.contains("Ruby"));

        // remove()
        hs.remove("Python");
        System.out.println("After removing Python: " + hs);

        // size()
        System.out.println("Size of HashSet: " + hs.size());

        // isEmpty()
        System.out.println("Is HashSet empty? " + hs.isEmpty());

        // Remove remaining elements
        hs.remove("Java");
        hs.remove("C++");

        System.out.println("Is HashSet empty now? " + hs.isEmpty());
    }
}