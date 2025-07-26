import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Lab31Client {
    public static void main(String[] args) {
        String host = "localhost";
        int port = 5001;

        try (
            Socket socket = new Socket(host, port);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            System.out.print("Enter a number to check if it is prime: ");
            String number = userInput.readLine();
            out.println(number); // send to server

            String response = in.readLine(); // receive response
            System.out.println("Server: " + response);

        } catch (IOException e) {
            System.out.println("Client error: " + e.getMessage());
        }
    }

}
