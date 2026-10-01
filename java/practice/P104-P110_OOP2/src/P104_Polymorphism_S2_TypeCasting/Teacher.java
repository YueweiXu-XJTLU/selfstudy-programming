package P104_Polymorphism_S2_TypeCasting;

public class Teacher extends People {
    public String name = "Teacher";

    @Override
    public void run() {
        System.out.println("Teachers run slower.");
    }

    public void UniqueMethodInTeacherClass() {
        System.out.println("A unique method in teacher class.");
    }
}
