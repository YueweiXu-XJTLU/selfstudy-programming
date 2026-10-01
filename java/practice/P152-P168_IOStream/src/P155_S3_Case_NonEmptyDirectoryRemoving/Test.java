package P155_S3_Case_NonEmptyDirectoryRemoving;

import java.io.File;

public class Test {
    public static void main(String[] args) throws Exception {
        //to remove non-empty directory by using recursion
        directoryRemove(new File("D:/"), "KuaiLaiShanWoBa");
    }

    private static void directoryRemove(File dirToSearch, String dirToRemove) throws Exception {
        //step0: check and find invalid situations
        if (!(dirToSearch.exists())) {
            return; //when check inside recursion, the method will return to exit automatically
        }

        File[] f = dirToSearch.listFiles();

        if (f == null) {
            return; //when check inside recursion, the method will return to exit automatically
        }

        //step1: iterate over a directory
        for (int i = 0; i < f.length; i++) {

            //step2: check if is a file or directory
            if (f[i].isDirectory()) {

                //step3: check if it is the directory we want
                if (f[i].getName().equals(dirToRemove)) {

                    //step4: remove it by recursion
                    removeNonEmptyDirectory(f[i]);
                }
            }
        }
    }

    private static void removeNonEmptyDirectory(File directory) {
        //step1: check and throw Exceptions
        File[] dir = directory.listFiles();
        if (dir == null) {
            System.out.println("Invalid!");
            return;
        }

        //step2: directly remove empty directory
        if (dir.length == 0) {
            directory.delete();
        }

        //step3: iterate over a directory to remove all files
        for (int i = 0; i < dir.length; i++) {
            //step4: check if is a file or directory
            if (dir[i].isFile()) {
                //step5: remove it
                dir[i].delete();
            } else {
                //step6: remove it by recursion
                removeNonEmptyDirectory(dir[i]);
            }
        }

        //step4: remove itself finally
        directory.delete();
    }
}