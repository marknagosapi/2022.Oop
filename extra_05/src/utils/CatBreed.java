package utils;

public enum CatBreed {
    Polydactyl("Polydactyl"),
    Snowshoe("Showshoe"),
    Calico("Calico"),
    BritishShorthair("British Shorthair"),
    Siamese("Siamese"),
    JapaneseBobtail("Japanese Bobtail"),
    Persian("Persian"),
    ScottishFold("Scottish Fold"),
    GrayTabby("Gray Tabby");

    //Constructors
    private CatBreed(String a) {
        this.value = a;
    }

    private CatBreed() {

    }

    //Variables
    private String value;

    //Methods

    public String toString() {
        return this.value;
    }
}
