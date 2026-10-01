package P101_Inheritance_S3_Case_ToString;

public class Test {
    public static void main(String[] args) {
        StudentDefault s1 = new StudentDefault("San.Zhang", 18);
        System.out.println(s1.toString()); //"toString" is a method in Object Class, it can print address of the object
        System.out.println(s1); //here java use ".toString" automatically by default

        Student s2 = new Student("San.Zhang", 18);
        System.out.println(s2.toString()); //"toString" is a method in Object Class, it can print address of the object
        System.out.println(s2);
    }
}
