package P152_File;

import java.awt.*;
import java.io.File;

public class Test {
    public static void main(String[] args) {
        //3 types of available separator: "/" "\\" "File.separator (automatically find separator in the operating system)"
//        File f1 = new File("C:\\Users\\YOUR_USER\\Documents\\example.txt");
//        File f1 = new File("C:/Users/YOUR_USER/Documents/example.txt");
        File f1 = new File("C:" + File.separator + "Users" + File.separator + "YOUR_USER" + File.separator + "OneDrive" + File.separator + "Desktop" + File.separator + "eQTL.txt");
        System.out.println(f1.getName()); //fileName
        System.out.println(f1.length()); //fileSize (in byte)

        //File class can also be used for file_folders
        File f2 = new File("C:\\Users\\YOUR_USER\\Documents"); //locate a file-folder itself, not include the files inside
        System.out.println(f2.length());

        //File class can refer to non-exist paths
        File f3 = new File("C:\\Users\\YOUR_USER\\Documents\\missing.txt");
        System.out.println(f3.exists());
        System.out.println(f3.length());

        //relative pathway: automatically locate into the PROJECT folder (recommended)
        File f4 = new File("P152/src/P152_File/Test.java");
        System.out.println(f4.length());

    }
}
