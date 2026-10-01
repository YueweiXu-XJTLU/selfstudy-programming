package P186_S1_UDP_OneToOneCommunication_Send;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Test {
    public static void main(String[] args) throws Exception {
        //Constructors:
        //1.for Client (send):
        //public DatagramSocket(): random port
        DatagramSocket client = new DatagramSocket();
        //public DatagramSocket(int port)

        //2.for data package:
        //public DatagramPacket(byte[] buf,int length, InetAddress address, int port): buf: the data to send, in form of byte[]; length: length of data to send inside the byte[]
        byte[] buffer = "This a packet sent from client!".getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, InetAddress.getLocalHost(), 6666);

        //Methods:
        //1.public void send(DatagramPacket p)
        client.send(packet);
        System.out.println("a package has been sent!");

        client.close(); //!!!NEVER FORGET TO CLOSE!!!
    }
}
