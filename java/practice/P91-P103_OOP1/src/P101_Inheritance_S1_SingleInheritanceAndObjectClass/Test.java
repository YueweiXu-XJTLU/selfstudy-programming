package P101_Inheritance_S1_SingleInheritanceAndObjectClass;

public class Test {
    public static void main(String[] args) {
        //Any class in java is directly or indirectly inherited from "Object" Class
        SuperClass1 super1 = new SubClass();
        super1.getClass(); //this is a method in object class, any object in java can access to them

        SubClass sub1 = new SubClass();
        sub1.getClass();
    }
}

//Single Inherit
class SuperClass1 {}
class SuperClass2 extends SuperClass1 {}
//class SubClass extends SuperClass1, SuperClass2 {} //error occurs as a SubClass can only inherit from ONE SuperClass
class SubClass extends SuperClass2 {} //but can use MULTILEVEL-inheritance (多层继承)
