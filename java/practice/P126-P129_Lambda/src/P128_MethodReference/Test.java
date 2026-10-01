package P128_MethodReference;

import P126_Arrays.Students;

import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        Student s1 = new Student("s1", 12);
        Student s2 = new Student("s2", 19);
        Student s3 = new Student("s3", 11);
        Student[] students = {s1, s2, s3};

//        Arrays.sort(students, new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.age -o2.age;
//            }
//        });

//        Arrays.sort(students, (o1, o2) -> o1.age -o2.age);



        //Method Reference (方法引用): further simplify Lambda Expression

        //1. static method reference: "ClassName::StaticMethodName"
        //if a lambda call a method of the anonymousInnerClass and THE PARAMETERS ARE THE SAME as another STATIC method in another class, then we use static method reference
        //here, the method inside anonymousInnerClass need to be overridden is same in function with the method:"compareByAge_Static" in the class:"CompareRules"
//        Arrays.sort(students, (o1, o2) -> CompareRules.compareByAge(o1, o2));
        Arrays.sort(students, CompareRules::compareByAge_Static);
        System.out.println(Arrays.toString(students)); //ascending order



        //2. instance method reference: "ObjectName::InstanceMethodName"
        //if a lambda call a method of the anonymousInnerClass and THE PARAMETERS ARE THE SAME as another INSTANCE method in another class, then we use instance method reference
        //here, the method inside anonymousInnerClass need to be overridden is same in function with the method:"compareByAge_Instance" in the class:"CompareRules"
        CompareRules cr1 = new CompareRules();
//        Arrays.sort(students, (o1, o2) -> cr1.compareByAge_Instance(o1, o2));
        Arrays.sort(students, cr1::compareByAge_Instance);
        System.out.println(Arrays.toString(students)); //ascending order



        //3. certain typed method reference: "CertainTypedClassName::CertainTypedMethodName"
        String[] names = {"a", "d", "c", "C", "B", "D", "A", "b"};
        Arrays.sort(names);
        System.out.println(Arrays.toString(names)); //Rank using ASCII number of FirstLetter

//        Arrays.sort(names, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.compareToIgnoreCase(o2);
//            }
//        });

//        Arrays.sort(names, (o1, o2) -> o1.compareToIgnoreCase(o2));

        //if a lambda call an INSTANCE method of a MAJOR-parameter and a MINOR-parameter, then we use certain typed method reference
        //here, major-parameter is "o1", and minor-parameter is "o2", and the instance method belongs to "String", as "o1.compareToIgnoreCase(o2)"
        Arrays.sort(names, String::compareToIgnoreCase);
        System.out.println(Arrays.toString(names)); //Rank ignore case of FirstLetter



        //4. constructor reference: "ClassName::new"
        //if a lambda call a method of the anonymousInnerClass JUST TO CREATE A NEW OBJECT (FUNCTION AS A CONSTRUCTOR), and THE PARAMETERS ARE THE SAME as the original constructor, then we use constructor reference
//        CreateStudent cs = new CreateStudent() {
//            @Override
//            public Student createStudent(String name, int age) {
//                return new Student(name, age);
//            }
//        };

//        CreateStudent cs = (String name, int age) -> new Student(name, age);

        CreateStudent cs = Student::new;

        Student s = cs.createStudent("San.Zhang", 20);
        System.out.println(s.toString());
    }
}