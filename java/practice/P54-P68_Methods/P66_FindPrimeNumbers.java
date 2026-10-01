package S5_Cases;

public class P66_FindPrimeNumbers {
    public static void main(String[] args) {
        System.out.println(findPrimeNumbers1(100, 201));
        System.out.println(findPrimeNumbers2(100, 201));
    }

    public static int findPrimeNumbers1(int min, int max) {
        boolean isPrime = true;
        int count = 0;
        for (int i = min; i <= max; i++) {
            isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                count++;
            }
        }
        return count;
    }

    public static int findPrimeNumbers2(int min, int max) {
        int count = 0;

        OuterLoop: //Name the loop
        for (int i = min; i <= max; i++) {

            InnerLoop:
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue OuterLoop; //"continue" used for the named "OuterLoop"
                }
            }

            count++;
        }
        return count;
    }
}
