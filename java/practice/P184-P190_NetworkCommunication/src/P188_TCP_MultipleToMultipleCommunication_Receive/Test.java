package P188_TCP_MultipleToMultipleCommunication_Receive;

import java.net.ServerSocket;
import java.net.Socket;

public class Test
{
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8888);
        System.out.println("A server has been started!");

        //As TCP communication requires connection, we use multiple-threads to fulfill multiple clients communication
        while (true) {
            Socket fromClient = server.accept();
            System.out.println(fromClient.getRemoteSocketAddress() + " is online!");
            System.out.println("----------");
            new ServerReaderThread(fromClient).start(); //after the thread start, the loop will execute again to wait for accepting a new client
        }

        //!!!Start Server, Then Client!!!
    }
}
