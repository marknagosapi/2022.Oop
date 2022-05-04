package oop.labor10.lab10_3;

public class Product implements Comparable<Product>{

    //Variables
    //Hasznalj final-t ahol indokolt
    private int ID;
    private String name;
    private int amount;
    private int price;

    //Constructor

    public Product(int id, String name, int amount, int price){
        this.ID = id;
        this.name = name;
        this.amount = amount;
        this.price = price;
    }

    //Methods

    public void increaseAmount(int newAmount){
        amount+=newAmount;
    }

    public String getName() {
        return name;
    }

    public int getID() {
        return ID;
    }

    public int getAmount() {
        return amount;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    @Override
    public int compareTo(Product o) {
        return this.ID - o.ID;
    }
}
