package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket socket = null;
    private int stopped=0;
    public ClientThread(Socket socket) {
        this.socket = socket;
    }
    public void run(){
        try {
            // Get the request from the input stream: client → server
            while(stopped == 0) {
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String request = in.readLine();
                System.out.println("Client sent the request: " + request);

                //Send the response to the oputput stream: server → client
                PrintWriter out = new PrintWriter(socket.getOutputStream());
                String response = "Server received the request ..." + request;
                if(request.equals("exit")) {
                    stopped = 1;
                    System.out.println("Client stopped");
                }
                else if(request.equals("stop")){
                    response = "Server stopped";
                    //stop only the current thread
                    /*this.socket.close();*/
                    stopped=1;
                    System.out.println("Server stopped by client");
                    //stop the server
                    GameServer.serverSocket.close();
                }
                out.println(response);
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        }finally {
            try{
                socket.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }

}
