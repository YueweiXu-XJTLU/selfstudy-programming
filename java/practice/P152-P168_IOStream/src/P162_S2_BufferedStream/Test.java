package P162_S2_BufferedStream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class Test {
    public static void main(String[] args) {
        try (   //BufferedReader (extends Reader): 字符缓冲输入/出流
                Reader fr = new FileReader("P152-P168\\src\\P162_S2_BufferedStream\\Test.txt");
                Reader br = new BufferedReader(fr)
        ) {

            char[] buffer = new char[5];
            int len;
            while ((len = br.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
