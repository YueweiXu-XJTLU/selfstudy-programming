package P100_Inheritance_AccessModifier;

import P100_Inheritance_AccessModifier_Super.Super;

public class Sub extends Super {
    protected void methodInSub() {
        System.out.println("methodInSub");
        System.out.println("Direct access protected method in Super in different packages:");
        super.methodInSuper();
    }

    @Override
    protected void methodInSuper() {
        super.methodInSuper();
    }
}
