package Java;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

class RandomCScannerActivity {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList();
        Random random = new Random();

        System.out.println("enter number of elements: ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Integer[] arr = list.toArray(new Integer[0]);

        int randInt = random.nextInt(list.size());
        System.out.println(arr[randInt]);
    }
}