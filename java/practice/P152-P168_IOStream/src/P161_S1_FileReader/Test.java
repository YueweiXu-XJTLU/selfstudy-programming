package P161_S1_FileReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

public class Test {
    public static void main(String[] args) {
        //FileReader & FileWriter are especially suitable for file operation (read or write)

        //FileReader (extends Reader): 输入字符流

        try (
                Reader fr = new FileReader("P152\\src\\P161_S1_FileReader\\Test.txt");

        ) {
//            int c;
//            while ((c = fr.read()) != -1) {
//                System.out.print((char)c); //System.out.print(c) --> print code numbers instead of char
//            }

            char[] buffer = new char[5];
            int len;
            while ((len = fr.read(buffer)) != -1) {
                System.out.print(new String(buffer, 0, len));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
