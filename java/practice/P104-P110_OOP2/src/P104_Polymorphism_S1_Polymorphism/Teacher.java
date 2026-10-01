package P104_Polymorphism_S1_Polymorphism;

public class Teacher extends People {
    public String name = "Teacher";

    @Override
    public void run() {
        System.out.println("Teachers run slower.");
    }

}
