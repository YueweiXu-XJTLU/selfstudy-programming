package S7_String;

public class P78_TipsForStringUtilization {
    public static void main(String[] args) {
        //1.String objects is unchangeable
        //"+" of Strings: always create new Strings instead of change the former one
        String bang = "bang";
        String exclamation = "!!!";
        String bomb = bang + exclamation;
        System.out.println(bomb);


        //2.Storage principle of String
        //2.1.use primitive to initialize String: stored in constant pool (a region in stack), store once if content is same
        String a = "abc"; //as there's no "abc" in constant pool, it is initialized, the address is assigned to a
        String b = "abc"; //as an "abc" has been created above, its address is used directly
        boolean initialize1 = (a == b); //this method create/assign a public String
        System.out.println(initialize1); //true

        //2.2.call constructor ("new String()") to initialize String: create a new object inn stack EVERY TIMES
        String c = new String("abc"); //create "abc" in stack
        String d = new String("abc"); //create "abc" again in stack
        boolean initialize2 = (c == d); //there exists 2 different addresses which store the same String "abc"
        System.out.println(initialize2); //false



        System.out.println("--cases--");



        //Cases
        //1.
        String s1 = new String("abc"); //create 2 objects on stack, one in constant pool, another directly in stack, the later one's address is assigned to s1
        String s2 = "abc"; //the constant pool has already existed an 'abc', the address is directly assigned to s2 (create 0 new objects)
        System.out.println(s1 == s2); //false

        System.out.println("-----");

        //2.
        String s3 = "bcd"; //in constant pool
        String s4 = "bc";
        String s5 = s4 + "d"; //when variable(s4) is included in calculation(+), the new objects is stored to stack
        System.out.println(s3 == s5); //false

        System.out.println("-----");
        String s6 = "b" + "c" + "d"; //calculation(+) of only Strings: store into constant pool directly
        System.out.println(s3 == s6); //true

    }
}
