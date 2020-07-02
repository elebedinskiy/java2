package ru.elebedinskiy.java2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {

    private final String SERVER_ADRESS = "localhost";
    private final int SERVER_PORT = 8189;
    private static Socket socket;

    public EchoClient() {
        try {
            socket = new Socket(SERVER_ADRESS, SERVER_PORT);
            System.out.println("Клиент запущен. Соединение установлено.");
        } catch (IOException e) {
            System.out.println("В соединении отказано. Программа завершена.");
            //e.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new EchoClient();

        new Thread(()->{
            try {
                readIn(socket);
            } catch (IOException | NullPointerException e) {
                //e.printStackTrace();
            }
        }).start();

        new Thread(()-> {
            try {
                typeMessage(socket);
            } catch (IOException | NullPointerException e) {
                //e.printStackTrace();
            }
        }).start();

    }

    public static void readIn (Socket socket) throws IOException {
        DataInputStream in = new DataInputStream(socket.getInputStream());
        while (true) {
            String messageFromServer = in.readUTF();
            // обработаем выключение сервера
            if (messageFromServer.equals("/exit")) {
                System.out.println("Работа сервера завершена. Клиент закрыт.");
                System.exit(0);
            }
            System.out.println(messageFromServer);
        }
    }

    public static void typeMessage (Socket socket) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        while (true) {
            String message = scanner.nextLine();
            out.writeUTF(message);
            out.flush();
        }
    }

}