
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class Lab27Client{

    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 12345); BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println("Current Date and Time: " + in.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
