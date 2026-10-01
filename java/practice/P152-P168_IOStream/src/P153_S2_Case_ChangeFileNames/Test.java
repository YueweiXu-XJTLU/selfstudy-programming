package P153_S2_Case_ChangeFileNames;

import java.io.File;

public class Test {
    public static void main(String[] args) {
        //inside D:/JavaStudy, we need to change the names of 5 .txt files: 11,12,13,14,15 <-> 1,2,3,4,5

        File f = new File("D:/JavaStudy");

        for (int i = 0; i < f.listFiles().length; i++) {
            System.out.println(f.listFiles()[i].getName());
        }


    }
}
