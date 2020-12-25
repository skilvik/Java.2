package lesson4.sample.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Server {

    public static final int SERVER_PORT = 8080;

    public static void main(String[] args) {
        try(ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
            System.out.println("Waiting...");
            Socket clientSocket1 = serverSocket.accept();
            System.out.println("Client has ben connected!");
            Socket clientSocket = clientSocket1;

            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());

            while (true) {
                String message = in.readUTF();
                System.out.println("message " + message);
                if (message.equals("close")) {
                    break;
                }
                out.writeUTF("Echo " + message);
            }
            System.out.println("Server has been closed");
        } catch (SocketException e) {
            System.err.println("Server port is already opened!");
            e.printStackTrace();
        }
        catch (IOException e) {
            System.err.println("Connection has been closed!");
            e.printStackTrace();
        }
    }
}