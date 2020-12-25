package lesson4.sample.homework;

import lesson4.sample.server.Server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class HWServer {

    private static final int PORT = 8080;

    public static void main(String[] args) throws IOException {
        int port = PORT;
        if (args.length != 0) {
            port = Integer.parseInt(args[0]);
        }
        new HWServer().start(port);
    }

    public void start(int port) throws IOException {
        ServerSocket socket = null;
        Socket clientSocket= null;
        Thread inputThread = null;
        try {
            socket = new ServerSocket(port);
            System.out.println("Сервер запущен");
            clientSocket = socket.accept();
            System.out.println("Клиент подключен");
            DataInputStream in = new DataInputStream(clientSocket.getInputStream());
            DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
            inputThread = runInputThread(in);
            runOutputLoop(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (inputThread != null) inputThread.interrupt();
            if (clientSocket != null) clientSocket.close();
            if (socket != null) socket.close();
        }
    }

    private void runOutputLoop(DataOutputStream out) throws IOException {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.next();
            out.writeUTF(message);
            if (message.equals("/close")) {
                break;
            }
        }
    }

    private Thread runInputThread(DataInputStream in) {
        Thread thread = new Thread(() -> {
            while (!Thread.currentThread().isInterrupted()) {
                try {
                    String message = in.readUTF();
                    System.out.println("From client: " + message);
                    if (message.equals("/close")) {
                        System.exit(0);
                    }
                } catch (IOException e) {
                    System.out.println("Connection was closed");
                    break;
                }
            }
        });
        thread.start();
        return thread;
    }
}

