package P197_S2_Case_Annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    //use main method to simulate the RUN button
    public static void main(String[] args) throws Exception {
        Test t = new Test();
        Class<Test> c = Test.class;
        Method[] declaredMethods = c.getDeclaredMethods();

        for (Method m : declaredMethods) {
            if (m.isAnnotationPresent(MyTest.class)) {
                m.invoke(t);
            }
        }
    }

    @MyTest
    public void test1() {
        System.out.println("test1 is executed!");
    }

//    @MyTest
    public void test2() {
        System.out.println("test2 is executed!");
    }

    @MyTest
    public void test3() {
        System.out.println("test3 is executed!");
    }

//    @MyTest
    public void test4() {
        System.out.println("test4 is executed!");
    }
}
