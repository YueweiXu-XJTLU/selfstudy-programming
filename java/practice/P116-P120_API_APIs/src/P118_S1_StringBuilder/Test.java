package P118_S1_StringBuilder;

public class Test {
    public static void main(String[] args) {
        //StringBuilder: changeable container for String: high efficiency
        //StringBuilder: Thread Unsafe: Use when a single user is manipulating the same object
        //StringBuilder: Thread Safe: Use when multiple users are manipulating the same object
        //Methods of StringBuilder & StringBuilder atr same



        //1. constructor
        StringBuilder sb1 = new StringBuilder(); //""
        StringBuilder sb2 = new StringBuilder("StringBuilder"); //"StringBuilder"

        //2. .append() 拼接
        sb2.append(123);
        sb2.append(true);
        sb2.append("OK");
        System.out.println(sb2);

        //Chain Programming 链式编程
        //.append() will return "this" (the StringBuilder itself), available for another manipulation
        System.out.println(sb1.append("This ").append("is ").append("a ").append("chain ").append("programming!"));

        //3. .reverse()
        sb2.reverse();
        System.out.println(sb2);

        //4. .length()
        System.out.println(sb2.length());

        //5. .toString(): change StringBuilder object into String object
        String s = sb2.reverse().toString();
        System.out.println(sb2);


    }
}
