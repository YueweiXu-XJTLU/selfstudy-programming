package P196_Annotation;

//Annotation 注解
//Function: Let other programs determine how to execute the program according to annotation
//In essence: annotations are interfaces implement Annotation

//Custom Annotation 自定义注解
@MyAnnotation1_CustomAnnotation(aString = "a String", anIntArray = {0, 1, 2, 3})
public class Test {

    @MyAnnotation2_SpecialAttribute("special attribute")
    public static void testMyAnnotation() {

    }

}
