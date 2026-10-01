package P103_Inheritance_S1_ConstructorOfSubClass;

public class Super {
    public String name;

    public Super() {
        System.out.println("Super constructor has been run (no parameters)");
    }

    public Super(String name) {
        this.name = name;
        System.out.println("Super constructor has been run (with parameters)");
    }
}

