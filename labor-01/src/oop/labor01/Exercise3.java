import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args){

        //If we want the input from console
        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("The String:");
        String word = sc.nextLine();

         */
        String word = "Kerekes Balint Jozsef Peter";
        int n = word.length();

        String[] arrOfStr = word.split(" ");

        String monogramm = "";

        for(String i: arrOfStr){
            monogramm += String.valueOf(i.charAt(0));
        }

        System.out.println("The monogram: " + monogramm);

    }
}
