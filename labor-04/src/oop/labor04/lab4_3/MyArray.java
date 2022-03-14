package oop.labor04.lab4_3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.sqrt;

public class MyArray {
    //Variables
    private int length;
    private double[] elements = null;

    //Constructors
    public MyArray(int length){
        this.length = length;
        elements = new double[length];
    }

    public MyArray(MyArray array){
        this.length = array.length;
        if (this.length >= 0) System.arraycopy(array.elements, 0, this.elements, 0, this.length);
    }

    public MyArray(double[] elements){
        this.elements = new double[elements.length];
        this.length = elements.length;
        for(int i=0;i<this.length;i++) {
            this.elements[i] = elements[i];
        }
    }

    public MyArray(String fileName){
        Scanner inputArray = null;

        try{
            inputArray = new Scanner(new File("inputFiles/" + fileName));
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }

        String temp = inputArray.nextLine();
        int length = Integer.parseInt(temp);
        this.length = length;
        elements = new double[this.length];
        String temp2 = inputArray.nextLine();
        String[] temp3 = temp2.split(" ");
        for(int i=0;i<length;i++){
            //System.out.println(temp3[i]);
            this.elements[i] = Integer.parseInt(temp3[i]);
        }

     }

    //Methods
    public void fillRandom(double a, double b){
        Random rand = new Random();
        for(int i=0;i<this.length;i++){
            elements[i] = Math.random()*(b-a+1)+a;
        }
    }

    public double mean(){
        double sum = 0;
        for(int i=0;i<this.length;i++){
            sum+=elements[i];
        }
        return (sum/this.length);
    }

    public double stddev(){

        if(this.length <= 0){
            return Double.NaN;
        }

        double SD;
        double mean = this.mean();
        double sum = 0;
        for(int i=0;i<this.length;i++){
            sum+=abs((elements[i]-mean)*(elements[i]-mean));
        }

        SD = sqrt(sum/this.length);

        return SD;
    }

    public void sort(){
        for(int i=0;i<this.length-1;i++){
            for(int j=i+1;j<this.length;j++){
                if(elements[i] > elements[j]){
                    double tmp = elements[j];
                    elements[j] = elements[i];
                    elements[i] = tmp;
                }
            }
        }
    }

    public void print(String array){
        boolean ok = false;
        for(int i=0;i<this.length;i++){
            if(elements[i] != 0){
                ok = true;
                break;
            }
        }
        if(ok) {
            if (elements != null) {
                System.out.println(array + ": ");
                for (int i = 0; i < this.length; i++) {
                    System.out.println(this.elements[i] + " ");
                }
                System.out.println();
            }
        }
    }


    @Override
    public String toString() {
        return "MyArray{" +
                "length=" + length +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }
}
