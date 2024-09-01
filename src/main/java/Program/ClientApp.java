/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Program;

import java.util.Scanner;
import Controller.Client;
import Controller.Message;
import java.net.Socket;

/**
 *
 * @author sanaz
 */
public class ClientApp {

    /**
     * @param args the command line arguments
     */
    
        static Scanner in = new Scanner(System.in);

    public static void main(String args[]) {

        System.out.println("Welcome to Client chat app");
            System.out.println("Please Enter IP Address : ");
            String ipAddress = in.nextLine();
            System.out.println("Please Enter Port number : ");
            int portNumber = in.nextInt();
            Client client=new Client(ipAddress,portNumber);
            client.startClient();
            Socket socket=client.getSoket();
            Message message = new Message(socket);
            message.messageHandler();
    }
}
