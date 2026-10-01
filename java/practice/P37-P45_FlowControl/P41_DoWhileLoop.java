package S2_FlowControl;

public class P41_DoWhileLoop {
    public static void main(String[] args) {
/*
        do {
            the statements to be looped;
            IterationStatement;
        } while (LoopCondition);
*/
/*
        initialize the variable,then run the iteration statement, then run the iteration statement, compare to the loop condition, if return true, return into the {};
        run the iteration statement, then run the iteration statement, compare to the loop condition, if return true, return into the {};
        run the iteration statement, then run the iteration statement, compare to the loop condition, if return true, return into the {};
        ...
        run the iteration statement, then run the iteration statement, compare to the loop condition, if return false, quit the loop.
*/
        //run, then compare

        int i = 0;
        do {
            System.out.println("Hello World!");
            i++;
        } while (i < 5);



        //difference between For-Loop/While-Loop and DoWhile-Loop:
        int a = 0;
        do {
            System.out.println("DoWhile-Loop: run, then compare.");
            a++;
        } while (false);

        int b = 0;
        boolean falseVariable = false;
        while (falseVariable) {
            System.out.println("While-Loop/For-Loop: compare, than run.");
            b++;
        }

    }
}
