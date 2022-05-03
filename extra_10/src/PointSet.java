import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PointSet {

    private ArrayList<Point> points = new ArrayList<>();

    //Constructor
    public PointSet(int numPoints){
        Random rand = new Random();
        double x,y;
        numPoints++;
        while(numPoints!=0){
            points.add(new Point(rand.nextDouble(50), rand.nextDouble(50)));
            numPoints--;
        }
    }

    public PointSet(String filename){
        try(Scanner scanner = new Scanner(new File("inputFiles/"+filename))){
            String temp;
            String[] temp2;
            while(scanner.hasNextLine()){
                temp = scanner.next();
                temp2 = temp.split(",");
                points.add(new Point(Double.parseDouble(temp2[0].trim()),Double.parseDouble(temp2[1].trim())));
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    //Methods

    public Point getPoint(int index){
        if(index < 0 || index > points.size()-1){
            System.out.println("INDEX OUT OF BOUND!");
            return null;
        } else {
            return points.get(index);
        }
    }

    public void print(){
        for(Point p: points){
            System.out.println(p);
        }
    }

    public void sort(Comparator<Point> cmp){
        points.sort(cmp);
    }
}
