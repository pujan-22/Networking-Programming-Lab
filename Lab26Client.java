import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Lab26Client {

    public static void main(String[] args) {
        String host = "127.0.0.1"; // Server address
        int port = 65432; // Server port
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in))) {
            
            System.out.println("Connected to server at " + host + ":" + port);
            String userInput;
            while (true) {
                System.out.print("Enter message to send (or 'exit' to quit): ");
                userInput = stdIn.readLine();
                if (userInput.equalsIgnoreCase("exit")) {
                    break;
                }
                out.println(userInput); // Send message to server
                String response = in.readLine(); // Read response from server
                System.out.println("Received from server: " + response);
            }
        } catch (IOException e) {
            System.out.println("Error connecting to server: " + e.getMessage());
        }
    }

}
