package P194_S2_Reflection_GetMethods;

public class Student {
    private void run() {
        System.out.println("Running");
    }

    public void eat() {
        System.out.println("Eating");
    }

    private String eat(String food) {
        return "Eating " + food;
    }
}
