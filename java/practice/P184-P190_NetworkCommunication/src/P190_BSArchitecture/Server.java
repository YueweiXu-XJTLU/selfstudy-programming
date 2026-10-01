package P190_BSArchitecture;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Server {
    public static void main(String[] args) throws Exception {
        //Access through: http://127.0.0.1:8080

        ServerSocket server = new ServerSocket(8080);
        System.out.println("A server has been started!");
        System.out.println("==========");

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(22 * 2, 22 * 2, 0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(8),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());

        while (true) {
            Socket fromWeb = server.accept();

            threadPool.execute( new ServerReaderRunnable(fromWeb));

            System.out.println(fromWeb.getRemoteSocketAddress() + " is online!");
            System.out.println("==========");
        }
    }
}
