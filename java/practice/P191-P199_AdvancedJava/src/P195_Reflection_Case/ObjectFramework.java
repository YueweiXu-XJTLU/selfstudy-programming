package P195_Reflection_Case;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Field;

public class ObjectFramework {
    public static void saveObject(Object obj) throws Exception {
        PrintStream ps = new PrintStream(new FileOutputStream("YOUR_OUTPUT_FILE", true));
        Class c = obj.getClass();
        String name;
        String value;

        String simpleName = c.getSimpleName();
        ps.println(simpleName);

        for (Field declaredField : c.getDeclaredFields()) {
            declaredField.setAccessible(true);
            name = declaredField.getName();
            value = declaredField.get(obj) + ""; //A stronger way to cast into String
            ps.println(name + " : " + value);
        }
        ps.println("----------");

        ps.close();
    }
}
