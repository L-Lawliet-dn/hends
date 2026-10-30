package Java;

import org.apache.commons.text.similarity.LevenshteinDistance;

import java.util.Scanner;
//import org.apache.commons.text.similarity.LevenshteinDistance;

public class HO_4 {
    public static void main(String[] args) {
        System.out.print("Enter age in seconds: ");
        System.out.println(23*365*24*60*60);
        Scanner sc = new Scanner(System.in);
        int age = sc.nextInt();

        int days = age / (60 * 60*24);
        int months = days/30;
        int years = months / 12;

        System.out.println("Select your planet: ");
        String planet = sc.next();

        if(isSimilar(planet, "Mercury")){
            System.out.println("Your age on mercury is " + (double)years/0.241 + " years old.");
        }else if(isSimilar(planet, "Venus")){
            System.out.println("Your age on mercury is " + (double)years/0.615 + " years old.");
        }else if (isSimilar(planet,"Mars")){
            System.out.println("Your age on mercury is " + (double)years/1.88 + " years old.");
        }else if (isSimilar(planet,"Jupiter")){
            System.out.println("Your age on mercury is " + (double)years/11.86 + " years old.");
        }else if (isSimilar(planet,"Saturn")){
            System.out.println("Your age on mercury is " + (double)years/29.46 + " years old.");
        }else if (isSimilar(planet,"Uranus")){
            System.out.println("Your age on mercury is " + (double)years/84.01 + " years old.");
        } else if (isSimilar(planet, "Neptune")) {
            System.out.println("Your age on mercury is " + (double)years/164.8 + " years old.");
        }else {
            System.out.println("Enter correct planet!");
        }
    }

    static boolean isSimilar(String str1, String str2){

        LevenshteinDistance distance = new LevenshteinDistance();
        int score = distance.apply(str1, str2);
        if (score <= 3) {
            return true;
        }
        return false;
    }
}