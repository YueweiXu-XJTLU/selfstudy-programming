package P159_S1_FileOutputStream;

import java.io.FileOutputStream;
import java.io.OutputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        //FileOutputStream 输出字节流
        //create a tube to link to (create) a file we want to output
        OutputStream tube = new FileOutputStream("P152\\src\\P159_S1_FileOutputStream\\Test1.txt", true); //true: continue to write; false (by default): over-write (覆写)

        //write methods
        //1.receive a byte
        tube.write(97);
        tube.write('b');
//        tube.write('我'); //as Chinese characters in UTF-8 have 3 bytes,error

        //2.receive a byte array
        //"/r/n": the most commonly used line separator (换行符) in Operating Systems
        byte[] arr1 = "\r\n".getBytes(); //use "getBytes()" to convert String to byte array
        byte[] arr2 = "V我50".getBytes();
        tube.write(arr1);
        tube.write(arr2);
        tube.write(arr1);

        //3.receive a byte array, and point out the start point with the write bytes numbers
        tube.write(arr2, 1, 3); //write from INDEX 1, length is 3 //*In UTF-8, a Chinese character has 3 bytes

        tube.close();
    }
}