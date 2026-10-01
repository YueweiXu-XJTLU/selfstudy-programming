package S7_String;

public class P79_Case2_DevelopVerificationCodes {
    public static void main(String[] args) {
        System.out.println(developVerificationCodes(10));
    }

    public static String developVerificationCodes(int digits) {
        String verificationCodes = new String();
        String allPossibleChars = "0123456789qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM"; //All digits, upper/lower-cased letters are here

        for (int i = 0; i < digits ; i++) {
            verificationCodes += allPossibleChars.charAt((int)(Math.random() * 62));
        }
        return verificationCodes;
    }

}
