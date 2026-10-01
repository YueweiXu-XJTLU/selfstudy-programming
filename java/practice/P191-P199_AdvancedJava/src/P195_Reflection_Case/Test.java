package P195_Reflection_Case;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws Exception {
        //Usage of reflection:
        //1.get components of a class and manipulate
        //2.damage encapsulation
        //3.build up framework

        //Case_A_simple_framework:
        //For any object, the framework can save the field names and their corresponding values into a file.
        Student s = new Student("San.Zhang", 19, "M");
        ObjectFramework.saveObject(s);

        Teacher t = new Teacher("Si.Li", 30);
        ObjectFramework.saveObject(t);
    }
}
