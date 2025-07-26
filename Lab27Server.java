import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
public class Lab27Server {

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Daytime Server started...");
            while (true) {
                try (Socket clientSocket = serverSocket.accept(); PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
                    String dateTime
                            = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    out.println("Current Date and Time: " + dateTime);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
