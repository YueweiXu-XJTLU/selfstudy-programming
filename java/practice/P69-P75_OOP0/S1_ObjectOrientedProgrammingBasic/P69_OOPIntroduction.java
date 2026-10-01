package S6_S1_ObjectOrientedProgrammingBasic;

public class P69_OOPIntroduction {
    public static void main(String[] args) {
        Student student1 = new Student(); //className objectName = new className()
        student1.name = "San.Zhang";
        student1.chineseScore = 99.0;
        student1.mathScore = 100.0;

        student1.averageScore();
    }
}
