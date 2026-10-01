package P113_S4_ApplicationOfEnum;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //Usage of Enum: pass parameter when categorizing info

        //we need to check the user's gender
        Scanner sc = new Scanner(System.in);
        System.out.println("What's your gender (boy/girl):");
        switch (sc.nextLine()) {
            case "boy":
                check(Constant.BOY); //use eum, to restrict the passing_in_data_type
                break;
            case "girl":
                check(Constant.GIRL); //use eum, to restrict the passing_in_data_type
                break;
        }
        sc.close();
    }

    private static void check(Constant gender) {
        switch (gender) {
            case BOY: //no need to use "Constant.BOY" here, as switch can automatically recognize the enum
                System.out.println("Boy here!");
                break;
            case GIRL: //no need to use "Constant.GIRL" here, as switch can automatically recognize the enum
                System.out.println("Girl here!");
                break;
            default:
                break;
        }
    }
}
