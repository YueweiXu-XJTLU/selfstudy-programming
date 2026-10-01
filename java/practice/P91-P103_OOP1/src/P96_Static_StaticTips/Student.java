package P96_Static_StaticTips;

public class Student {
    private static String name; //class variable
    private int age; //instance variable
    private static void aClassMethod() {} //class method
    private void anInstanceMethod() {} //instance method

    //Tip1:
    private static void testClassMethod() {
        //class method can call class variable/method
        name = "San.Zhang";
        aClassMethod();

        //class method can not call instance variable/method
        //age = 10; //error occurs
        //anInstanceMethod(); //error occurs
    }

    //Tip2:
    private void testInstanceMethod() {
        //instance method can call class variable/method
        name = "San.Zhang";
        aClassMethod();

        //instance method can call instance variable/method
        this.age = 10; //error occurs
        this.anInstanceMethod(); //error occurs
    }

    //Tip3:
    //"this." can be used in instance methods
    //"this." can not be used in class methods
    //because "this." run by calling current OBJECT

}
