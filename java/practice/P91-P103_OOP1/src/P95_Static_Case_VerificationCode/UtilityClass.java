package P95_Static_Case_VerificationCode;

import java.util.Random;

public class UtilityClass {
    //*** As there is no need for users to create objects in utility class, we can use a private constructor
    private UtilityClass() {
    }

    //Utility Class(工具类): use class method(static)
    public static String verificationCode(int digit) {
        String code = new String();
        String data = "qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM1234567890";

        Random r =new Random();
        for (int i = 0; i < digit; i++) {
            int index = r.nextInt(data.length());
            code += data.charAt(index);
        }
        return code;
    }
}
