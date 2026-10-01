package P104_Polymorphism_S2_TypeCasting;

public class Test {
    public static void main(String[] args) {
        //Type Casting
        //1.Implicit type (up)casting (自动类型转换): Super <= Sub
        People p1 = new Student();
        People p2 = new Teacher();

        //2.Explicit type casting (强制类型转换):  Sub <= (Sub) Super

        //Disadvantages of polymorphism: Unique method of subclass cannot be run
        //to solve this problem, we use explicit type casting:
        Student s1 = (Student) p1;
        s1.UniqueMethodInStudentClass();

        //However, as "编译看左(Super)", though the casting may be available when compiling, error may occur when running
        //e.g.
        //Teacher t1 = (Teacher) p1; //when compiling, p1 is "People", hence (Teacher)People is available, but it is actually a "Student", Teacher != (Teacher)Student
        //here "ClassCastException(类型转换异常)" error occurs

        //to solve this problem: use "instanceof" to get the actual data type of objects (return boolean)
        if (p1 instanceof Teacher) {
            Teacher t1 = (Teacher) p1;
        } else {
            System.out.println("\"p1\" is not a \"Teacher\" data type");



            System.out.println("-----");
            toDo(p1);
            System.out.println("---");
            toDo(p2);
        }
    }

    public static void toDo(People p) {
        p.run();
        if (p instanceof Student) {
            ((Student) p).UniqueMethodInStudentClass();
        } else if (p instanceof Teacher) {
            ((Teacher) p).UniqueMethodInTeacherClass();
        } else {
            System.out.println("Invalid Value!");
        }
    }
}
