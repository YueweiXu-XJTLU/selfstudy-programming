package P186_S2_UDP_OneToOneCommunication_Receive;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Test {
    public static void main(String[] args) throws Exception {
        //Constructors:
        //1.for Server (receive):
        //public DatagramSocket(int port)
        DatagramSocket server = new DatagramSocket(6666);
        System.out.println("a server has been started!");

        //2.for data package:
        //public DatagramPacket(byte[] buf,int length): buf: the container to receive data, in form of byte[]; length: length of data to receive
        byte[] buffer = new byte[1024 * 64]; //a package's maximum size is 64kb
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        //Methods:
        //1.public void receive(DatagramPacket p)
        server.receive(packet); //program with wait here until receive package

        //2.public int getLength()
        String result = new String(buffer, 0, packet.getLength());
        System.out.println(result);

        //3.public InetAddress getAddress() & public int getPort(): get address and port of the client:
        System.out.println(packet.getAddress());
        System.out.println(packet.getPort());

//        server.close(); //server usually has no need to close

        //!!!Start Server, Then Client!!!
    }
}
