package P98_Static_DesignPattern_SingleInstance;

public class EagerSingleInstance {
    //Single Instance 单例设计模式
    //Function: Create a class which contain only a SINGLE OBJECT

    //Eager Single Instance (饿汉式单例)：Create the object when call the class
    //Step2: define a class variable to store the single object
    private static EagerSingleInstance singleInstanceObject = new EagerSingleInstance(); //class variable only load ONCE with the class

    //Step1: private the constructor
    private EagerSingleInstance() {

    }

    //Step3: define a class method to return the single object
    public static EagerSingleInstance getObject() {
        return singleInstanceObject;
    };
}
