package S6_S2_JavaBean;

public class Student {
    //Java Bean(实体类): used for only store data for objects

    //1.private all attributes
    private String name;
    private double score;

    //2.contain a public non-parameter constructor
    public Student() {
    }

     //another constructor with parameters is also recommended
     public Student(String name, double score) {
         this.name = name;
         this.score = score;
     }

    //3.all attributes have setScore & getScore methods & only exist encapsulating methods
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;

    }
}

class StudentOperator {
    private Student student; //create a Student_type new variable
    public StudentOperator(Student student) { //use constructor with parameter to receive the data inside java bean
        this.student = student;
    }

    //operations
    public void printScore() {
        if (student.getScore() >= 60) {
            System.out.println(student.getScore() + ": Pass");
        } else {
            System.out.println(student.getScore() + ": Fail");
        }
    }
}
