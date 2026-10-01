package P110_S2_MultipleInheritance;

public class Test {
    public static void main(String[] args) {
        A e = new E();
        e.printA();
        e.printB();
        e.printC();
        e.printD();

        System.out.println("==========");

        Super s = new Sub();
        s.run();

        System.out.println("==========");

        H h = new H();
        h.run();
    }
}

//multiple inheritance (多继承) of interface: an interface can inherit from multiple interfaces
interface A extends B, C, D {
    void printA();
}

interface B {
    void printB();
}
interface C {
    void printC();
}
interface D {
    void printD();
}

//hence to integrate the multiple implements to be implemented by the implement class
class E implements A {

    @Override
    public void printA() {
        System.out.println("printA");
    }

    @Override
    public void printB() {
        System.out.println("printB");
    }

    @Override
    public void printC() {
        System.out.println("printC");
    }

    @Override
    public void printD() {
        System.out.println("printD");
    }
}



//Tips
//1.A class/A interface cannot implement/inherit from multiple interfaces if the  SIGNATURE of the methods in the origin interfaces are the same while returnValues differ
//signature: "methodName(parameters)"
interface F {
    void print();

}

interface G {
    String print();
}

//class H implements F, G {}
//interface H extends F, G {}

//2.A class both extends a superClass and implement an interface (with default method): must first "extend" and then "implement": it will prioritize to use method from superClass which is nearer
class Super {
    public void run() {
        System.out.println("run method inside Super");
    }
}

interface InterFace {
    default void run() {
        System.out.println("run method inside interface");
    }
}

class Sub extends Super implements InterFace {
}

//3. A implement class implement multiple interfaces with SAME default methods: must override the default methods in the implement class itself
interface InterFace1 {
    default void run() {
        System.out.println("run method inside InterFace1");
    }
}

interface InterFace2 {
    default void run() {
        System.out.println("run method inside InterFace2");
    }
}

class H implements InterFace1, InterFace2 {
    @Override
    public void run() {
//        InterFace1.super.run();
        System.out.println("run method inside implement class");
    }
}