package P101_Inheritance_S3_Case_ToString;

public class StudentDefault {
    private String name;
    private int age;

    public StudentDefault(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public StudentDefault() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
