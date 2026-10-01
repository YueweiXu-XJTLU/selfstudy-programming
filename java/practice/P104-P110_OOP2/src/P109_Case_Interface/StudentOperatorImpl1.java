package P109_Case_Interface;

import java.util.ArrayList;

public class StudentOperatorImpl1 implements StudentOperator {
    //use "Impl" in class name when creating an implement class
    @Override
    public void printAllInfo(ArrayList<Student> students) {
        System.out.println("=====All Students' Information=====");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i).toString());
            System.out.println("----------");
        }
    }

    @Override
    public void printAverageScore(ArrayList<Student> students) {
        System.out.println("=====Average Score=====");
        double sum = 0.0;
        for (int i = 0; i < students.size(); i++) {
            sum += students.get(i).getScore();
        }

        System.out.println("Average score: " + (sum / students.size()));
    }

}
