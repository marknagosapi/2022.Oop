import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class Exercise8 {

    public static double average(double array[]){
        int n = array.length;
        if(n <= 0){
            return Double.NaN;
        }
        double average = 0;
        for(int i=0;i<n;i++){
            average+= array[i];
        }
        return (double)(average/n);
    }
    //Standard Deviation
    public static double stddev(double array[]){
        int n = array.length;
        if(n <= 0){
            return Double.NaN;
        }

        double SD;
        double mean = average(array);
        double sum = 0;
        for(int i=0;i<n;i++){
            sum+=abs((i-mean)*(i-mean));
        }

        SD = sqrt(sum/n);


        return SD;
    }
    public static void main(String[] args){
        double[] x = {6,2,3,1};
        System.out.println("The standard deviation of the following data set is: " + stddev(x));
    }
}
