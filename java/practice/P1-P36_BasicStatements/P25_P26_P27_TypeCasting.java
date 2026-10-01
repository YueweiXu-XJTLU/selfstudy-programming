package S1_BasicStatements;

public class P25_P26_P27_TypeCasting {
    public static void main(String[] args) {
        //P25_1.Automatic Type Casting: small => larger automatically
         //small => larger: byte -> short -> int -> long -> float -> double
         //                         char -> int
        byte myByte = 1;
        double myDouble1 = myByte;
        System.out.println(myDouble1); //1.0

        char myChar = 'A';
        System.out.println(myChar); //A //ASCII of 'A' = 65
        double myDouble2 = myChar * 1;
        System.out.println(myDouble2); //65.0 //char type automatically casting into double type

        //P27_2.Explicit Type Casting (强制类型转换): permit larger type => small type: may overflow
        int a = 128;
        byte b = (byte) a;
        System.out.println(b); // -128
        //calculation of overflowed numbers:
        //int 128:00000000 00000000 00000001 10000000
        //step1: 4byte => 1byte: 10000000
        //step2: the first bit: 0 <=> + ; 1 <=> -
        //step3: Bitwise NOT (Bitwise Negation Operator)(取反):0 <=> 1: 10000000 => 01111111 (+127)
        //step4: +1 : +127 + 1 = +128
        //step5: combine sign and value: -128
    }
}
