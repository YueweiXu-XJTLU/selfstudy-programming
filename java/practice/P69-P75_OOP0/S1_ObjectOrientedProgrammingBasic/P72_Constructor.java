package S6_S1_ObjectOrientedProgrammingBasic;

public class P72_Constructor {
    public static void main(String[] args) {
        Person p1 = new Person(); //the no-parameter constructor is no need to write, it is automatically created by java
        //but if we create a parameter constructor, java will not create the no-parameter constructor automatically, better to write it
        Person p2 =  new Person("San.Zhang"); //constructors allow us to initialize data when creating an object
        System.out.println(p2.name);


    }
}
