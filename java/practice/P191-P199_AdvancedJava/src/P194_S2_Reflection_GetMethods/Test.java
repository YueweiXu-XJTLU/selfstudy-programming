package P194_S2_Reflection_GetMethods;

import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws Exception {
        Class c = Student.class;

        //Get Methods
        //1.public Method[] getMethods() //all PUBLIC (include extends ones)
        Method[] methods1 = c.getMethods();
        for (Method method : methods1) {
            System.out.println("This is a public method called " + method.getName() + " with " + method.getParameterCount() + " parameters and return type: " + method.getReturnType());
        }
        System.out.println("----------");


        //2.public Method[] getDeclaredMethods() //ALL (exclude extends ones)
        Method[] methods2 = c.getDeclaredMethods();
        for (Method method : methods2) {
            System.out.println("This is a method called " + method.getName() + " with " + method.getParameterCount() + " parameters and return type: " + method.getReturnType());
        }
        System.out.println("----------");

        //3.public Method getMethod(String name, Class<?>... parameterTypes) //ONE public (include extends ones)
        Method method1 = c.getMethod("eat");
        System.out.println("This is a method called " + method1.getName() + " with " + method1.getParameterCount() + " parameters and return type: " + method1.getReturnType());
        System.out.println("----------");


        //4.public Method getDeclaredMethod(String name, Class<?>... parameterTypes) //ANY (exclude extends ones)
        Method method2 = c.getDeclaredMethod("eat", String.class);
        System.out.println("This is a method called " + method2.getName() + " with " + method2.getParameterCount() + " parameters and return type: " + method2.getReturnType());
        System.out.println("----------");



        //Usage of getField: execute methods
        Student s = new Student();

        //public void setAccessible(boolean flag)
        method2.setAccessible(true);

        //public Object invoke(Object obj, Object... args)
        Object object = method2.invoke(s, "beef");
        System.out.println(object);
        //if the method return sth., then return an Object
        //if the method is void, return null
    }
}
