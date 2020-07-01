package ru.elebedinskiy.java2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) throws IOException {

        Socket socket = connect();

        new Thread(() -> {
            try {
                readInOut(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            try {
                typeMessage(socket);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

    }

    public static Socket connect () throws IOException {
        Socket socket = null;
        ServerSocket serverSocket = new ServerSocket(8189);
        System.out.println("Server is running, waiting for connection ...");
        socket = serverSocket.accept();
        System.out.println("Client connected");
        return socket;
    }

    public static void readInOut (Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        while (true) {
            String str = in.readUTF();
            if (str.equals("/end")) {
                break;
            }
            System.out.println("Message from remote client > " + str);
            out.writeUTF("Echo from server > " + str);
        }
    }

    public static void typeMessage (Socket socket) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        while (true) {
            String str = scanner.nextLine();
            // вот этот if можно удалить
            if (str.equals("/end")) {
                System.out.println("Type message on server is stop!");
                scanner.close();
                break;
            }
            if (str.equals("/exit")) {
                System.out.println("Server shut down !!!");
                out.writeUTF("Server shut down !!!");
                System.exit(0);
            }
            System.out.println("Type on server > " + str);
            out.writeUTF("Type on server > " + str);
        }
    }

}