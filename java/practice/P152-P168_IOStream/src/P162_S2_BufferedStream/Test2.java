package P162_S2_BufferedStream;

import java.io.*;

public class Test2 {
    public static void main(String[] args) {
        try (
                BufferedReader br = new BufferedReader(new FileReader("P152-P168\\src\\P162_S2_BufferedStream\\Test2.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("P152-P168\\src\\P162_S2_BufferedStream\\Test3.txt"));
                ) {
            //new method: .readLine(): read by line, if no line to de read, return null
            String line = new String();
            while ((line = br.readLine()) != null) { //don't use .equals here,as when line == null, null can not call .equals(), errors occur
                System.out.println(line);
                bw.write(line);
                bw.newLine(); //new method
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
