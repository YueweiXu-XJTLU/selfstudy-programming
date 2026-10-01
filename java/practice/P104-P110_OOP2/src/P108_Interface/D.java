package P108_Interface;

public class D implements A, B, C {
    //interface are created to be "implements (实现)", these classes are called implementation classes (实现类)
    //a complementation class can implement many interfaces: must override all the methods in all the interfaces, otherwise, it should be declared as abstract class
    @Override
    public void printA() {
        System.out.println("printA");
    }

    @Override
    public void printB1() {
        System.out.println("printB1");
    }

    @Override
    public void printB2() {
        System.out.println("printB2");
    }

    @Override
    public void printC1() {
        System.out.println("printC1");
    }

    @Override
    public void printC2() {
        System.out.println("printC2");
    }
}
