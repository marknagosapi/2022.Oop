import java.util.*;

public class Exercise2 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("The String:");
        String word = sc.nextLine();
        int n = word.length();

        for(int i=0;i<n;i++){
            for(int j=0;j<i+1;j++){
                System.out.print(word.charAt(j));
            }
            System.out.println();
        }

        String name;
    }
}
