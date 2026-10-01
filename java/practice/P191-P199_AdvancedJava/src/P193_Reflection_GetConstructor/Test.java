package P193_Reflection_GetConstructor;

import java.lang.reflect.Constructor;

public class Test {
    public static void main(String[] args) throws Exception {
        Class c = Student.class;

        //Get Constructors
        //1. Constructor<?>[] getConstructors() //Get all PUBLIC constructors
        Constructor[] constructors1 = c.getConstructors();
        for (Constructor constructor : constructors1) {
            System.out.println("This is a public constructor for class \"" + constructor.getName() + "\" with " + constructor.getParameterCount() + " parameters!");
        }
        System.out.println("----------");

        //2. Constructor<?>[] getDeclaredConstructors() //get ALL constructors
        Constructor[] constructors2 = c.getDeclaredConstructors();
        for (Constructor constructor : constructors2) {
            System.out.println("This is a constructor for class \"" + constructor.getName() + "\" with " + constructor.getParameterCount() + " parameters!");
        }
        System.out.println("----------");

        //3. Constructor<T> getConstructor(Class<?>... parameterTypes) //get a certain PUBLIC constructor
        Constructor constructWithParameters = c.getConstructor(int.class, String.class);
        System.out.println("This is a public constructor for class \"" + constructWithParameters.getName() + "\" with " + constructWithParameters.getParameterCount() + " parameters!");
        System.out.println("----------");

        //4. <T> getDeclaredConstructor(Class<?>... parameterTypes) //get ANY certain constructor //!!!parameterTypes must be class objects (.class)!!!
        Constructor constructorWithoutParameters = c.getDeclaredConstructor();
        System.out.println("This is a private constructor for class \"" + constructorWithoutParameters.getName() + "\" with " + constructorWithoutParameters.getParameterCount() + " parameters!");
        System.out.println("----------");



        //Usage of getConstructors: initialized objects and return
        //T newInstance(Object... initargs)
        Student s1 = (Student) constructWithParameters.newInstance(19, "Student1");
        System.out.println(s1);

        //public void setAccessible(boolean flag): call using a Constructor Object, get access for all constructors, even private ones (Brute-force Reflection 暴力反射)
        constructorWithoutParameters.setAccessible(true); //use "true" to grant access, use "false" to recover (lock) the access
        Student s2 = (Student) constructorWithoutParameters.newInstance();
        System.out.println(s2);
    }
}
