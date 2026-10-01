package P157_S1_FileInputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        //FileInputStream (Extend from abstract class "InputStream"): Input Bytes

        //step1: build a tube towards the wanted file
        InputStream tube = new FileInputStream("P152/src/P157_S1_FileInputStream/Test1.txt");
        //throw Exception here

        //step2: read data from the tube
        //A BYTE a time, if no bytes to read, return -1
        int firstByte = tube.read();
        System.out.println(firstByte);

        char secondByte = (char)(tube.read());
        System.out.println(secondByte);

        int thirdByte = tube.read();
        System.out.println(thirdByte); //return "-1" if no bytes to read

        //!!!!!The stream must be closed after use!!!!! (Release system resources)
        tube.close();



        System.out.println("==========");



        //read the entire file use loop
        InputStream fis = new FileInputStream("P152/src/P157_S1_FileInputStream/Test.txt");

        int a;
        while ((a = fis.read()) != -1) {
            System.out.print((char) a);
        }

        //disadvantages of this method to read bytes from files:
        //1.poor performance of data reading
        //2.Chinese characters causes invalid output (UTF-8 use 2 bytes to represent a Chinese character by we can only read a single byte with this method)

        //!!!!!The stream must be closed after use!!!!! (Release system resources)
        fis.close();
    }
}
