package P111_InnerClass1;

public class Test {
    public static void main(String[] args) {
        //1.Member Inner Class object:
        Outer.MemberInnerClass mic = new Outer().new MemberInnerClass();
        mic.print();
        System.out.println("==========");


        //1.Static Inner Class & Static Inner Class object:
        Outer.StaticInnerClass sic = new Outer.StaticInnerClass();
        sic.print();
        System.out.println("----------");
        Outer.StaticInnerClass.print();
        System.out.println("==========");

    }
}
