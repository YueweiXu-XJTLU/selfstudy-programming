package P189_Case_InstantMessaging_GroupChat;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    public static List<Socket> onlineClients = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        //Group Chat: multiple clients -> one server -> multiple clients

        ServerSocket server = new ServerSocket(8888);
        System.out.println("A server has been started!");
        System.out.println("==========");

        while (true) {
            Socket fromClient = server.accept();
            new ServerReaderThread(fromClient).start();
            onlineClients.add(fromClient);
            System.out.println(fromClient.getRemoteSocketAddress() + " is online!");
            System.out.println("==========");
        }
    }
}
