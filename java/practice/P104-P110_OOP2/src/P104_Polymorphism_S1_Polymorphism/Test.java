package P104_Polymorphism_S1_Polymorphism;

public class Test {
    public static void main(String[] args) {
        //Polymorphism 多态: a phenomena of java inheritance/implementation

        //1.Object Polymorphism 对象多态: SuperClass objects can point to (refer to) multiple SubClass objects
        People p1 = new Student(); //LargerSlope(SuperClass) objectName = new SmallerSlope(SubClass)
        People p2 = new Teacher();

        //2.Behavior Polymorphism 行为多态: Different objects can call overridden methods
        p1.run();
        p2.run();
        //"编译看左，运行看右"
        //Compiling: investigating left-side of "=": does "People" class have ".run" method"?
        //Run: investigating right-side of "=": run the OVERRIDDEN ".run" method in the "Student"/"Teacher" classes
        //Precondition of behavior polymorphism
        //1.existence of inheritance/implementation
        //2.existence of object polymorphism
        //3.methods are overridden

        //***NO polymorphism for member-variables in java
        //"编译看左，运行看左"
        //Compiling: investigating left-side of "=": does "People" class have ".run" method"?
        //Run: investigating left-side of "=": return the member-variable in SuperClass
        System.out.println(p1.name);
        System.out.println(p2.name);


        System.out.println("-----");



        //Advantages of polymorphism
        //1.decoupled (解耦合) hence highly extensible (高拓展性)
        People p3 = new Teacher();
        //Decoupled: if we aren't satisfied with the Teacher Class, then just change it into Student Class and no errors will occur
        p3 = new Student();
        p2 = p1;

        //2.if a method accept SuperClass Objects as parameters, all SubClass Objects are also available to be accepted
        //But still use member-variables in java (编译看左，运行看左)
        Student s = new Student();
        aMethod(s);
        Teacher t = new Teacher();
        aMethod(t);

        //Disadvantages of polymorphism: Unique method of subclass cannot be run
        People p4 = new Student();
        //p4.UniqueMethodInStudentClass(); //error occurs
        Student s1 = new Student();
        s1.UniqueMethodInStudentClass();

    }

    //2.if a method accept SuperClass Objects as parameters, all SubClass Objects are also available to be accepted
    public static void aMethod (People p){
        System.out.println(p.name);
    }
}
