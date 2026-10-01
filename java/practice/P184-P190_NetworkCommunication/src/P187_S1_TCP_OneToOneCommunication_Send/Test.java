package P187_S1_TCP_OneToOneCommunication_Send;

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.net.Socket;

public class Test {
    public static void main(String[] args) throws Exception {
        //Constructor:
        //public Socket(String host, int port)
        Socket client = new Socket("127.0.0.1", 8888);

        //Methods:
        //public OutputStream getOutputStream()
        OutputStream os = client.getOutputStream();

        //Below are IO manipulations
        //better to wrap up the OutputStream into a DataOutputSteam
        DataOutputStream dos = new DataOutputStream(os);
        dos.writeUTF("A message from client.");
        System.out.println("A message has been sent!");

        //!!!NEVER FORGET TO CLOSE IOStream & Socket!!!
        dos.close(); //here, os will also be closed automatically
        client.close();
    }
}
