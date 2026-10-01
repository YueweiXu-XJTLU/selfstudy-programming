package P194_S1_Reflection_GetFields;

import java.lang.reflect.Field;

public class Test {
    public static void main(String[] args) throws Exception {
        Class c = Student.class;

        //Get Fields
        //1.public Field[] getFields() //all PUBLIC
        Field[] fields1 = c.getFields();
        for (Field field : fields1) {
            System.out.println(field.getType() + "--->" + field.getName());
        }
        System.out.println("----------");

        //2.public Field[] getDeclaredFields() //ALL
        Field[] fields2 = c.getDeclaredFields();
        for (Field field : fields2) {
            System.out.println(field.getType() + "--->" + field.getName());
        }
        System.out.println("----------");

        //3.public Field getField(String name) //ONE public
        Field field1 = c.getField("a");
        System.out.println(field1.getType() + "--->" + field1.getName());
        System.out.println("----------");

        //4.public Field getDeclaredField(String name) //ANY one
        Field field2 = c.getDeclaredField("name");
        System.out.println(field2.getType() + "--->" + field2.getName());
        System.out.println("----------");



        //Usage of getField: set and get values
        Student s = new Student();

        //public void setAccessible(boolean flag)
        field2.setAccessible(true);

        //void set(Object obj, Object value)
        field2.set(s, "San.Zhang");
        System.out.println(s);

        //Object get(Object obj)
        String name = (String) field2.get(s);
        System.out.println(name);
    }
}
