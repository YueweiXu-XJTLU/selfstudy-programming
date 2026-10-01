package S1_BasicStatements;

public class P28_PlusSignAsConnector {
    public static void main(String[] args) {
        int a = 10;
        System.out.println((a + 'a' + "a")); //107a
        System.out.println("a" + a + 'a' + a); //a10a10
        /*
        when "+" functions as the connector:
        !!!from left to right, step by step!!!
        if calculation is allowed(a; 'a'), calculate first;
        if  calculation is not allowed("a"), simply connect.
        */
        }
}
