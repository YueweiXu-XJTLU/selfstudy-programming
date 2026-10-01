package S2_FlowControl;//for-loop is completely the same as while-loop, the only difference is:
//If the number of iterations is known, use for-loop;
//If the number of iterations is unknown, use while-loop.

public class P39_ForLoop {
    public static void main(String[] args) {
/*
       for (InitializingAVariable; LoopCondition; IterationStatement) {
           the statements to be looped;
       }


*/
/*
       initialize the variable, compare to the loop condition, if return true, run the statements inside {};
       run the iteration statement, compare to the loop condition, if return true, run the statements inside {};
       run the iteration statement, compare to the loop condition, if return true, run the statements inside {};
        ...
       run the iteration statement, compare to the loop condition, if return false, quit the loop.
*/
        //compare, then run

        for (int i = 0; i < 5; i++) {
            System.out.println("Hello World!");
        }



        //Application1: generate a sequence of numbers
        for (int a = 0; a < 10; a++) {
            System.out.println(a);
        }



        //Application2: calculation the sum
         //sum from 0~100
        int sum1 = 0;
        for (int b = 0; b <= 100; b++) {
            sum1 += b;
        }
        System.out.println(sum1);
         //sum of odd numbers from 1~100 (solution1): use for-loop itself
        int sum2 = 0;
        for (int c = 1; c < 100; c += 2) {
            sum2 += c;
        }
        System.out.println(sum2);
         //sum of odd numbers from 1~100 (solution2): use ternary operator
        int sum3 = 0;
        for (int d = 0; d < 100; d++) {
            int e = ((d % 2) == 1) ? (sum3 += d) : (sum3 = sum3);
        }
        System.out.println(sum3);
         //sum of odd numbers from 1~100 (solution3): use if-flow
        int sum4 =0;
        for (int f = 0; f < 100; f++) {
            if (f % 2 == 1) {
               sum4 += f;
            }
        }
        System.out.println(sum4);
        //sum of prime numbers from 1~100:
        int sum5 = 0; //create the variable to store the sum
        boolean nIsPrimeNumber = true; //every number is a prime number by default, only need to pick up numbers that are not prime below
        for (int n = 2; n < 100; n++) { //adjust n from 2 to 100 (1 is not a prime number by definition)
         for (int i = 2; i < n; i++) { //for a certain n, calculate n % every number less than itself and greater than 2
            if ((n % i) == 0){
                nIsPrimeNumber = false; //if there is some i that n%i=0, then n is not a prime number
            }
        }

         if (nIsPrimeNumber == true) { //!!!if n is a prime number, then plus it to sum5
             sum5  += n;
         }

         nIsPrimeNumber = true; //reset the nIsPrimeNumber to true for next circle of calculation for next n
        }
        System.out.println(sum5);

    }
}
