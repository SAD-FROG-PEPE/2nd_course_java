import java.io.*;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;

public class Client {

    static String password = "12345";

    public static void main(String[] args) {
        {
            try {

                System.out.println("Client started");
                Socket clientSocket = new Socket("127.0.0.1", 27015);

                System.out.println("Connection to Server....\nYou have 3 tries for password");

                Scanner in = new Scanner(System.in);
                String input = in.nextLine();
                PrintWriter sendToServer = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()));
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

                sendToServer.println("Client input password: " + input);
                sendToServer.flush();
                int count = 1;

                while (!input.equals(password)) {
                    System.out.println("You input wrong password, try again ");
                    input = in.nextLine();
                    sendToServer.println("Client tries break into the server with wrong password");
                    sendToServer.flush();
                    sendToServer.println("Client input password: " + input);
                    sendToServer.flush();
                    count++;
                    if (count == 3 && !input.equals(password)) {
                        System.out.println("Connection denied");
                        sendToServer.println("Connection denied");
                        break;
                    }
                }

                if (input.equals(password)) {
                    sendToServer.println("Connection established");
                    sendToServer.flush();

                    FileWriter writer = new FileWriter("text.txt", false);
                    String line;
                    do {
                        line = bufferedReader.readLine();
                        writer.write(line + "\n");
                        writer.flush();
                    } while ( !line.isEmpty());

                    System.out.println("Client connected to Server\nSend message: ");
                    do {
                        input = in.nextLine();
                        sendToServer.println("Client" + clientSocket.getInetAddress() + ">" + input);
                        sendToServer.flush();
                    } while (!input.equals("quit"));
                }

                clientSocket.close();
                sendToServer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}