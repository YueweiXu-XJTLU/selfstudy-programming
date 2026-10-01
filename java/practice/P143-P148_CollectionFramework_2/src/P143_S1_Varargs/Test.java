package P143_S1_Varargs;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //Varargs = variable number of arguments = variable arguments : 可变参数
        //can accept no_parameter, single_parameter, multiple_parameter or array
        //in essence, vararg accept parameters as form of arrays
        test();
        test(1);
        test(1, 2, 3);
        test(new int[]{1, 2, 3, 4, 5});
    }

    public static void test(int...num) {
        //a method can only have ONE vararg
        //vararg must be the LAST parameter
        System.out.println(num.length);
        System.out.println(Arrays.toString(num));
        System.out.println("-----");
    }
}
