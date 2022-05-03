import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Point implements Comparable<Point>{

    //Variables
    private final double x;
    private final double y;

    //Constructor
    public Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    //Methods

    public double slopeTo(Point point){
//        double m1 = (point.y-this.y)/(point.x-this.x);
//        double m2 = 0;
//        double szog = Math.tan(-m1);
        double y = this.y - point.y;
        double x = this.x - point.x;
        return Math.atan2(y,x);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        NumberFormat formatter = new DecimalFormat("#0.00");
        return "(" +
                  formatter.format(x) +
                "," + formatter.format(y) +
                ')';
    }

    @Override
    public int compareTo(Point o) {
        if(this.y == o.y){
            return (int) (this.x - o.x);
        }
        return (int) (this.y - o.y);
    }
}
