package Java;

interface Addable {
    int add(int num1, int num2);
}

public class HO_71 {
    public static void main(String[] args) {

        // Lambda expression without body (expression lambda)
        Addable addWithoutBody = (num1, num2) -> num1 + num2;

        // Lambda expression with body (block lambda)
        Addable addWithBody = (num1, num2) -> {
            return num1 + num2;
        };

        System.out.println("Without body: " + addWithoutBody.add(10, 20));
        System.out.println("With body: " + addWithBody.add(30, 40));
    }
}