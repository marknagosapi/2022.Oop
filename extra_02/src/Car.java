public class Car {
    private final String carType;
    private int numberOfKilometers;
    private final int yearOfManufacture;
    private final String carBrand;
    private final int maxPassengers;
    private int speed;
    private final Color color;
    private final FuelType fuelType;

    public Car(String carType, String carBrand, int fuel, boolean b, int yearOfManufacture){
        this.carType = carType;
        this.carBrand = carBrand;

        switch (carBrand.charAt(0)) {
            case 'R' -> this.color = Color.RED;
            case 'G' -> this.color = Color.GREEN;
            case 'B' -> this.color = Color.BLUE;
            case 'W' -> this.color = Color.WHITE;
            default -> this.color = Color.BLACK;
        }

        switch(fuel){
            case 0 -> this.fuelType = FuelType.DIESEL;
            case 1 -> this.fuelType = FuelType.PETROL;
            case 2 -> this.fuelType = FuelType.GAS;
            case 3 -> this.fuelType = FuelType.ELECTRIC;
            default -> this.fuelType = FuelType.HYBRID;
        }

        this.speed = 0;
        this.numberOfKilometers = 0;

        if(b){
            this.maxPassengers = 5;
        } else {
            this.maxPassengers = 2;
        }

        this.yearOfManufacture = yearOfManufacture;
    }
    public Car(String carType, String carBrand,Color color, FuelType fuelType, int numberOfKilometers,int maxPassengers, int yearOfManufacture){
        this.carType = carType;
        this.carBrand = carBrand;
        this.color = color;
        this.fuelType = fuelType;
        this.maxPassengers = maxPassengers;
        this.numberOfKilometers = numberOfKilometers;
        this.yearOfManufacture = yearOfManufacture;
    }

    public void moveCar(int kilometersTraveled){
        if(kilometersTraveled >= 0) {
            this.numberOfKilometers += kilometersTraveled;
        }
    }
    public int getNumberOfKilometers(){
        return numberOfKilometers;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public String getCarType(){
        return carType;
    }

    public int getSpeed() {
        return speed;
    }

    public Color getColor() {
        return color;
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void resetMileage(){
        this.numberOfKilometers = 0;
    }

    public void changeSpeed(int newSpeed){
        if(newSpeed >= 0){
            this.speed = newSpeed;
        }
    }

    public String toString(){
        String helper;
        if(maxPassengers == 5){
            helper = "family car";
        } else {
            helper = "two-seater car";
        }

        return carType + " " + carBrand + " " + helper + " manufactured in " + yearOfManufacture + ".\n" + "\t\t\t Properties:\n" + "\t\t\t\t-COLOR: " +
                color + "\n" + "\t\t\t\t-FUEL: " + fuelType + "\n" + "\t\t\t\t-KMs traveled: " + numberOfKilometers + "\n";
    }
}
