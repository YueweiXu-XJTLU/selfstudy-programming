package P194_S1_Reflection_GetFields;

public class Student {
    public static int a;
    public static final String COUNTYR = "China";
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
