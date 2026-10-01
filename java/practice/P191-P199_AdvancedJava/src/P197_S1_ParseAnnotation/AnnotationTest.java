package P197_S1_ParseAnnotation;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

public class AnnotationTest {
    //Parse of Annotations
    //use an OBJECT (implements AnnotatedElement) to parse the annotations in itself

    @Test
    public void parseClass(){
        Class<Demo> c = Demo.class;

        //1.public Annotation[] getDeclaredAnnotations(): get all annotations above this Object
        Annotation[] declaredAnnotations = c.getDeclaredAnnotations();

        //2.public T getDeclaredAnnotation(Class<T> annotationClass): get a certain Annotation Object above this Object
        //3.public boolean isAnnotationPresent(class<Annotation> annotationClass): judging id f a certain exists above this Object
        if (c.isAnnotationPresent(MyTest.class)) {
            MyTest myTest = (MyTest) c.getDeclaredAnnotation(MyTest.class);
            System.out.println(myTest.value());
            System.out.println(myTest.aaa());
            System.out.println(Arrays.toString(myTest.bbb()));
        }
    }

    @Test
    public void parseMethod() throws Exception {
        Class<Demo> c = Demo.class;
        Method m = c.getDeclaredMethod("test1");

        Annotation[] declaredAnnotations = c.getDeclaredAnnotations();

        if (m.isAnnotationPresent(MyTest.class)) {
            MyTest myTest = (MyTest) m.getDeclaredAnnotation(MyTest.class);
            System.out.println(myTest.value());
            System.out.println(myTest.aaa());
            System.out.println(Arrays.toString(myTest.bbb()));
        }
    }
}
