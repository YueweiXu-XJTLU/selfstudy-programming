package P189_Case_InstantMessaging_GroupChat;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws Exception {
        //Group Chat: multiple clients -> one server -> multiple clients
        Socket client =  new Socket("127.0.0.1", 8888);

        //A new thread for accept messages
        new ClientReaderThread(client).start();

        OutputStream os = client.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        Scanner sc = new Scanner(System.in);
        while (true) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime ldt = LocalDateTime.now();

            System.out.println("Please enter (enter \"exit\" to quit): ");
            String rs = sc.nextLine();

            if (rs.equals("exit")) {
                client.close();
                dos.close();
                break;
            }

            dos.writeUTF("[" + dtf.format(ldt) + "]" + client.getLocalSocketAddress() + " ---> " + rs);
            dos.flush();
            System.out.println(client.getRemoteSocketAddress() + " successfully send a message!");
        }

    }
}
