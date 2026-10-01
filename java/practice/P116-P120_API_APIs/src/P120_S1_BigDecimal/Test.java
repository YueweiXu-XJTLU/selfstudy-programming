package P120_S1_BigDecimal;

import javax.crypto.spec.PSource;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Test {
    public static void main(String[] args) {
        //inaccuracy in double/float calculation:
        System.out.println(0.1 + 0.2); //0.30000000000000004
        System.out.println(0.1 / 0.3); //0.33333333333333337



        System.out.println("==========");



        //solve by BigDecimal (casting into String for calculation)
        BigDecimal bd1 = new BigDecimal(Double.toString(0.1));
        BigDecimal bd2 = new BigDecimal(Double.toString(0.2));
        //A more elegant way: .valueOf
        BigDecimal bd3 = BigDecimal.valueOf(0.3);



        BigDecimal rs1 = bd1.add(bd2);
        System.out.println(rs1); //0.3

        //for division: BigDecimal only return ACCURATE outcomes(0.25/0.43/...)
        System.out.println(bd1.divide(bd2)); //0.5
        //for inaccurate outcomes, we need to set: (divided_number, precision_scale, rounding_mode(an enum))
        System.out.println(bd1.divide(bd3, 17, RoundingMode.HALF_UP)); //0.33333333333333333



        //return back the result from BigDecimal to double
        double rs_double = rs1.doubleValue();
        System.out.println(rs_double); //0.3


    }
}
