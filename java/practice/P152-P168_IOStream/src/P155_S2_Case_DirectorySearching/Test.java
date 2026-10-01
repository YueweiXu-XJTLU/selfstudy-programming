package P155_S2_Case_DirectorySearching;

import java.io.File;

public class Test {
    public static void main(String[] args) throws Exception {
        //to search for "TwoSampleMR" in D:/, if found, output its absolute pathway
        directorySearching(new File("D:/"), "TwoSampleMR");
    }

    /**
     * search for a directory in a given directory
     * @param directoryToSearch
     * @param directoryName
     */
    public static void directorySearching(File directoryToSearch, String directoryName) throws Exception {
        //step0: check and find invalid situations
        File[] f = directoryToSearch.listFiles();
        if (f == null || f.length == 0 || !(directoryToSearch.exists())) {
            return; //when check inside recursion, the method will return to exit automatically
        }

        //step1: iterate over a directory
        for (int i = 0; i < f.length; i++) {
            //step2: check if is a file or directory
            if (f[i].isDirectory()) {
                //step3.1: if it is a directory

                //step4: check if it is the directory we want
                if (f[i].getName().equals(directoryName)) {
                    System.out.println(f[i].getAbsolutePath());
                }

                //step5: recursion
                directorySearching(f[i], directoryName);
            } else {
                //step3.2: if it is a file: recursion
                directorySearching(f[i], directoryName);
            }
        }
    }

}
