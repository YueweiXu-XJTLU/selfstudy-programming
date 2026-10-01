package P102_Inheritance_AccessThroughSubClass;

public class Test {
    public static void main(String[] args) {
        //Principle of access through SubClass: Principle of proximity (就近原则)
        SubClass sub1 = new SubClass();
        sub1.accessVariablesInSubClass();
        sub1.accessMethodsInSubClass();
    }
}
