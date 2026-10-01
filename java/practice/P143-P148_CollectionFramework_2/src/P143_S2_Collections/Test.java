package P143_S2_Collections;

import java.util.*;

public class Test {
    public static void main(String[] args) {
        //Collections : Tool Class to manipulate collection

        //1. addAll(Collection<? super T> c, T...elements) : add data flexibly
        List<String> letters = new ArrayList<>();
        Collections.addAll(letters, "a", "b", "c", "d", "e");
        System.out.println(letters);

        System.out.println("-----");

        //2. shuffle(List<?> list) : shuffle(打乱顺序) LIST
        Collections.shuffle(letters);
        System.out.println(letters);
        Collections.shuffle(letters);
        System.out.println(letters);
        Collections.shuffle(letters);
        System.out.println(letters);

        System.out.println("-----");

        //3. sort(List<?> list, Comparator<? super T> c) : sort LIST
        Collections.sort(letters, (o1, o2) -> o1.charAt(0) - o2.charAt(0));
        System.out.println(letters);
    }
}
