package P113_S2_AbstractEnum;

public enum A {
    //Abstract Enum 抽象枚举: an Enum Class wih abstract methods

    //For listing objects: as abstract methods exist, the class is unable to create objects,
    //Hence we use Anonymous Inner Class to override the abstract methods for each enum_objects:
    X() {
        @Override
        public void run() {
            System.out.println();
        }
    }, Y("San.Zhang") {
        @Override
        public void run() {
            System.out.println(this.name + " is running!");
        }
    };


    public String name;

    A(String name) { //without modifier, as private by default
        this.name = name;
    }

    A() {
    }

    //abstract methods
    public abstract void run();
}
