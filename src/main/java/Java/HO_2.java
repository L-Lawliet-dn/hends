package Java;

interface Car{
/*

In Java, variables declared inside an interface are implicitly public, static, and final.
Because they are final, they cannot be changed later, and because interfaces cannot be instantiated,
there is no object state or constructor to initialize them later, making an immediate value assignment
mandatory.

 */

    String brand = "Toyota";
    String color = "Black";

    void getBrand();
    void getColor();
}

class Activity1 implements Car{

    public void getBrand() {
        System.out.println(Car.brand);
    }

    public void getColor(){
        System.out.println("Blue");
    }

    public static void main(String[] args) {
        Car car = new Activity1();
        car.getBrand();
        car.getColor();
    }
}