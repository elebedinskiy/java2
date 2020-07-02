package ru.elebedinskiy.java2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServer {

    public static void main(String[] args) {

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

    public static Socket connect () {
        Socket socket = null;
        try (ServerSocket serverSocket = new ServerSocket(8189)){
            System.out.println("Сервер запущен, ожидается подключение клиента ...");
            socket = serverSocket.accept();
            System.out.println("Клиент подключился");
        } catch (IOException e){
            e.printStackTrace();
        }
        return socket;
    }

    public static void readInOut (Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        while (true) {
            String str = in.readUTF();
            // предусмотрим завершение сервера с клиента
            if (str.equals("/exit")) {
                System.out.println("Работа сервера завершена!");
                out.writeUTF("/exit");
                System.exit(0);
            }
            System.out.println("Клиент > " + str);
            out.writeUTF("Сервер Эхо > " + str);
            out.flush();
        }
    }

    public static void typeMessage (Socket socket) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        while (true) {
            String str = scanner.nextLine();
            // предусмотрим завершение сервера с сервера
            if (str.equals("/exit")) {
                System.out.println("Работа сервера завершена!");
                out.writeUTF("/exit");
                System.exit(0);
            }
            System.out.println("Сервер > " + str);
            out.writeUTF("Сервер > " + str);
            out.flush();
        }
    }

}