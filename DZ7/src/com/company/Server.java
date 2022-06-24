package com.company;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;
import java.util.Objects;

public class Server {
    public static String filename="test.txt";
    static String password="12345";

    public static void main(String[] args) {
        createFile();

        try {
            System.out.println("Server started");
            ServerSocket serverSocket = new ServerSocket(27015);

            int countOfClients=0;
            while (countOfClients!=5) {
                System.out.println("Waiting for connection");
                Socket client = serverSocket.accept();
                System.out.println("Client: "+client.getInetAddress() + " trying to connect");

                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

                String lines;
                do{
                    lines = bufferedReader.readLine();
                    System.out.println(lines);

                    if (Objects.equals(lines, "Client input password: "+password))
                    {
                        String file = new String(Files.readAllBytes(Paths.get(filename)));
                        bufferedWriter.write(file);
                        bufferedWriter.flush();
                    }
                } while (lines!= null);

                countOfClients++;
            }
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createFile(){
        try (FileWriter writer = new FileWriter(filename, false)){
            writer.write("""
                    Не знаю что написать, поэтому напишу рецепт голубцов.
                    Капуста - 1 кочан
                    Рис - 200 г
                    Фарш мясной - 500 г
                    Соль - 1 ч. ложка
                    Приправа - 1 ч. ложка (по вкусу)
                    Перец черный молотый - по вкусу
                    Масло растительное - для жарки
                    Для соуса:
                    Сметана - 2 ч. ложки
                    Томатная паста или кетчуп - 2 ч. ложки
                    Приправа - 1 ч. ложка (по вкусу)
                    Соевый соус - 1 ч. ложка
                    Соль - 0,5 ч. ложки
                    Вода - 0,5-0,75 стакана
                    
                    """+new Date());
            System.out.println("File is ready to be send");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}