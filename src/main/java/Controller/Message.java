package Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author sanaz
 */
public class Message {
    private Socket socket;

    public Message(Socket socket) {
        this.socket = socket;
    }

    public void messageHandler() {
        try (
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader consoleIn = new BufferedReader(new InputStreamReader(System.in))
        ) {
            Thread clientHandler = new Thread(() -> {
                handleClientMessages(in);
            });
            clientHandler.start();

            handleServerMessages(out, consoleIn);

        } catch (IOException e) {
            System.out.println("I/O error: " + e.getMessage());
        }
    }

    private void handleClientMessages(BufferedReader in) {
        String message;
        try {
            while ((message = in.readLine()) != null) {
                System.out.println("Client: " + message);
            }
        } catch (IOException e) {
            System.out.println("Connection closed.");
        }
    }

    private void handleServerMessages(PrintWriter out, BufferedReader consoleIn) throws IOException {
        String serverMessage;
        while ((serverMessage = consoleIn.readLine()) != null) {
            out.println(serverMessage);
        }
    }
}
