package P192_Reflection_LoadClass;


public class Test {
    public static void main(String[] args) throws Exception {
        //Reflection: load classes and parse contents inside

        //load a class

        //1. constructor of Class: Class c = className.class
        Class c1 = Student.class;

        //2. method of Class: public static Class forName(String package)
        Class c2 = Class.forName("P192_Reflection_LoadClass.Student"); //use Full Name

        //3. method of CERTAIN Object: public Class getClass()
        Student s = new Student();
        Class c3 = s.getClass();

        System.out.println(c1 == c2 && c2 == c3); //these 3 methods will return SAME Class (same address)

        System.out.println(c1.getName()); //Full Name (全类名): package name + class name
        System.out.println(c1.getSimpleName()); //Simple Name (简名)： class name only
    }
}
