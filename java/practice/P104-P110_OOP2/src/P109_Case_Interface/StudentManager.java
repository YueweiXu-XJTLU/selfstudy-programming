package P109_Case_Interface;

import java.util.ArrayList;

public class StudentManager {
    private static ArrayList<Student> students = new ArrayList<>();
    //Interface Oriented Programming:
    private StudentOperator studentOperator = new StudentOperatorImpl2(); //satisfied with polymorphism
    //if we want to change the print pattern, just change "Impl" number here without any change in codes

    //the constructors here can not use the automatically generated ones
    public StudentManager(Student student) {
        students.add(student);
    }

    public StudentManager(String name, char gender, double score) {
        students.add(new Student(name, gender, score));
    }

    public StudentManager() {
    }

    //we initialize the ClassManager Class, we can store some known data first
    static {
        students.add(new Student("Jack", 'M', 90.5));
        students.add(new Student("Rose", 'F', 85.5));
        students.add(new Student("Mike", 'M', 95.5));
    }

    //print all students info in 2 patterns which can alternative conveniently
    // 1. print all students info
    public void printAllInfo() {
        studentOperator.printAllInfo(students);
    }

    //2. print average score
    public void printAverageScore() {
        studentOperator.printAverageScore(students);
    }
}
