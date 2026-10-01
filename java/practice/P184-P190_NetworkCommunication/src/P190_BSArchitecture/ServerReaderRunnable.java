package P190_BSArchitecture;

import java.io.*;
import java.net.Socket;

public class ServerReaderRunnable implements Runnable {
    private Socket web;

    public ServerReaderRunnable(Socket web) {
        this.web = web;
    }

    public ServerReaderRunnable() {}

    @Override
    public void run() {
        try {
            //output sth. throw the website
            OutputStream os = web.getOutputStream();
            PrintStream ps = new PrintStream(os);

            //contents to print must satisfy HTTP Protocol
            ps.println("HTTP/1.1 200 OK");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println(); //must separate by a new line
            ps.println("<div style='color:blue;font-size:120px;text-align:center'>666xyw666<div>");

            //website connection: short connection: close/finish after an input + output
            ps.close();
            web.close();
            System.out.println(web.getRemoteSocketAddress() + " is offline!");
            System.out.println("==========");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
