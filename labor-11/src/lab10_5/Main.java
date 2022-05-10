package lab10_5;

public class Main {
    public static void main(String[] args) throws MatrixException {
        double[][] d = { { 1, 2, 3 }, { 4, 5, 6 }};
        Matrix m0 = new Matrix(d);
        System.out.println("m0 rows: " + m0.getRows()+", cols:  " + m0.getColumns());
        System.out.println("m0: ");
        m0.printMatrix();
        System.out.println();
        Matrix m00 = new Matrix( m0 );
        System.out.println("m00 is a copy of m0: ");
        m00.printMatrix();
        System.out.println("************************");
        Matrix m1 = new Matrix(2, 3);
        m1.fillRandom(1,2);
        System.out.println("m1: ");
        m1.printMatrix();
        Matrix m3 = Matrix.add(m0,m1);

        System.out.println("m3 matrix:");
        m3.printMatrix();

        Matrix m4 = Matrix.multiply(m0,m1);

    }
}
