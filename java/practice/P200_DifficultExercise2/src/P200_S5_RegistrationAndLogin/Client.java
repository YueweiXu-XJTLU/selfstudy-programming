package P200_S5_RegistrationAndLogin;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private static Socket socket; //make it a global variable for easy invoke in all methods inside the class
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        try {
            Client.start(); //each client use a unique socket and a unique thread
        } catch (Exception e) {
            e.printStackTrace(); //all thrown exceptions below will be printed here
        }
    }

    private static void start() throws Exception {
        //initialize the sockey
        socket = new Socket("127.0.0.1", 8888);

        //operation menu
        While:
        while (true) {
            System.out.println("Enter \"1\" for registration;");
            System.out.println("Enter \"2\" for login;");
            System.out.println("Enter \"3\" for exit:");
            Switch:
            switch (sc.nextLine()) {
                case "1":
                    registration();
                    break Switch;
                case "2":
                    login();
                    break Switch;
                case "3":
                    System.out.println("Bye!");
                    System.out.println("====================");
                    socket.close();
                    break While;
                default:
                    System.out.println("Invalid Input!");
                    System.out.println("====================");
                    break Switch;
            }
        }


    }

    private static void login() throws Exception {
        //1.ask for input
        System.out.println("Give your user name:");
        String userName = sc.nextLine();

        System.out.println("Give your password:");
        String password = sc.nextLine();

        //2.send to server
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(2); //denote task "login" for server
        dos.writeUTF(userName);
        dos.writeUTF(password);
        dos.flush();

        //3.wait and get response from server immediately
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        System.out.println(dis.readUTF()); //progress will wait here util get response
    }

    private static void registration() throws Exception {
        //1.ask for input
        System.out.println("Create your user name:");
        String userName = sc.nextLine();

        System.out.println("Create your password:");
        String password = sc.nextLine();

        //2.send to server
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        dos.writeInt(1); //denote task "registration" for server
        dos.writeUTF(userName);
        dos.writeUTF(password);
        dos.flush();

        //3.wait and get response from server immediately
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        System.out.println(dis.readUTF()); //progress will wait here util get response
    }
}
