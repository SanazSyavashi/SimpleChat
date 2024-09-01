/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Controller;


import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author sanaz
 */
public class Server {

    private int portNumber;
    private Socket socket;

     
     public Server(int portNumber){
         this.portNumber=portNumber;
     }

    
     public void startServer(){

        try {
            ServerSocket myCsocket = new ServerSocket(portNumber);
            System.out.println("Server started");
            System.out.println("Waiting for a client ...");
            socket = myCsocket.accept();
           }catch (Exception e) {
            System.out.println("An error occurred while server starting: " + e.getMessage());
        }
        }
     
         public Socket getSoket(){
        return this.socket;
    }
}
    
