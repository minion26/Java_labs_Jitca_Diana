package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class GameServer {
    public static final int PORT = 8100;
    public static ServerSocket serverSocket = null;

    public GameServer() throws IOException {

        try {
            //try to open a server socket on port 8100
            serverSocket = new ServerSocket(PORT);
            while(true) {
                System.out.println("Waiting for a client ...");
                //wait for a connection from the client
                Socket socket = serverSocket.accept();
                //execute the client's request in a new thread
                new ClientThread(socket).start();
                /*if(socket.isClosed())
                    break;*/
            }
        } catch (Exception e) {
            System.err.println("Ooops... " + e);
        } finally {
            serverSocket.close();
        }

    }
}
