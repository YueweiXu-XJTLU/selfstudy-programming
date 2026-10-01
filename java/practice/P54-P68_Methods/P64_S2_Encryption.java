package S5_Cases;

import java.util.Scanner;

public class P64_S2_Encryption {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter password:");
        int password = sc.nextInt();
        sc.nextLine();
        System.out.println(encryption(password));
    }

    public static String encryption(int password) {
        //split code
        int[] array = splitCode(password);

        //encryption
        for (int i = 0; i < array.length; i++) {
            array[i] += 5;
            array[i] %= 10;
        }

       //get reverse array
       int[] reversedArray = reverse(array);

       //get encrypted code
       String encryptedPassword = new String();
        for (int i = 0; i < reversedArray.length; i++) {
            encryptedPassword += reversedArray[i];
        }

        //return
        return encryptedPassword;
    }

    public static int[] splitCode(int password) {
        int[] array = new int[4];
        array[3] = password % 10;
        for (int i = array.length - 2; i >= 0; i--) {
            password /= 10;
            array[i] = password % 10;
        }
        return array;
    }

    public static int[] reverse(int[] array) {
        int temp = 0;
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }

}
