import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	    Car car = new Car("Ford","Fiesta", 2, true, 2002);
        System.out.println("TEST\n===============================");
        System.out.println(car);
        System.out.println("=============================\n");
        Scanner input = null;
        try {
            input = new Scanner(new File("inputFiles/cars.txt"));
        } catch(FileNotFoundException s) {
            System.out.println("[ERROR] File does Not Exist Please Try Again (Exception:" + s + ")\n");
        }


        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        int n;
        /* If n is greater than the cars in our file [PROBLEM]
        int counter = 0;
        while(input.hasNextLine()){
            ++counter;
            input.
        }

         */
        n = sc.nextInt();

        Car[] cars = new Car[n];
        String cType, cBrand;
        int yOM;
        boolean b;
        int passangers;
        String temp;
        int upper = 4;
        int i = 0;
        int maxCars = 0;
        while(input.hasNext()){
            cType = input.next();
            cBrand = input.next();
            yOM = input.nextInt();
            passangers = rand.nextInt(upper);
            cars[i] = new Car(cType, cBrand, passangers, rand.nextBoolean(), yOM);
            i++;
            maxCars++;
        }
        n = maxCars;
        int howManyDiesel = 0;
        int numberOfRedCars = 0;
        for(int j=0;j<n;j++){
            System.out.println("Car " + (j+1) + ":\n==========================\n" + cars[j] + "==========================\n");
            int howMuchToMove = rand.nextInt(51);
            cars[j].moveCar(howMuchToMove);
            if(cars[j].getSpeed() > 180){
                System.out.println("The " + (j+1) + "th car is driving way too fast!\n");
            } else {
                cars[j].changeSpeed(cars[j].getSpeed() + 10);
            }

            if(cars[j].getNumberOfKilometers() >= 200){
                System.out.println("First car to reach 200+ KMs is the " + j +" indexed car!");
            }

            if(cars[j].getFuelType() == FuelType.DIESEL){
                howManyDiesel++;
            }

            if(cars[j].getColor() == Color.RED){
                numberOfRedCars++;
            }

        }

        System.out.println("\n");
        System.out.println("The number of diesel cars is: " + howManyDiesel);
        System.out.println("The number of red cars is: " + numberOfRedCars);

        for(int j=0;j<n;j++){
            if(cars[j].getFuelType() == FuelType.DIESEL){
                System.out.println(cars[j]);
            }
        }

    }
}
