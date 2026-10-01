package P116_Object;

public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Student s1 =  new Student("San.Zhang", 18, new double[]{90.0, 100.0});
        Student s2 =  new Student("San.Zhang", 18, new double[]{90.0, 100.0});

        //methods in "Object Class"

        //1. ".toString()", need to override in classes
        System.out.println(s1.toString()); //Student{name='San.Zhang', age=18}



        System.out.println("==========");



        //2. ".equal()", compare ADDRESSES between 2 objects without override
//        System.out.println(s1.equals(s2)); //false
        //same function of "==" (compare ADDRESSES)
        System.out.println(s1 == s2); //false

        //override to compare CONTAINS of objects
        System.out.println(s1.equals(s2)); //true



        System.out.println("==========");



        //3. ".clone" clone a new object with same contain & different address
        //".clone" is "protected", need to be overridden
        Student s3 = (Student) s1.clone();

        System.out.println(s3);
        System.out.println(s3.getName());
        System.out.println(s1.getName());
        //reference data type will clone the address
        System.out.println(s3.getScores());
        System.out.println(s1.getScores());

        System.out.println("---");

        //different address
        System.out.println(s1 == s3); //false

        System.out.println("---");

        //Shallow Copy:primitive data copy the value; reference data type copy the ADDRESSES
        //Deep copy:primitive data copy the value; String copy the ADDRESSES (String is unchangeable and inside the constant pool); reference data type clone again (create new object)
        Student s4 = (Student) s1.deepClone();
        //reference data type will create new objects
        System.out.println(s4.getScores());
        System.out.println(s1.getScores());
    }
}
