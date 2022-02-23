import java.util.Scanner;

// A szabalyossag az egyesek valtakozasban abban figyelheto meg, hogy a 2-nek minden hatvanyaban keves egyes szerepel min 2n-t hatvanyon van a legtobb egyes
public class Exercise6 {

    public static int countBits(int number){
        int counter = 0;
        while(number!=0){
            if((number & 1) == 1){
                counter++;
            }
            number >>= 2;
        }
        return counter;
    }
    public static void main(String[] args){

        for(int i=0;i<31;i++){
            System.out.println(i + ": " + countBits(i));
        }

    }
}
