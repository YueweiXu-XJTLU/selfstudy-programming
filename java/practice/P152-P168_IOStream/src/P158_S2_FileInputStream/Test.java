package P158_S2_FileInputStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        //read a byte[] of bytes at a time
        InputStream is = new FileInputStream("P152\\src\\P158_S2_FileInputStream\\Test.txt");

        byte[] buffer = new byte[25]; //create a byte[] and decide how many bytes to read at a time

        int len; //to remember how many bytes are read at a time

        //use loop to improve
        while ((len = is.read(buffer)) != -1) {
            System.out.print(new String(buffer, 0, len));
        }

        //but also can't avoid Chinese characters' unreadable codes

        is.close();

    }
}
