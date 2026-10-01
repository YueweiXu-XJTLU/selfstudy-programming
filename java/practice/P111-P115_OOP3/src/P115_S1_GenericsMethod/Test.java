package P115_S1_GenericsMethod;

import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        String str = print("abc");
        System.out.println(str);

        ArrayList arrayList = new ArrayList<>();
        ArrayList arrayList2 = print(arrayList);

        //not errors occur
    }



    //Generic Methods: declare the generics itself
    public static <E> E print(E e) {
        return e;
    }
}
