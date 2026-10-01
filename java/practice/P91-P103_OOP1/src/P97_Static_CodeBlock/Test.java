package P97_Static_CodeBlock;

public class Test {
    public static void main(String[] args) {
       //Static Code Block
       System.out.println(Student.school);
       System.out.println(Student.school);
       System.out.println(Student.school);

        //Instance Code Block
        Student s1 = new Student();
        System.out.println(s1.age);

        Student s2 = new Student(19);
        System.out.println(s2.age);
    }
}
