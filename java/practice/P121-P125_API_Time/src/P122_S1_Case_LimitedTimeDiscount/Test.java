package P122_S1_Case_LimitedTimeDiscount;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws ParseException {
        String str_start = "2025-01-01 00:00:00";
        String str_finish = "2025-01-01 00:10:00";
        String str_customer1 ="2025-01-01 00:05:00";
        String str_customer2 = "2025-01-01 00:10:01";

        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");

        Date date_start = sdf.parse(str_start);
        Date date_finish = sdf.parse(str_finish);
        Date date_customer1 = sdf.parse(str_customer1);
        Date date_customer2 = sdf.parse(str_customer2);

        long long_start = date_start.getTime();
        long long_finish = date_finish.getTime();
        long long_customer1 = date_customer1.getTime();
        long long_customer2 = date_customer2.getTime();

        if (long_customer1 >= long_start && long_customer1 <= long_finish) {
            System.out.println("Customer1: Success!");
        } else {
            System.out.println("Customer1: Failed!");
        }

        if (long_customer2 >= long_start && long_customer2 <= long_finish) {
            System.out.println("Customer2: Success!");
        } else {
            System.out.println("Customer2: Failed!");
        }
    }
}
