import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Receiver {
    public static void main(String[] args) throws IOException{
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ip(127.0.0.1) and port(133) ");

        Socket client = new Socket(scanner.nextLine(),scanner.nextInt());
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(client.getInputStream()));
        FileWriter writer = new FileWriter("catsFromSender.txt", false);

        String line;
        do{
            line = bufferedReader.readLine();
            System.out.println(line);
            writer.write(line+"\n");
            writer.flush();
        }while (line!=null);

        client.close();
        writer.close();
    }
}
