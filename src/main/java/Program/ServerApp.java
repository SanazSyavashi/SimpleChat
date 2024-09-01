/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package Program;

import java.util.Scanner;
import Controller.*;
import java.net.Socket;

/**
 *
 * @author sanaz
 */
public class ServerApp {

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Server chat app");
        System.out.println("Please Enter Port number : ");
        int portNumber = in.nextInt();
        Server server = new Server(portNumber);
        server.startServer();
        Socket socket = server.getSoket();
        Message message = new Message(socket);
        message.messageHandler();
    }
}
