package P159_S2_FileCopy;

import java.io.*;

public class Test2 {
    public static void main(String[] args) {
        try ( //Use try-with-resource to release resources: try () {source 1, source 2, ...} catch {}
              //sources inside () will automatically be called for .close() after using
              //How to ensure if a variable is a resource: all sources implement "AutoCloseable" interface which finally call .close()
                //FileCopy: Better to use FileInoutStream & FileOutputStream (字节流): ALL FORMATS of files are stored base on byte

                //1.create FileInputStream for the origin file
                InputStream is = new FileInputStream("YOUR_INPUT_IMAGE");

                //2.create FileOutputStream for the destination file and its path
                OutputStream os = new FileOutputStream("P152\\src\\P159_S2_FileCopy\\picture.png");
        ) {
            //3.read the origin file and write to the destination file
            byte[] buffer = is.readAllBytes();
            os.write(buffer);
            System.out.println("Success!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
