import java.util.Random;
import java.util.Arrays;
import java.time.Duration;
import java.time.Instant;
        //Instant start = Instant.now();
//your code
       // Instant end = Instant.now();
        // Duration timeElapsed = Duration.between(start, end);
       // System.out.println("Time taken: "+ timeElapsed.toMillis() +" milliseconds");
public class EF1 {
    public static void copy(int[] a, int[] b){
        for(int i=0;i<a.length;i++){
            a[i] = b[i];
        }
    }
    public static int binarySearch(int e, int u, int array[],int k){
        while(e<=u){
            int mid = (e+u)/2;
            if(array[mid]==k){
                return mid;
            }
            if(array[mid] < k){
                return binarySearch(e,mid-1,array,k);
            } else{
                return binarySearch(mid+1,u,array,k);
            }
        }
        return -1;
    }
    public static void ExtraFeladat2(int array[]){

        //Binary Search Java
        long start = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            //binarySearch(0,array.length,array,array[i]);
            Arrays.binarySearch(array,array[i]);

        }
        long end = System.currentTimeMillis();

        double sec = (end - start) / 1000F;

        System.out.println("[EF] Binary Search written by Java Developers: "  + sec + " seconds");

        //My Binary Search
        long start2 = System.currentTimeMillis();
        for(int i=0;i<10000;i++){
            //binarySearch(0,array.length,array,array[i]);
            binarySearch(0,array.length-1,array,array[i]);

        }
        long end2 = System.currentTimeMillis();

        double sec2 = (end2-start2)/ 1000F;

        System.out.println("[EF] Binary Search written by me: " + sec2 + " seconds");
    }
    public static void ExtraFeladat(int array[]){
        Random rand =  new Random();

        for(int i=0;i<1000000;i++){
            array[i] = rand.nextInt();
        }

        Arrays.sort(array);

        int duplum = 0;
        for(int i=0;i<array.length-2;i++){
            if(array[i] == array[i+1] && array[i+1] != array[i+2]){
                duplum++;
                //System.out.println(array[i]+ " " + array[i+1] + " " + array[i+2]);
            }
        }
        System.out.println("[EF] A duplumok szama: " + duplum);
    }
    public static void main(String[] args){
        int[] x = new int[1000000];
        ExtraFeladat(x);
        int[] y = new int[10000];
        copy(y,x);
        ExtraFeladat2(y);
    }
}
