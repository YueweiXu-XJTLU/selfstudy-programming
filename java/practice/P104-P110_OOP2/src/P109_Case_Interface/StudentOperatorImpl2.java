package P109_Case_Interface;

import java.util.ArrayList;

public class StudentOperatorImpl2 implements StudentOperator {

    @Override
    public void printAllInfo(ArrayList<Student> students) {
        System.out.println("=====All Students' Information (counting M & F numbers)=====");
        int MaleCount = 0;

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getGender() == 'M') {
                MaleCount++;
            }
            System.out.println(students.get(i).toString());
            System.out.println("----------");
        }

        System.out.println("Total Count: " + students.size());
        System.out.println("Male Count: " + MaleCount);
        System.out.println("Female Count: " + (students.size() - MaleCount));
    }

    @Override
    public void printAverageScore(ArrayList<Student> students) {
        System.out.println("=====Average Score (remove highest & lowest)=====");
        double sum = 0.0;
        double max = students.get(0).getScore();
        double min = students.get(0).getScore();

        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getScore() > max) {
                max = students.get(i).getScore();
            }
            if (students.get(i).getScore() < min) {
                min = students.get(i).getScore();
            }
            sum += students.get(i).getScore();
        }

        System.out.println("Max score: " + max);
        System.out.println("Min score: " + min);
        System.out.println("Average score: " + (sum - max - min) / (students.size() - 2));
    }

}
