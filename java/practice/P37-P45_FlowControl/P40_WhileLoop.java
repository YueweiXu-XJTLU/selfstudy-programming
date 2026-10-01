package S2_FlowControl;

public class P40_WhileLoop {
    public static void main(String[] args) {
/*
        statement for initializing a variable;
        while (LoopCondition) {
            the statements to be looped;
            IterationStatement;
        }
*/
/*
        initialize the variable, compare to the loop condition, if return true, run the statements inside {}, then run the iteration statement;
        compare the variable to the loop condition, if return true, run the statements inside {}, , then run the iteration statement;
        compare the variable to the loop condition, if return true, run the statements inside {}, , then run the iteration statement;
        ...
        compare to the loop condition, if return false, quit the loop.
*/
        //compare, then run

        int i = 0;
        while (i < 5) {
            System.out.println("Hello World!");
            i++;
        }


        //for-loop is completely the same as while-loop, the only 2 differences are:
        //1.If the number of iterations is known, better to use for-loop; If the number of iterations is unknown, better to use while-loop.
         //case1
        double peakHeight = 8848860; //unit:mm
        double paperThickness = 0.1; //unit:mm
        int count = 0;

        //The number of iterations is unknown, use while-loop.
        while (paperThickness <= peakHeight) {
            paperThickness *= 2;
            count++;
        }
        System.out.println("After " + count + " times of folding, the thickness of the paper is " + paperThickness + " mm, which is higher than the mountain!");

        //2. Variable used to control the for-loop is automatically cleared after the loop (can not be directly used out of the for-loop); Variable used to control the while-loop/do-while-loop is still usable after the loop.
        for (int j = 0; j < 2; j++) {
            System.out.println("j in for-loop");
        }
        //System.out.println(j); //errors occur

        int j = 0;
        while (j < 2) {
            System.out.println("j in while-loop");
            j++;
        }
        System.out.println(j);

    }
}