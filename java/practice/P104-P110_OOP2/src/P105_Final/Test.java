package P105_Final;

public class Test {
    public static void main(String[] args) {
        //"final" can modify class/method/variable

        //constant
        System.out.println(D.SCHOOL_NAME);

        //final of reference data type: the address can not be modified, but the contains of object referred by the address can be modified
        final int[] arr = {1,2,3};
        //arr = null; //error occurs
        arr[0] = 666;
        System.out.println(arr[0]);
    }

    //1.final class ClassName {} : the class cannot be inherited (can not derive to subclass)
    final class A {}

//    class B extends A {} //error occurs



    //2.final public void MethodName() {} : the method cannot be overridden
    class B {
        final public void a() {}
        final public void a(int b) {} //but can still be overloaded
    }

    class C extends B {
//        @Override
//        public void a() {}
// error occurs
    }



    //3.final variableType variableName; : the variable must and can only be assigned once
    /*
    variable data type in java:
    1.local variable
    2.member variable
     (1).static member variable
     (2).instance member variable
     */
    class D {
        //static member variable (must assign value right after creation)
        //variable modified by "static final" is called "constant (常量)" (name with all-upper-cased-words, link using "_") (more readable, more resource-saving(when compiling, they are automatically convert in to primitive-variables instead of complex-typed-variables))
        public static final String SCHOOL_NAME = "XJTLU";

        //instance member variable (must assign value right after creation)
        public final int b = 2;

        //local variable (can assign value later)
        final int c = 3;
        public void d(final int e) {
        }
    }
    /*
    data type in java:
    1.primitive data type
    2.reference data type
    */
    class E {
        //final of primitive data type: the data can not be modified

        //final of reference data type: the address can not be modified, but the contains of object referred by the address can be modified
        //e.g. see in the main method above
    }
}
