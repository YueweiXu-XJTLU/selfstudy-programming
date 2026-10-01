package P186_S4_UDP_MultipleToMultipleCommunication_Receive;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Test {
    public static void main(String[] args) throws Exception {
        DatagramSocket server = new DatagramSocket(6666);
        byte[] buffer = new byte[1024 * 64];
        DatagramPacket p = new DatagramPacket(buffer, buffer.length);
        System.out.println("a server has been started!");

        while (true) {
            server.receive(p);
            String rs = new String(buffer, 0, p.getLength());
            System.out.println(rs);
            System.out.println(p.getAddress() + ":" + p.getPort());
            System.out.println("----------");
        }

        //!!!Start Server, Then Client!!!
    }
}
