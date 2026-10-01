package S1_BasicStatements;

public class P23_Binary_Octal_Hexadecimal {
    public static void main(String[] args) {
        int decimalNumber = 97; //defalut: decimal
        System.out.println(decimalNumber);
        int binaryNumber = 0B01100001; //0B/0b + binary number (output decimal number)
        System.out.println(binaryNumber);
        int octalNumber = 0141; //0 + octal number (output decimal number)
        System.out.println(octalNumber);
        int hexadecimal = 0X61; //0X/0x + hexadecimal number (output decimal number)
        System.out.println(hexadecimal);
    }
}
