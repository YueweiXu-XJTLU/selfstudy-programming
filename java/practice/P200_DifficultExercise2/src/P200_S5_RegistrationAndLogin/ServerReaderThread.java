package P200_S5_RegistrationAndLogin;

import java.io.*;
import java.net.Socket;
import java.util.Properties;

public class ServerReaderThread extends Thread {
    private Socket socket;

    public ServerReaderThread(Socket socket) {
        this.socket = socket; //receive the socket of the server
    }

    @Override
    public void run() {
        try {
            //1.initialize the stream
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            //2.operation menu
            While:
            while (true) {
                //use a pre-input of an Int to judge the task
                int task = dis.readInt();

                Switch:
                switch (task) {
                    case 1: //registration
                        registration();
                        break Switch;
                    case 2: //login
                        login();
                        break Switch;
                }
            }

        } catch (Exception e) {
            //offLine
            try {
                System.out.println("Someone has been offline!");
                socket.close();
            } catch (Exception ex) {
                e.printStackTrace();
            }

        }
    }

    private void login() throws Exception {
        //1.receive data
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String userName = dis.readUTF();
        String password = dis.readUTF();

        //2.receive file
        File file = new File(Server.FILE_PATH);
        Properties properties = new Properties();
        properties.load(new FileReader(file));

        //normal response
        String rs = "Login Success!";

        //not-null check of the file
        if (properties.size() == 0) {
            rs = "No User yet!";

            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF((rs + "\n" + "===================="));
            dos.flush();

            return;
        }

        //validity judgment
        String OKPassword = properties.getProperty(userName);
        if (OKPassword == null) {
            rs = "User does not exist!";
        } else if (!OKPassword.equals(password)) {
            rs = "Wrong Password!";
        }

        //3.respond to client
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF((rs + "\n" + "===================="));
        dos.flush();
    }

    private void registration() throws Exception {
        //1.receive data
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        String userName = dis.readUTF();
        String password = dis.readUTF();

        //2.receive file
        File file = new File(Server.FILE_PATH);
        Properties properties = new Properties();
        properties.load(new FileReader(file));

        //normal response
        String rs = "Registration Success!";

        //replication judgment
        if (properties.containsKey(userName)) {
            rs = "Registration Fail (Replicated Username)!";
        } else {
            //save new user
            properties.setProperty(userName, password);
            properties.store(new FileWriter(Server.FILE_PATH, true), ""); //use "true" to append users inside the .properties file
        }

        //3.respond to client
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeUTF((rs + "\n" + "===================="));
        dos.flush();
    }
}
