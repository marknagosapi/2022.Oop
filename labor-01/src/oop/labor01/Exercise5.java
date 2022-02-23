import java.util.*;

public class Exercise5 {
    public static byte getBit(int number, int order){
        if(order<0 || order > 8){
            return -1;
        }
        return (byte) ((number>>=order) & 1);
    }

    public static int count(int number){
        int counter = 0;
        while(number!=0){
            number = number / 2;
            counter++;
        }
        return counter;
    }

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        //int howManyTimes = count(n);
        int howManyTimes =  8;
        for(int i=8;i>=0;i--) {
            System.out.print(getBit(n, i));
        }
    }
}
