package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        int port = 8080;
        try(ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен!");
            while (true) {
                try (Socket clientSocket = serverSocket.accept()) {
                    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                    final String name = in.readLine();
                    out.println(String.format("Hi %s, your port is %d", name, clientSocket.getPort()));
                    out.println("Write your name");
                    String username = in.readLine();
                        out.println(String.format("Are you child? (yes/no)"));
                        String answer = in.readLine();
                        if (answer.equals("yes")) {
                            out.println("Welcome to the kids area, " + username + " Let's play!");

                        } else if (answer.equals("no")) {
                            out.println("Welcome to the adult zone, " + username
                            +" Have a good rest, or a good working day!");

                        } else {
                            out.println("Eror, wrong answer!");
                        }

                } catch (IOException e) {
                    System.err.println("Ошибка подключения: " + e.getMessage());
                }}
            }catch(IOException e){
            System.err.println("Ошибка подключения: " + e.getMessage());
            }
        }
    }