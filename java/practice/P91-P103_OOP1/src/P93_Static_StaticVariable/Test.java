package P93_Static_StaticVariable;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();

        //call class variables (belong to the class, only on copy in the computer, shared by all objects)(changed by class/changed by any object, it will change):
        //1.className.classVariableName
        Student.name = "San.Zhang";
        System.out.println(s1.name);
        System.out.println(s2.name);
        System.out.println(Student.name);
        //2.object.classVariableName (not recommend)
        s1.name = "Si.Li";
        System.out.println(s1.name);
        System.out.println(s2.name);
        System.out.println(Student.name);

        //call instance variables (only belong to the object itself):
        //object.instanceVariableName
        s1.age = 18;
        System.out.println(s1.age); //18
        System.out.println(s2.age); //0
    }
}
