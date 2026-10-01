package S5_Cases;

public class P67_S1_PrintMultiplicationTable {
    public static void main(String[] args) {
        for (int right = 1; right <= 9 ; right++) {
            for (int left = 1; left <= right ; left++) {
                System.out.print(left + "*" + right + "=" + (left*right) + "\t"); //use "\t" instead of " " to avoid mal position(错位) cause by different digits of numbers
            }
            System.out.println();
        }
    }
}
