package P154_S1_Recursion;

public class Test {
    public static void main(String[] args) {
//        test1();
//    test2();
    }

    //direct recursion: call the method inside itself: StackOverflowError: load too many times of the method without remove
    public static void test1() {
        System.out.println("===test1===");
        test1();
    }

    //indirect recursion: call the method1 inside another method2, and method2 recall method1
    public static void test2() {
        System.out.println("===test2===");
        test3();
    }
    public static void test3() {
        System.out.println("===test3===");
        test2();
    }
}

