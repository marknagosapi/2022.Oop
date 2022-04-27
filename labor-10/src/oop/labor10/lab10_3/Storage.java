package oop.labor10.lab10_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class Storage {

    //Variables
    private ArrayList<Product> products = new ArrayList<>();

    //Constructor
    public Storage(String filename){
        try(Scanner scanner = new Scanner(new File("inputFiles/"+filename))){
            String temp;
            String[] m;
            while(scanner.hasNextLine()){
                temp = scanner.nextLine();
                m = temp.split(" ");
                products.add(new Product(Integer.parseInt(m[0].trim()),m[1].trim(),Integer.parseInt(m[2].trim()),Integer.parseInt(m[3].trim())));
            }

            Collections.sort(products);

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    //Methods

    public void update(String fileName){
        int counter = 0;
        try(Scanner scanner = new Scanner(new File("inputFiles/"+fileName))){
            String temp;
            String[] m;
            while(scanner.hasNextLine()){
                temp = scanner.nextLine();
                m = temp.split(" ");

                int index = binarySearch(products,0,products.size()-1,Integer.parseInt(m[0].trim()));

                if(index!=-1) {
                    products.get(index).increaseAmount(Integer.parseInt(m[1].trim()));
                    counter++;
                }
            }

            System.out.println(counter+ " products successfully updated!");

        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static int binarySearch(ArrayList<Product> products,int e,int u, int key){
        if(e<=u){
            int mid = (e+u)/2;
            if(products.get(mid).getID()==key){
                return mid;
            }

            if(products.get(mid).getID() > key){
                return binarySearch(products,e,mid-1,key);
            }

            return binarySearch(products,mid+1, u,key);
        } else {
            return -1;
        }
    }
}
