package P113_S1_Enum;

public enum EnumTest { //enum is modified by final, cannot be inherited
    //Enum 枚举: A special Class

    //First line must list all objects
    X, Y, Z; //automatically compiled into a constant: public static final EnumTest X = new EnmTest();

    //enum constructors are private, invalid to create objects outside the enum

    //other variables/methods can be written below just as a normal class
    private int a = 1;
    public static void print() {}
}
