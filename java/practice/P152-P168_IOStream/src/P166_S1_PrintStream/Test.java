package P166_S1_PrintStream;

import java.io.PrintStream;
import java.nio.charset.Charset;

public class Test {
    public static void main(String[] args) {
        //PrintStream (字节打印流) (extends FileOutPutStream): more convenient and more efficiency (contain BufferedStream)
        try (
                PrintStream ps = new PrintStream("P152-P168\\src\\P165_S1_PrintStream\\Test.txt", Charset.forName("UTF-8"));
                ){
            ps.print(97); //.print(): write the exact thing inside the () (97 --> 97, not to 'a')
            ps.println('a'); //.println(): automatically change to a new  line
            ps.println(99.0);
            ps.println("=====");

            ps.write(97); //PrintStream can also call ".write()" method, same as the FileOutputStream
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
