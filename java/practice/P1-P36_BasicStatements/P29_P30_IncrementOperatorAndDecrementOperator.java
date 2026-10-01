package S1_BasicStatements;

public class P29_P30_IncrementOperatorAndDecrementOperator {
    public static void main(String[] args) {
        //Increment/decrement Operators can only operate on variables, can not operate on literals (numbers/characters/booleans)
        //++variable/--variable: 1.operate; 2.use
        //variable++/variable--: 1.use; 2.operate
        int m = 5;
        int n = 3;
        //            6  -  5  +  5  -  4  +  4  + 3
        //              m=6   m=5   m=4   n=4   n=3
        int result = ++m - --m + m-- - ++n + n-- + 3;
        System.out.println(m); //4
        System.out.println(n); //3
        System.out.println(result); //9
    }
}
