package P189_Case_InstantMessaging_GroupChat;

import java.io.*;
import java.net.Socket;

public class ClientReaderThread extends Thread {
    private Socket client;

    public ClientReaderThread(Socket client) {
        this.client = client;
    }

    public ClientReaderThread() {}

    @Override
    public void run() {
        try {
            InputStream is = client.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            while (true) {
                try {
                    String rs = dis.readUTF();
                    System.out.println(rs);
                    System.out.println("----------");
                } catch (Exception e) {
                    Server.onlineClients.remove(client);
                    System.out.println("Offline!");
                    System.out.println("==========");
                    dis.close();
                    client.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
