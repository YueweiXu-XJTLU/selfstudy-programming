package P161_S2_FileWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class Test {
    public static void main(String[] args) {
        //FileWriter (extends Writer): 字符输出流
        try (
                Writer fw = new FileWriter("P152\\src\\P161_S2_FileWriter\\Test.txt", true);
        ) {

            fw.write(97);
            fw.write('b');

            fw.write("cd你我他");
            fw.write("\r\n");

            fw.write("0123456789", 6, 1);
            fw.write("\r\n");

            fw.write(new char[]{'V', '我', '5', '0', '不', '用', '谢'}, 0, 4);

            //!!!FileWriter must .flush() or .close() to writer the contains into files!!!
            //after .flush(), can still operate on the stream
            //after .close(), the stream is automatically .flush(), but closed, hence can not operate anymore
            fw.flush();

            fw.write("\r\n123");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
