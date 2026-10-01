package P111_InnerClass1;

public class Outer {
    private String a = "variable in Outer Class";
    //Inner Class 内部类: 4 types

    //1.Member Inner Class
    public class MemberInnerClass {
        {
            System.out.println("Member Inner Class");
        }

        private String a = "variable in Inner Class";

        public void print() {
            String a = "variable in Method";
            //outer class's private variable/method is available in inner class
            System.out.println(a); //"variable in Method"
            System.out.println(this.a); //"variable in Inner Class"
            System.out.println(Outer.this.a); //"variable in Outer Class"
        }
    }

    //2.Static Inner Class
    public static class StaticInnerClass {
        {
            System.out.println("Static Inner Class");
        }

        private static String a = "static variable in Inner Class";

        public static void print() {
            String a = "variable in Method";
            //only STATIC variable/method is available
            System.out.println(a); //"static variable in Inner Class"
            //"a" here directly point to the static variable and "a" cannot be used to create a method variable anymore
        }
    }

    //3.Local Inner Class: useless
}
