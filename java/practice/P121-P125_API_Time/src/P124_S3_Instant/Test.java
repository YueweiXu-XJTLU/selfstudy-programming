package P124_S3_Instant;

import java.time.Instant;

public class Test {
    public static void main(String[] args) {
        //Instant 时间戳
        //Constructor
        Instant i = Instant.now();
        System.out.println(i);

        //get second & nano_second from 1970-01-01 00:00:00
        long epochSecond = i.getEpochSecond();
        int nano = i.getNano();
        System.out.println("EpochSecond: " + epochSecond + " \\\\ " + "Nano: " + nano);

        //other methods are highly similar to LocalDateTime
    }
}
