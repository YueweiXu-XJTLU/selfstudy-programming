package S2_FlowControl;

public class P42_S1_EndlessLoop {
    public static void main(String[] args) {
        //Endless Loop 死循环
        //type1: endless-loop in for-loop
/*
        for ( ; ; ) {
            System.out.println("endless-loop in for-loop");
        }
*/

        //type2 (best endless-loop type)(unknown number of iterations): endless-loop in while-loop
/*
        while (true) {
            System.out.println("endless-loop in while-loop");
        }
*/

        //type3: endless-loop in do-while-loop
/*
        do {
            System.out.println("endless-loop in do-while-loop");
        } while (true);
*/

    }
}
