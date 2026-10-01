package P135_DealWithExceptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test2 {
    public static void main(String[] args) {
        //ways to deal with exceptions
        //Firstly: throw to upper level (level by level); try-catch in the highest level(class/method)
        //Then: 2. allow for repair
        while (true) {
            try {
                System.out.println(getPrice());
                break;
            } catch (Exception e) {
                System.out.println("Please enter a number");
            }
        }
    }

    public static double getPrice() throws Exception {
        Scanner scanner = new Scanner(System.in);
        double price;
        while (true) {
            System.out.println("Enter price:");
            price = scanner.nextDouble();
            scanner.nextLine();
            if (price > 0.0) {
                return price;
            } else {
                System.out.println("Invalid price");
            }
        }
    }
}