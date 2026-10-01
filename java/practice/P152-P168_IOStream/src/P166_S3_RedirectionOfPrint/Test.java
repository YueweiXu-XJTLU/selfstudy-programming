package P166_S3_RedirectionOfPrint;

import java.io.PrintStream;

public class Test {
    public static void main(String[] args) {
        //Redirection the print: 打印内容的重定向
        //System.out.println(): the "out" is a PrintStream object which direct to the console (NOT PrintWriter)
        //We can use System.setOut() to redirect the print contain to a PrintStream created by ourselves
        try (
                PrintStream ps = new PrintStream("P152-P168\\src\\P165_S3_RedirectionOfPrint\\Test.txt")
        ){
            System.setOut(ps);

            System.out.println("ABC");
            System.out.println("DEFGH");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}