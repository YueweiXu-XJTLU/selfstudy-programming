package P191_UnitTesting;

import com.sun.source.tree.BreakTree;

public class StringUtil {
    public static void printNumber(String name) {
        if (name == null) {
            return;
        }
        System.out.println("Length of the name: " + name.length());
    }

    public static int getMaxIndex(String data) {
        if (data == null) {
            return -1;
        }
        return data.length() - 1;
    }
}
