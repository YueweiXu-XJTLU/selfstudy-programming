package P97_Static_CodeBlock;

public class Student {
    public static String school;
    public int age;

    //Static Code Block (静态代码块):
    //Feature: automatically load while class was load, hence only run ONCE
    //Function: initialize variables
    static {
        System.out.println("Static Code Block has been run");
        school = "XJTLU";
    }

    //Instance Code Block
    //Feature: automatically run when EVERY object is created (the block run ahead of construct with/without parameter(s))
    //Function: initialize variables: but this is MEANINGLESS, don't do that; create the log for objects creating (avoid writing code of log in every constructor)
    {
        System.out.println("Instance Code Block has been run");
        age = 18;
    }

    public Student() {
        System.out.println("a constructor without parameters has been run");
    }

    public Student(int age) {
        this.age = age;
        System.out.println("a constructor with parameters has been run");
    }
}
