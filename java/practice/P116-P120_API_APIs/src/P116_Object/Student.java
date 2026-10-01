package P116_Object;

import java.util.Arrays;
import java.util.Objects;

public class Student implements Cloneable {
    private String name;
    private int age;
    private double[] scores;

    public Student() {
    }

    public Student(String name, int age, double[] scores) {
        this.name = name;
        this.age = age;
        this.scores = scores;
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

    public double[] getScores() {
        return scores;
    }

    public void setScores(double[] scores) {
        this.scores = scores;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", scores=" + Arrays.toString(scores) +
                '}';
    }

    //override equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; //compare addresses
        if (o == null || getClass() != o.getClass()) return false; //exclude "null" object & different class types
        Student student = (Student) o; //cast
        return age == student.age && Objects.equals(name, student.name) && Objects.deepEquals(scores, student.scores); //compare variables
    }

    //override clone
    //the class has to "implements Cloneable", which is a "marker interface 标记接口", without any contains
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    protected Object deepClone() throws CloneNotSupportedException {
        Student deepClonedStudent = (Student) super.clone();
        deepClonedStudent.setScores(this.scores.clone());
        return deepClonedStudent;
    }
}
