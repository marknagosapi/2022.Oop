package lab10_3;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        try {
            FileUtil.encode("labor-11/src/lab10_3/FileUtil.java", "temp1.java");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        try {
            FileUtil.decode("temp1.java", "temp2.java");
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
