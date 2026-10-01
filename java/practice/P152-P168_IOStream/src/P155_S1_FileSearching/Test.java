package P155_S1_FileSearching;

import java.io.File;

public class Test {
    public static void main(String[] args) throws Exception {
        //to search for "QQ.exe" in D:/, if found, output its absolute pathway
        fileSearching(new File("D:/"), "QQ.exe");
    }

    /**
     * search for a file in a given directory
     * @param directoryToSearch
     * @param fileName
     */
    public static void fileSearching(File directoryToSearch, String fileName) throws Exception {
        //step0: check and find invalid situations
        File[] f = directoryToSearch.listFiles();
        if (f == null || f.length == 0 || !(directoryToSearch.exists())) {
            return; //when check inside recursion, the method will return to exit automatically
        }

        //step1: iterate over a directory
        for (int i = 0; i < f.length; i++) {
            //step2: check if is a file or directory
            if (f[i].isFile()) {
                //step3: if it is a file, check if it is "QQ.exe"
                if (f[i].getName().equals(fileName)) {
                    System.out.println(f[i].getAbsolutePath());
                   //we can now run the file(.exe) directly
                   Runtime r = Runtime.getRuntime();
                   r.exec(f[i].getAbsolutePath());
                }
            } else {
                //step4: if it is a directory, call the method again (recursion)
                fileSearching(f[i], fileName);
            }
        }
    }

}
