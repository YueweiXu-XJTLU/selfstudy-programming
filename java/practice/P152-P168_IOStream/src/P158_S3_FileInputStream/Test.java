package P158_S3_FileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        //read a byte[] of bytes at a time
        InputStream is = new FileInputStream("P152\\src\\P158_S3_FileInputStream\\Test.txt");

        //read ALL bytes to avoid unreadable codes of Chinese characters

        //method 1: crate a byte[] has the size same as the file size
        File f = new File("P152\\src\\P158_S3_FileInputStream\\Test.txt");
        long size = f.length(); //use "long" as the file may be extremely large

        byte[] buffer = new byte[(int)size];

        int len = is.read(buffer);

        System.out.println(new String(buffer, 0, len));
        System.out.println("read byte number: " + len);

        System.out.println("==========");

        //method2: readAllByte()
        InputStream is2 = new FileInputStream("P152\\src\\P158_S3_FileInputStream\\Test2.txt");
        byte[] buffer2 = is2.readAllBytes();
        System.out.println(new String(buffer2));
        System.out.println("read byte number: " + buffer2.length);
    }
}
