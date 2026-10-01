package S6_S2_JavaBean;

public class P73_JavaBean_Test {
    public static void main(String[] args) {
        //JavaBean
        Student s1 = new Student();
        s1.setName("San.Zhang");
        s1.setScore(99.5);
        System.out.println(s1.getName());
        System.out.println(s1.getScore());

        //Receive data stored in java bean
        StudentOperator operator1 = new StudentOperator(s1);
        operator1.printScore();
    }
}
