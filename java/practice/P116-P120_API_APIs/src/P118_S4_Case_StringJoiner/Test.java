package P118_S4_Case_StringJoiner;

import java.util.Objects;
import java.util.StringJoiner;

public class Test {
    public static void main(String[] args) {
        System.out.println(returnAnIntArray(new int[]{1, 2, 3, 4, 5}));
    }

    public static String returnAnIntArray(int[] arr) {
        if (Objects.isNull(arr)) return null;

        StringJoiner sj = new StringJoiner(", ", "[", "]");

        for (int i = 0; i < arr.length; i++) {
            sj.add(arr[i] + "");
        }

        return sj.toString();
    }
}

