package P101_Inheritance_S2_MethodsOverriding;

public class Sub2 extends Super {
    //private methods & static methods are not allowed to be overridden
    @Override //use this Annotation(注解) which can automatically check the certain functional codes below
    public void print1() {
        //AccessModifier of override method >= that in SuperClass (public >= protected >= (null) >= private)
        //returnValue of override method <= that in SuperClass
        System.out.println("Overridden ()");
    }

    @Override
    public void print2(int a) {
        System.out.println("Overridden (int a)");
    }
}
