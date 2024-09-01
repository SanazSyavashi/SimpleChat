/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

package Controller;


import java.net.Socket;
/**
 *
 * @author sanaz
 */



public class Client {

     private String ipAddress;
     private int portNumber;
     private Socket socket;
     
     public Client(String ipAddress,int portNumber){
         this.ipAddress=ipAddress;
         this.portNumber=portNumber;
     }

    public  void startClient() {
        try {
            socket = new Socket(ipAddress, portNumber);
            System.out.println("Connected to Server");
           
        } catch (Exception e) {
            System.out.println("An error occurred while connecting to the server: " + e.getMessage());
        }

    }
    
    public Socket getSoket(){
        return this.socket;
    }
}

