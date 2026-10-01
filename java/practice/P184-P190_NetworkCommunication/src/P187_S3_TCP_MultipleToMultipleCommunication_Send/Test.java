package P187_S3_TCP_MultipleToMultipleCommunication_Send;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) throws Exception {
        Socket client = new Socket("127.0.0.1", 8888);
        OutputStream os = client.getOutputStream();
        DataOutputStream dos = new DataOutputStream(os);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please enter (enter \"exit\" to quit): ");
            String msg = sc.nextLine();

            if (msg.equals("exit")) {
                dos.close();
                client.close();
                System.out.println("Successfully quit!");
                break;
            }

            dos.writeUTF(msg);
            dos.flush(); //refresh the stream
            System.out.println("A message has been sent!");
            System.out.println("==========");
        }

    }
}
