package lab10_1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write some numbers separated with spaces!");
        String text = scanner.nextLine();
        String[] text2 = text.split(" ");
        double sum = 0;
        for(String t: text2){
            try {
                sum += Double.parseDouble(t);
            }

            catch(NumberFormatException e){
                System.out.println("THE " + t + " IS NOT A NUMBER!");
            }
        }
        System.out.println("SUM: "+sum);
    }
}
