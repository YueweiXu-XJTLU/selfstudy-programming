package P103_Inheritance_S2_SiblingConstructor;

public class People {
    private String name;
    private int age;

    public People() {
    }

    //if we need to fix age of people to 25, we have 2 ways:
    //1. rewrite a constructor: many repeated codes with the former constructor: not elegant
//    public People(String name) {
//        this.name = name;
//        this.age = 25;
//    }

    //2. use "this(...)" to call sibling constructor(兄弟构造器) in a same class
    public People(String name) {
        //Don't add "super()" here as it has been automatically added in the sibling constructor
        this(name, 25);//Don't add "this." before variables again as an object has not been constructed so far
    }

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
