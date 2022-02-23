public class Exercise7 {
    public static double average(double[] array){
        int length = array.length;
        if(length <= 0){
            return Double.NaN;
        }
        double sum = 0;
        for (double v : array) {
            sum += v;
        }
        return (sum/length);
    }
    public static void main(String[] args){
        double[] x ={1,5.5,10.5,3};
        System.out.println("The average of the array elements is: " + average(x));
    }
}
