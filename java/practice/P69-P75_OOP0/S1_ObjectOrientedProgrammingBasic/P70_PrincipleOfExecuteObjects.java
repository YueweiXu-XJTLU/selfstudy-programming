package S6_S1_ObjectOrientedProgrammingBasic;

public class P70_PrincipleOfExecuteObjects {
    public static void main(String[] args) {
        Student student1 = new Student();
        System.out.println(student1); //stored packageName&className&objectAddress

        //default values of member_variables
        Student test = new Student();
        System.out.println(test.name); //null
        System.out.println(test.chineseScore); //0
        System.out.println(test.grade); //0

        //if there not exist any variables point to an object, it is recognized as a garage object and will be automatically cleaned by java to avoid wasting resources
        test = null;
        test.name = "San.Zhang";
        System.out.println(test.name); //error occurs
    }
}
