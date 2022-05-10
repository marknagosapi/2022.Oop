package lab10_3;

import java.io.*;

public interface FileUtil {
     public static void encode(String inputFileName, String outputFileName)
            throws IOException {
         try (InputStream in = new FileInputStream(inputFileName)) {
             try (OutputStream out = new FileOutputStream("outputFiles/"+outputFileName)) {
                 int ch;
                 while ((ch = in.read()) != -1) {
                     out.write((ch + 1) % 256);
                 }
             }
         }
     }
     public static void decode(String inputFileName, String outputFileName)  throws IOException {
         try (InputStream in = new FileInputStream("outputFiles/"+inputFileName)) {
             try (OutputStream out = new FileOutputStream("outputFiles/"+outputFileName)) {
                 int ch;
                 while ((ch = in.read()) != -1) {
                     if(ch == 0){
                         out.write(ch + 256);
                     }else{
                         out.write((ch - 1) % 256);
                     }

                 }
             }
         }
     } 
}



