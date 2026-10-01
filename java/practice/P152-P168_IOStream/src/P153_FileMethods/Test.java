package P153_FileMethods;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws Exception {
        File file = new File("example/Test.java");
        File directory = new File("P152/src/P152_File");

        //File methods:
        //1.exists()
        System.out.println(file.exists()); //true
        System.out.println(directory.exists()); //true

        System.out.println("=====");

        //2.isFile() & isDirectory()
        System.out.println(file.isFile()); //true
        System.out.println(directory.isDirectory()); //true

        System.out.println("=====");

        //3.getName

        //4.length

        //5.lastModified
        long time = file.lastModified();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(time));

        System.out.println("=====");

        //6.getPath & getAbsolutePath
        //output the path of CREATION the File OBJECT
        System.out.println(file.getPath()); //example/Test.java
        System.out.println(directory.getPath()); //P152/src/P152_File

        //output the absolute path of the file
        System.out.println(file.getAbsolutePath()); //runtime absolute path
        System.out.println(directory.getAbsolutePath()); //runtime absolute path

        System.out.println("==========");

        //7.createNewFile()
        File newFile = new File("P152/src/P152_FileMethods/newFile.txt");
        System.out.println(newFile.createNewFile()); //return true if successful //throw an Exception here to prevent non-existing path
        System.out.println(newFile.createNewFile()); //return false if the file already exists

        System.out.println("=====");

        //8.mkdir() & mkdirs()
        //mkdir() only create single_ordered_directory
        //mkdirs() can create multiple_ordered_directories
        File dir1 = new File("example/aaa");
        System.out.println(dir1.mkdir()); //ok
        System.out.println(dir1.mkdirs()); //ok

        File dirs = new File("example/bbb/ccc/ddd");
        System.out.println(dirs.mkdir()); //not ok
        System.out.println(dirs.mkdirs()); //ok

        System.out.println("=====");

        //9.delete()
        //only delete EMPTY files/directories
        System.out.println(newFile.delete()); //true
        System.out.println(dir1.delete()); //true
        System.out.println(new File("example/bbb").delete()); //false

        System.out.println("=====");

        //10.iterate over directories
        //list(): return an array of String with files in the 1st_ordered_directory (including hidden files)
        File f1 = new File("P152/src");
        String[] name = f1.list();
        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
        }
        System.out.println("=====");
        //listFiles(): return an array of File objects in the 1st_ordered_directory (including hidden files)
        File f2 = new File("P152/src");
        for (int i = 0; i < f2.listFiles().length; i++) {
            System.out.println(Arrays.toString(f2.listFiles()));
        }
        System.out.println("=====");
        //tips for 10:
        //return empty array if: the directory if empty
        File f3 = new File("D:/E");
        for (int i = 0; i < f3.listFiles().length; i++) {
            System.out.println(f3.listFiles()[i]);
        }
        System.out.println("=====");
        //return null if: 1.your path is to a FILE; 2.the path does not exist; 3.you do not have permission to access the directory
        File f4 = new File("P152/src/P152_FileMethods/Test.java");
        System.out.println(f4.listFiles());
        File f5 = new File("P152/src/P152_FileMethods/asdasdadasdadqaa");
        System.out.println(f5.listFiles());
    }
}
