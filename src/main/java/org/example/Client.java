package org.example;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public class Client {
    public static void main(String[] args) {

        String host = "localhost";
        int port = 8080;
        Scanner console = new Scanner(System.in);
        try (Socket socket = new Socket(host, port)) {
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out.println("Ваше имя");
            String response = in.readLine();
            System.out.println("Ответ от сервера: " + response);
            String name = in.readLine();
            System.out.println("Ответ от сервера: " + name);
            String clientName = console.nextLine();
            out.println(clientName);
            System.out.println(in.readLine());
            String kids = console.nextLine();
            out.println(kids);
            System.out.println(in.readLine());
        } catch (IOException e) {
            System.err.println("Ошибка подключения: " + e.getMessage());
        }
    }
}
