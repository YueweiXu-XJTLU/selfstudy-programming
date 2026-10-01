package S6_S1_ObjectOrientedProgrammingBasic;

public class Student {
    String name; //create member_variables or attributes for objects
    double chineseScore;
    double mathScore;
    char grade;

    //create member_methods or behaviour in object class, no need static
    public void averageScore() {
        System.out.println("Average score for " + name + " is: " + ((chineseScore + mathScore) / 2));
    }


    public void thisKeyword() {
        //"this" is a variable
        //used in methods
        //get the object(address)
        System.out.println(this);
    }

}

class Car {
    //a profile can contain multiple classes, but can only use one "public" and must use it before the profile_named class

}

class ScoreLine {
    public double score;

    public void whetherPass(double score) { //"this" is used to avoid conflicting between name of parameters and attributes
        if (this.score > score) {
            System.out.println("Passed");
        } else {
            System.out.println("Failed");
        }
    }
}


class Person {
    public String name;

    public Person() { //Constructor:a method in a class: must not use "static" & "returnType", name of constructor must be same with the className
        System.out.println("A constructor without parameters is run.");
    }

    public Person(String name) { //constructors can be overloaded
        System.out.println("A constructor with a parameter: name = " + name + " is run.");
        this.name = name; //constructors allow us to initialize data when creating an object using this statement
    }
}

class EncapsulatedStudent {
    //a standard encapsuling process
    private double score; //initialize private attributes

    //setScore
    public void setScore(double score) {
        if(score >= 0 && score <= 100) {
            this.score = score;
        } else {
            System.out.println("Invalid");
        }
    }

    //getScore
    public double getScore() {
        return score;
    }

}