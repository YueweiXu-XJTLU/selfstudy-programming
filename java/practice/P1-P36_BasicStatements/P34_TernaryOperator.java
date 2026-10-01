package S1_BasicStatements;

public class P34_TernaryOperator {
    public static void main(String[] args) {
        //Ternary Operator 三元运算符
        //ConditionExpression ? ValueIfReturnTrue : ValueIfReturnFalse
        //first adjust the ConditionExpression, if return true, output ValueIfReturnTrue;if return false, output ValueIfReturnFalse

        //example1:
        double score = 59.5;
        String result = (score >= 60.0) ? "You passed the exam1" : "You failed the exam!";
        System.out.println(result); //You passed the exam!

        //example2:
        double a = 1.0;
        double b = 2.0;
        double c = 3.0;
        double maxNumberBetweenab = a > b ? a : b;
        double maxNumberBetweenbc = b > c ? b : c;
        double maxNumber = maxNumberBetweenab > maxNumberBetweenbc ? maxNumberBetweenab : maxNumberBetweenbc;
        System.out.println(maxNumber); //2.0

         //a more brief way using Math.max
         double maxValue = Math.max(a , Math.max(b , c));
         System.out.println(maxValue);

    }
}
