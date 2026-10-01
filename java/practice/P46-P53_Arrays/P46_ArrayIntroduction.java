package S3_Arrays;

import java.util.Random;

public class P46_ArrayIntroduction {
    public static void main(String[] args) {
        //Array 数组

        //compare array to some common variables (convenience of array)
        Random r = new Random();
        int randomNumber = r.nextInt(0, 2);
        System.out.println(randomNumber);

        //use array
        String[] arrayOfString = {"San Zhang", "Si Li", "Wu Wang"};
        System.out.println(arrayOfString[randomNumber] + ", your are selected!");

        //use variables
        String name0 = "San Zhang";
        String name1 = "Si Li";
        String name2 = "Wu Wang";

        switch (randomNumber) {
            case 0:
                System.out.println(name0 + ", your are selected!");
                break;
            case 1:
                System.out.println(name1 + ", your are selected!");
                break;
            case 2:
                System.out.println(name2 + ", your are selected!");
                break;
            default:
        }

    }
}
