package P187_S2_TCP_OneToOneCommunication_Receive;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Test {
    public static void main(String[] args) throws Exception {
        //Constructor:
        //public ServerSocket(int port)
        ServerSocket server = new ServerSocket(8888);
        System.out.println("A server has been started!");

        //Methods:
        //public Socket accept()
        Socket fromClient = server.accept();//server will wait here util connection and receive a Socket Object from client

        //public InputStream getInputStream()
        InputStream is = fromClient.getInputStream();
        
        //public SocketAddress getRemoteSocketAddress()
        SocketAddress socketAddress = fromClient.getRemoteSocketAddress();

        //Below are IO manipulations
        //better to wrap up the InputStream into a DataInputSteam
        DataInputStream dis = new DataInputStream(is);
        String message = dis.readUTF();

        System.out.println(socketAddress + "--->" + message);

        //!!!Start Server, Then Client!!!
    }
}
