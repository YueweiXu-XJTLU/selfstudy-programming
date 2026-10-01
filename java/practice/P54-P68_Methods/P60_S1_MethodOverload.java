package S4_Methods;

public class P60_S1_MethodOverload {
    public static void main(String[] args) {
        //method overload 方法重载
        test();
        test(666); //call two methods with same names and different parameters: available
        test(123, 456);
    }

    public static void test() {
        System.out.println("test1");
    }

    public static void test(int a) {
        System.out.println("test2 " + a);
    }

    public static int test(int a, int b) { //no natter whether public static/returnType is same, method overload is available with different parameter(different type/number/order, no matter whether names are same)
        System.out.println("test3 " + a + " and " + b);
        return a;
    }

}
