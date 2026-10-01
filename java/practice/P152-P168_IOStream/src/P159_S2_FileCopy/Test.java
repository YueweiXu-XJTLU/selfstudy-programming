package P159_S2_FileCopy;

import java.io.*;

public class Test {
    public static void main(String[] args) {
        InputStream is = null;
        OutputStream os = null;

        try {
            //FileCopy: Better to use FileInoutStream & FileOutputStream (字节流): ALL FORMATS of files are stored base on byte

            //1.create FileInputStream for the origin file
            is = new FileInputStream("YOUR_INPUT_IMAGE");

            //2.create FileOutputStream for the destination file and its path
            os = new FileOutputStream("P152\\src\\P159_S2_FileCopy\\picture.png");

            //3.read the origin file and write to the destination file
            byte[] buffer = is.readAllBytes();
            os.write(buffer);
            System.out.println("Success!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //Professional Resource Releasing:
            //Streams: appear earlier, close later
            try {
                //avoid them to be closed in try & avoid them not to be created:
                if (os != null) {os.close();}
                if (is != null) {is.close();}
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
