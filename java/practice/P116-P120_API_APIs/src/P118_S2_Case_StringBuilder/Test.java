package P118_S2_Case_StringBuilder;

import java.util.Objects;

public class Test {
    public static void main(String[] args) {
        System.out.println(returnAnIntArray(new int[]{1, 2, 3, 4, 5}));
    }

    public static String returnAnIntArray(int[] arr) {
        if (Objects.isNull(arr)) return null;

        StringBuilder sb = new StringBuilder("[");

        for (int i = 0; i < arr.length - 1; i++) {
            sb.append(arr[i]).append(", ");
        }
        sb.append(arr[arr.length - 1]).append("]");

        return sb.toString();
    }
}
