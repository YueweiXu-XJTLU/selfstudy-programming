package P186_S3_UDP_MultipleToMultipleCommunication_Send;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        DatagramSocket client = new DatagramSocket();
        DatagramPacket p;
        byte[] buffer;
        Scanner sc = new Scanner(System.in);
        String rs;

        while (true) {
            System.out.println("Please enter messages for sending(enter \"exit\" to quit): ");
            rs = sc.nextLine();
            if (rs.equals("exit")) {
                client.close();
                System.out.println("Successfully quit!");
                break; //!!!NEVER FORGET TO CLOSE!!!
            }

            buffer = rs.getBytes();
            p = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 6666);
            client.send(p);
            System.out.println("Successfully sent!");
        }
    }
}
