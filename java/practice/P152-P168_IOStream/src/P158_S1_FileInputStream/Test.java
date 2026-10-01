package P158_S1_FileInputStream;

import java.io.FileInputStream;
import java.io.InputStream;

public class Test {
    public static void main(String[] args) throws Exception {
        //read a byte[] of bytes at a time
        InputStream is = new FileInputStream("P152\\src\\P158_S1_FileInputStream\\Test.txt");

        //create a byte[] and decide how many bytes to read at a time
        byte[] buffer = new byte[25];
//        is.read(buffer); //this line will read 5 bytes and store them into buffer
        int len = is.read(buffer); //it returns the number of bytes read, we'd better receive it into an int WHILE reading
        System.out.println(new String(buffer)); //use the byte[] to create a String for printing
        System.out.println("current read byte number: " + len);

//        int len2 = is.read(buffer);
//        System.out.println(new String(buffer));
//        System.out.println("current read byte number: " + len2);
        //only read 20 byte, hence last 5 bytes are not over-written

        //!!!it's important to only read new byte:
        int len2 = is.read(buffer);
        System.out.println(new String(buffer, 0, len2)); //read from index of 0, and read len2 bytes
        System.out.println("current read byte number: " + len2);

        int len3 = is.read(buffer);
        System.out.println("current read byte number: " + len3); //return -1 if no bytes to read

        is.close();





    }
}
