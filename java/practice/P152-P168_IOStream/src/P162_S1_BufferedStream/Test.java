package P162_S1_BufferedStream;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        try ( //use BufferedInputStream (extends FileInputStream) (缓冲字节输入/出流) to package the original stream for enhancing read-write efficiency
              InputStream is = new FileInputStream("YOUR_INPUT_IMAGE");
              InputStream bis = new BufferedInputStream(is); //create a bufferPool of 8KB (1 * 1024 bytes) by default in ARM

              OutputStream os = new FileOutputStream("P152-P168\\src\\P162_S1_BufferedStream\\picture.png");
              OutputStream bos = new BufferedOutputStream(os, 8192 * 2); //manually set the bufferPool's size
        ) {
            byte[] buffer = bis.readAllBytes();
            bos.write(buffer);
            System.out.println("Success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
