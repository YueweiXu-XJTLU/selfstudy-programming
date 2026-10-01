package S1_BasicStatements;

public class P33_LogicalOperators {
    public static void main(String[] args) {
        //Logical Operator 逻辑运算符
/*
        & AND
        | OR
        ! NOT (取反): true->false; false->true
        ^ XOR (exclusive OR)(异或): A ^ B: return of A and B are NOT the same->return true; return of A and B are the same->return false
        && Short-circuit AND (短路与): A && B: first adjust A,if A returns false, then close and return false; if A returns true, than adjust B
        || Short-circuit OR (短路或): A || B: first adjust A,if A returns true, then close and return true; if A returns false, than adjust B

*/
        double cpu = 12980;
        double gpu = 5090;
        boolean computer1 = cpu >= 13980 & gpu >= 4090;
        System.out.println(computer1); //false

        boolean computer2 = cpu >= 13980 | gpu >= 4090;
        System.out.println(computer2); //true

        boolean computer3 = ! (cpu >= 13980);
        System.out.println(computer3); //true

        boolean computer4 = cpu >= 13980 ^ gpu >= 4090;
        System.out.println(computer4); //false ^ true //true

        boolean computer5 = cpu >= 13980 && gpu >= 4090;
        System.out.println(computer5); //false

        boolean computer6 = gpu >= 4090 || cpu >= 13980;
        System.out.println(computer6); //true



        int a = 10;
        int b = 20;
        System.out.println(a > 100 && b++ > 200); //false //left side: false, then close this statement without run b++ and b++ > 200
        System.out.println(b); //20

        System.out.println(a > 100 || b++ > 200); //false //left side: false, then run right
        System.out.println(b); //21



        //the precedence of () > & > | > && > ||
        System.out.println(true || true && false); //true //adjust (true && true) first
        System.out.println((true || true) && false); //false


    }
}
