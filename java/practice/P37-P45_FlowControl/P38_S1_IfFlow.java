package S2_FlowControl;

public class P38_S1_IfFlow {
    public static void main(String[] args) {
/*
        1. if (condition expression) {
              statement; //run only if output of (condition expression) == true
        }
*/
        double bodyTemperature = 38;

        if (bodyTemperature > 37.5) {
            System.out.println("!!!!!!!!!!");
        }



/*
        2. if (condition expression) {
              statement1;
        } else {
              statement2;
        }
*/
      double yourBalanceInWallet = 0.01;
      if (yourBalanceInWallet >= 520) {
          System.out.println("You have successfully paid $520!");
      } else {
          System.out.println("You have insufficient balance!");
      }



/*
        3. if (condition expression1) {
              statement1;
        } else if (condition expression2) {
              statement2;
        } else if (condition expression3) {
              statement3;
        } else {
              statement4;
        }
*/
        double score = 59;
        if (score >= 90 && score <= 100) {
            System.out.println("Your grade is: A");
        } else if (score >= 80 && score <90) {
            System.out.println("Your grade is B");
        } else if (score >= 70 && score <80) {
            System.out.println("Your grade is C");
        } else if (score >= 60 && score <70) {
            System.out.println("Your grade is D");
        } else if (score >= 0 && score <60) {
            System.out.println("Your failed!");
        } else {
            System.out.println("There is something wrong with your input!");
        }
        //check from top to the bottom, at the first branch that encounter the condition, run and quit the flow

    }
}
