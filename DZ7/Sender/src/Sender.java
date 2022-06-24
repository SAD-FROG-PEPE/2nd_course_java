import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Sender {

    public static void main(String[] args) throws IOException {
        System.out.println("Server started");
        ServerSocket serverSocket = new ServerSocket(133);

        ArrayList<Cat> cats = new ArrayList<>();
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(3,10); i++)
            cats.add(new Cat());

        Socket client = serverSocket.accept();
        System.out.println("Connection established");

        while (!client.isClosed()){
            System.out.println("Choose what to send");
            System.out.println("1. One cat\n2. Family of cats\n?. Leave");

            Scanner in = new Scanner(System.in);
            int choose = in.nextInt();
            switch (choose) {
                case 1 -> OneCat(client, cats);
                case 2 -> All(client, cats);
                default-> client.close();
            }
        }
    }

    public static void OneCat(Socket client, ArrayList<Cat> cats) throws IOException {
            System.out.println("Which cat you would like to send? ");
            for (Cat cat : cats)
                System.out.println(cat.getCatName());

            Scanner in = new Scanner(System.in);
            String catName = in.nextLine();

            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            bufferedWriter.write(cats.stream().filter(cat1 -> cat1.getCatName().equals(catName)).findFirst().get().toString());
            bufferedWriter.flush();
    }

    public static void All(Socket client, ArrayList<Cat> cats)throws IOException{
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));

            for (Cat cat:cats) {
                bufferedWriter.write(cat.toString());
                bufferedWriter.flush();
            }
    }

}