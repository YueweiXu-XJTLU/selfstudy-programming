package P106_AbstractClass;

public class B extends A {
    //if B extends A, B must override ALL abstract methods of A,
    //otherwise, B is also an abstract class
    @Override
    public void print() {
        System.out.println("print() in B");
    }
}
