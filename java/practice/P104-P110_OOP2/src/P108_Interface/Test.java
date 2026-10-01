package P108_Interface;

public class Test {
    public static void main(String[] args) {
        D d = new D();
        d.printA();
        d.printB1();

        //advantage of interface
        //1. multiple interface can be implemented in a single class (a people can be teacher, driver, ...)
        //multiple classes can be implemented in a single interface
        //explicitly show the feature of a class through interface

        //2. interface oriented programming: Interface objectName = new ClassImplementInterface1(); --> ClassImplementInterface1() can be altered into 2,3,4,... conveniently without change the codes below
        //(if interface mean driving licence, just change the drivers implement the interface, then we can find another qualified driver)
    }
}
