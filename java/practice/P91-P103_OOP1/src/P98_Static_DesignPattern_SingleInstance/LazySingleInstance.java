package P98_Static_DesignPattern_SingleInstance;

public class LazySingleInstance {

    //Lazy Single Instance (懒汉式单例)：Create the object when call the method
    //Step2: define a class variable
    private static LazySingleInstance lazySingleInstanceObject;

    //Step1: private the constructor
    private LazySingleInstance() {};

    //Step3: define a class method to create an object then return the single object
    public static LazySingleInstance getObject() {
        if (lazySingleInstanceObject == null) {
            System.out.println("Create the object!");
            lazySingleInstanceObject = new LazySingleInstance();
        }
        return lazySingleInstanceObject;
    }
}
