package P104_Polymorphism_S1_Polymorphism;

public class Student extends People {
    public String name = "Student";

    @Override
    public void run() {
        System.out.println("Students run faster.");
    }

    public void UniqueMethodInStudentClass() {
        System.out.println("A unique method in student class.");
    }
}
