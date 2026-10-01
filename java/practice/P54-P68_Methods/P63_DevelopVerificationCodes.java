package S5_Cases;

public class P63_DevelopVerificationCodes {
    public static void main(String[] args) {
        char a = 98;
        System.out.println(a); //the way to use ASCII number to define characters

        String verificationCode1 = verificationCodesDeveloper1(5);
        String verificationCode2 = verificationCodesDeveloper1(5);
        System.out.println(verificationCode1);
        System.out.println(verificationCode2);
    }

    public static String verificationCodesDeveloper1(int charNumbers) {
        String verificationCode = "";
        int number;
        char character;
        for (int i = 0; i < charNumbers; i++) {
            while (true) {
                number = 48 + (int)(Math.random() * 75);
                if ((number >= 48 && number <= 57) ||
                        (number >= 65 && number <= 90) ||
                        (number >= 97 && number <= 122)) {
                    break;
                }
            }
            character = (char)number;
            verificationCode += character;
        }
        return verificationCode;
    }


    //another method
    public static String verificationCodesDeveloper3(int charNumbers) {
        String verificationCode = "";
        int charCase = (int)(Math.random() * 3);
        char character = ' ';
        for (int i = 0; i < charNumbers; i++) {
     switch (charCase) {
         case 0: //numbers
             character = (char)(48 + (int)(Math.random() * 10));
             break;
         case 1: //capitalized letters
             character = (char)(65 + (int)(Math.random() * 26));
             break;
         case 2: //un-capitalized letters
             character = (char)(97 + (int)(Math.random() * 26));
             break;
             //it is impossible that charCase != 0/1/2, so it is not necessary to add "default"
     }
     verificationCode += character;
        }
        return verificationCode;
    }

}
