package P188_TCP_MultipleToMultipleCommunication_Receive;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ServerReaderThread extends Thread {
    private Socket client;

    public ServerReaderThread(Socket client) {
        this.client = client;
    }

    public ServerReaderThread() {}

    @Override
    public void run() {
        InputStream is = null;
        try {
            is = client.getInputStream();
            DataInputStream dis = new DataInputStream(is);

            while (true) {
                try {
                    String rs = dis.readUTF(); //if client quits, exception will occur here, we catch the exception and close the Socket and Stream
                    System.out.println(client.getRemoteSocketAddress() + "--->" + rs);
                    System.out.println("----------");
                } catch (Exception e) {
                    System.out.println(client.getRemoteSocketAddress() + " is offline!");
                    System.out.println("----------");
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
