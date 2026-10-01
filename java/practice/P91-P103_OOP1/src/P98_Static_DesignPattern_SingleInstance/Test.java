package P98_Static_DesignPattern_SingleInstance;

public class Test {
    public static void main(String[] args) {
        //When the single object is used frequently, use Eager
        EagerSingleInstance s1 = EagerSingleInstance.getObject();
        EagerSingleInstance s2 = EagerSingleInstance.getObject();
        System.out.println(s1);
        System.out.println(s2);
        //we obtain 2 same addresses
        //no matter how much objects we create outside the class, we are operating on the same object inside the single-instance class

        System.out.println("-----");

        //When the single object is not used frequently, use Lazy
        LazySingleInstance l1 = LazySingleInstance.getObject();
        LazySingleInstance l2 = LazySingleInstance.getObject();
        System.out.println(l1);
        System.out.println(l2);
        //we obtain 2 same addresses
        // no matter how much objects we create outside the class, we are operating on the same object inside the single-instance class
    }
}
