package utils;

public enum DogBreed {
    LabradorRetrievers("Labrador Retrievers"),
    GermanShepherds("German Shepherds"),
    GoldenRetrievers("Golden Retrievers"),
    FrenchBulldogs("French Bulldogs"),
    Bulldogs("Bulldogs"),
    Beagles("Beagles"),
    Poodles("Poodles");

    //Constructors

    private DogBreed(String value) {

        this.value = value;

    }
    private DogBreed() {

    }

    //Variables
    private String value;

    public String toString() {
        return this.value;
    }
}
