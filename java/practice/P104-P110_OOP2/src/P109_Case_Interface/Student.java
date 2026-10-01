package P109_Case_Interface;

public class Student {
    private String name;
    private char gender;
    private double score;

    public Student(String name, char gender, double score) {
        this.name = name;
        this.gender = gender;
        this.score = score;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", score=" + score +
                '}';
    }
}
