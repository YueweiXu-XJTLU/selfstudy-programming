package P200_S5_RegistrationAndLogin;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    //use a .properties file which store <k, v>
    //use a constant for its path
    public static final String FILE_PATH = "YOUR_USERS_PROPERTIES_FILE";

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8888); //initialize the unique socket for server
            while (true) {
                //endlessly receive clients, each use a new thread for processing
                Socket socket = serverSocket.accept();
                new ServerReaderThread(socket).start();  //receive the socket of the server
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
