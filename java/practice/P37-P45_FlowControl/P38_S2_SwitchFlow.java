package S2_FlowControl;

public class P38_S2_SwitchFlow {
    public static void main(String[] args) {
        //Switch Branch: specialized for matching values
/*
        switch (expression) {
            case (Value of expression1):
                code1;
                break; //after running code1, run break to quit the switch branch
            case (Value of expression2):
                code2;
                break;
            case (Value of expression3):
                code3;
                break;
            default:
                code4;
        }
*/
        String date = "Monday";
        switch (date) {
            case ("Monday"):
                System.out.println("Today is Monday.");
                break;
            case ("Tuesday"):
                System.out.println("Today is Tuesday.");
                break;
            case ("Wednesday"):
                System.out.println("Today is Wednesday.");
                break;
            case ("Thursday"):
                System.out.println("Today is Thursday.");
                break;
            case ("Friday"):
                System.out.println("Today is Friday.");
                break;
            case ("Saturday"):
                System.out.println("Today is Saturday.");
                break;
            case ("Sunday"):
                System.out.println("Today is Sunday.");
                break;
            default:
                System.out.println("There is something wrong with your input!");
        }



        //Key Point1:expression on switch can only be byte,short,int,char,String;can not be long,float,double,boolean
        //Key point2:"case (Value of expression):", the value can only be a specific literal instead of a variable (avoid repeat of the values in different cases)



        //Use the fall-through behavior (穿透性) of switch: without "break;", the code can be run fall-through
        String dateToday = "Monday";
        switch (dateToday) {
            case ("Monday"):
            case ("Tuesday"):
            case ("Wednesday"):
            case ("Thursday"):
            case ("Friday"):
                System.out.println("Today is weekday.");
                break;
            case ("Saturday"):
            case ("Sunday"):
                System.out.println("Today is weekend.");
                break;
            default:
                System.out.println("There is something wrong with your input!");
        }

    }
}
