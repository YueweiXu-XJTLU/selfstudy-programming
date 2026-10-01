package P113_S1_Enum;

import java.sql.SQLOutput;

public class Test {
    public static void main(String[] args) {
        EnumTest et1 = EnumTest.X;
        System.out.println(et1); //X

        //enum constructors are private, invalid to create objects outside the enum
//        EnumTest et = new EnumTest(); //error occurs

        //enum provides some APIs
        EnumTest[] enumTestObjects = EnumTest.values(); //get all enum objects & return an array
        for (int i = 0; i < enumTestObjects.length; i++) {
            System.out.print(enumTestObjects[i] + " ; ");
        }
        System.out.println();

        EnumTest et2 = EnumTest.valueOf("Y"); //find object according to name (strictly match)
        System.out.println(et2.name()); //get object name
        System.out.println(et2.ordinal()); //get object index
    }
}
