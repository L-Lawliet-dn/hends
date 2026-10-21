package Java;

public class HO_3 {

    public static void main(String[] args) {
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = i+1;
        }
        int sum = 0;
        for (int i = 0; i < 10; i++) {
            sum+= arr[i];
        }

        if(sum == 30){
            System.out.println("The sum is 30");
        }else{
            System.out.println("The sum is not 30");
        }
    }
}
