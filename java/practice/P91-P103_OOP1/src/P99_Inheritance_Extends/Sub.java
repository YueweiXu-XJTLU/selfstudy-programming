package P99_Inheritance_Extends;

public class Sub extends Super {
//Sub: SubClass; Super: SuperClass
//Sub is inherited from Super, can directly use PUBLIC member variables/methods in Super
    public static void subTest() {
        Sub.a = 10;
        System.out.println(a);
        Super.a = 20;
        System.out.println(a);
        b();

        //System.out.println(c); //error occurs
        //d(); //error occurs
    }
}
