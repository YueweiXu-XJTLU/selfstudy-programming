package S6_S1_ObjectOrientedProgrammingBasic;

public class P71_ThisKeyword {
    public static void main(String[] args) {
        //"this" is a variable
        //used in methods
        //get the object(address)
        Student s1 = new Student();
        System.out.println(s1);
        s1.thisKeyword();


        ScoreLine s2 = new ScoreLine();
        s2.score = 618.5; //the attribute for an object ("this.score" in method)
        s2.whetherPass(700.0); //here define the parameter for the method in class, "score" in the method
    }
}
