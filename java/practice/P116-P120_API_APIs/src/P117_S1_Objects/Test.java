package P117_S1_Objects;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        //Objects: toolClass, provide static methods for objects manipulation
        String s1 = "java";
        String s2 = "java";
        String s3 = null; //addresses of null are all same (no address)

        //1. Objects.equals()
        System.out.println(s2.equals(s1)); //true
        //however
//        System.out.println(s3.equals(s1)); //NullPointerException

        //hence we use Objects.equals()
        System.out.println(Objects.equals(s1, s3)); //false
        //source code: return (a == b) || (a != null && a.equals(b));

        System.out.println("----------");

        //2. Objects.isNull() & Objects.nonNull()
        System.out.println(Objects.isNull(s3)); //true
        //totally same as "s1 == null"
        System.out.println(s3 == null); //true

        System.out.println(Objects.nonNull(s1)); //true

    }
}
