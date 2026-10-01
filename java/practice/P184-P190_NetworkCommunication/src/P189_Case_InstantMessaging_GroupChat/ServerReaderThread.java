package P189_Case_InstantMessaging_GroupChat;

import java.io.*;
import java.net.Socket;

public class ServerReaderThread extends Thread {
    private Socket client;

    public ServerReaderThread(Socket client) {
        this.client = client;
    }

    public ServerReaderThread() {}

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

                    //Port Forwarding 端口转发
                    sendMessageToALl(rs);
                } catch (Exception e) {
                    Server.onlineClients.remove(client);
                    System.out.println(client.getRemoteSocketAddress() + " is offline!");
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

    private void sendMessageToALl(String rs) throws Exception {
        for (Socket onlineClient : Server.onlineClients) {
            OutputStream osTemp = onlineClient.getOutputStream();
            DataOutputStream dosTemp = new DataOutputStream(osTemp);
            dosTemp.writeUTF(rs);
            dosTemp.flush();
        }
    }
}
