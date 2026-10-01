package P101_Inheritance_S2_MethodsOverriding;

public class Test {
    public static void main(String[] args) {
        //Method Override 方法重写
        Sub1 s1 = new Sub1();
        s1.print1();
        s1.print2(1);

        Sub2 s2 = new Sub2();
        s2.print1();
        s2.print2(1);
        //After override, java will call the LATEST method found (in the latest subClass that override it)
    }
}
