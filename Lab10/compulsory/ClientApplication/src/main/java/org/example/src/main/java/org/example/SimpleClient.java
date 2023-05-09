package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class SimpleClient {
    public static void main(String[] args) {
        String serverAddress = "127.0.0.1";
        int PORT = 8100;
        int stopped=0;
        Scanner scanner = new Scanner(System.in);
        try{
            while(stopped == 0) {
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                //the client writes something
                String request = scanner.nextLine();
                out.println(request);
                if(request.equals("exit"))
                    stopped=1;

                String response = in.readLine();
                System.out.println(response);
            }
            System.out.println("Server stopped");
        } catch (IOException e) {
            System.err.println("No server listening... " + e);
        }
    }
}
