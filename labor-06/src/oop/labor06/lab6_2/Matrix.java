package oop.labor06.lab6_2;

import java.util.SimpleTimeZone;

public class Matrix {

    //Variables
    private double[][] data;
    private final int rows;
    private final int columns;

    //Constructors
    public Matrix(int rows, int columns){
        this.rows = rows;
        this.columns = columns;
        data = new double[this.rows][this.columns];
    }

    public Matrix(double[][] m){
        this.rows = m.length;
        this.columns = m[1].length;
        //System.out.println(m.length + " "+ m[1].length);
        data = new double[this.rows][this.columns];
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                this.data[i][j] = m[i][j];
            }
        }
    }

    public Matrix(Matrix matrix){
        data = new double[matrix.rows][matrix.columns];
        for(int i=0;i<matrix.rows;i++){
            for(int j=0;j<matrix.columns;j++){
                this.data[i][j] = matrix.data[i][j];
            }
        }
        this.rows = matrix.rows;
        this.columns = matrix.columns;
    }

    //Methods

    public void fillRandom(double a, double b){

        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                this.data[i][j] = Math.random()*(b-a+1)+a;
            }
        }
    }

    public int getColumns() {
        return columns;
    }

    public int getRows() {
        return rows;
    }

    public void printMatrix(){
        for(int i=0;i<this.rows;i++){
            for(int j=0;j<this.columns;j++){
                System.out.printf("%.1f ",this.data[i][j]);
            }
            System.out.println();
        }
    }
    public static Matrix add(Matrix m1, Matrix m2){
        if(m1.rows != m2.rows || m1.columns != m2.columns){
            System.out.println("Cannot add this matrices!\n");
            return null;
        }
        Matrix m3 = new Matrix(m1.rows,m1.columns);
        for(int i=0;i<m1.rows;i++){
            for(int j=0;j<m1.columns;j++){
                m3.data[i][j] = (m1.data[i][j]+m2.data[i][j]);
            }
        }
        return m3;
    }

    public static Matrix multiply(Matrix m1, Matrix m2){
        if(m1.columns != m2.rows){
            System.out.println("Cannot multiply this matrices!\n");
            return null;
        }
        Matrix m3 = new Matrix(m1.rows, m2.columns);
        double a = 0;
        for(int i=0;i<m1.rows;i++){
            for(int j=0;j<m2.columns;j++){
                m3.data[i][j] = 0;
                for(int k=0;k<m2.rows;k++){
                    System.out.printf("%.1f * %.1f",m1.data[i][k],m2.data[k][j]);

                    m3.data[i][j]+=((m1.data[i][k])*(m2.data[k][j]));
                }
                System.out.println(" = " + m3.data[i][j]);
            }
        }

        return m3;
    }

    public static Matrix transpose(Matrix m1){
        Matrix m3 = new Matrix(m1.columns, m1.rows);

        for(int i=0;i<m3.rows;i++){
            for(int j=0;j<m3.columns;j++){
                m3.data[i][j] = m1.data[j][i];
            }
        }

        return m3;
    }
}

