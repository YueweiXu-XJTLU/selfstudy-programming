package S2_FlowControl;

public class P43_BreakAndContinueInLoop {
    public static void main(String[] args) {
        //break; : quit the current loop
        //break can only be singly used in switch and loops
        for (int i = 1; i <= 5; i++) {
            System.out.println(i);
            if (i == 3) {
                break;
            }
        }

        System.out.println("----------");

        //continue; : quit the current iteration (even if the statements in this iteration below "continue;" will be quit), jump into next iteration directly
        //continue can only be singly used in loops
        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }

    }
}
