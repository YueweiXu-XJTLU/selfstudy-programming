package P119_S2_Runtime;

import java.io.IOException;

public class Test {
    public static void main(String[] args) throws InterruptedException, IOException {
        //Runtime: SingleInstance

        //1.get the sing object
        Runtime rt = Runtime.getRuntime();

        //2.close the JVW
        //rt.exit(0);

        //3.get available processors_number
        System.out.println(rt.availableProcessors());

        //4.get total memory (in byte) (1024B(bytes) = 1KB = 1/1024MB)
        System.out.println((rt.totalMemory() / 1024.0 / 1024.0) + "MB");

        //5.get free memory (in byte) (1024B(bytes) = 1KB = 1/1024MB)
        System.out.println((rt.freeMemory() / 1024.0 / 1024.0) + "MB");

        //6.start a program
        Process p = rt.exec("YOUR_PROGRAM_PATH"); //Start a program (Full path if the program is not inside the Environment Variables// )
        Thread.sleep(5000); //pause & waiting for 5s
        p.destroy(); //destroy thy object (the program)
    }
}
