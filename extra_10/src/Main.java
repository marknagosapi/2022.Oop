import java.util.Comparator;
import java.util.Random;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args){
        TreeSet<Point> point = new TreeSet<Point>();
        System.out.println("\t\t\t||THE POINT||");
        int count = 11;
        double x,y;
        while(count!=0){
            Random rand = new Random();
            point.add(new Point(rand.nextDouble(50), rand.nextDouble(50)));
            count--;
        }

        for(Point value: point){
            System.out.println(value);
        }
        System.out.println("\t\t\t||THE POINTSET||");

        PointSet pointSet = new PointSet("points.txt");
        pointSet.print();
        Point origo = new Point(0,0);
        int i = 0;
        while(pointSet.getPoint(i)!=null){
            System.out.println(pointSet.getPoint(i).slopeTo(origo));
            i++;
        }
        pointSet.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if(o1.slopeTo(origo) == o2.slopeTo(origo)){
                    return o1.compareTo(o2);
                }
                return (int) (o1.slopeTo(origo) - o2.slopeTo(origo));
            }
        });

        pointSet.print();

    }
}
