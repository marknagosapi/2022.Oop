public class Exercise4 {
    public static double maxElement( double array[] ){
        double max = Double.NEGATIVE_INFINITY;
        for( int i=0; i<array.length; ++i ){
            if( array[i] > max){
                max = array[ i ];
            }
        }
        return max;
    }

    public static double minElement(double array[]){

        double min = Double.POSITIVE_INFINITY;
        for(int i=0;i<array.length;i++){
            if(array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args){
        double x[] ={-7, 1, -3, -45, -9};
        System.out.println("The biggest element of the array: " + maxElement(x));
        System.out.println("The smallest element of the array: " + minElement(x));

    }
}
