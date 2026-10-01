package P166_S2_PrintWriter;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.nio.charset.Charset;

public class Test {
    public static void main(String[] args) {
        //PrintWriter (字符打印流) (extends Writer): more convenient and more efficiency (contain BufferedStream)
        try (
                PrintWriter ps = new PrintWriter("P152-P168\\src\\P165_S2_PrintWriter\\Test.txt", Charset.forName("UTF-8"));

                //High-level Streams can not directly use true for append: use High-level Streams to pack Low-level Stream
                PrintWriter ps2 = new PrintWriter(new FileWriter("P152-P168\\src\\P165_S2_PrintWriter\\Test.txt", true));
                ){
            ps.print(97); //.print(): write the exact thing inside the () (97 --> 97, not to 'a')
            ps.println('a'); //.println(): automatically change to a new  line
            ps.println(99.0);
            ps.println("=====");

            ps.write('我'); //PrintStream can also call ".write()" method, same as the FileWriter
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
