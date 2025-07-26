import java.io.IOException;
import java.net.ServerSocket;
import java.net.SocketException;

public class Lab33 {
    public static void main(String[] args) {
        int port = 6000;

        try (ServerSocket serverSocket = new ServerSocket()) {
            // Set server socket options before binding
            serverSocket.setReuseAddress(true);  // Allow address reuse
            serverSocket.setReceiveBufferSize(8192); // Set receive buffer size

            // Bind to port after setting options
            serverSocket.bind(new java.net.InetSocketAddress(port));

            System.out.println("Server socket started on port " + port);

            // Print socket options
            System.out.println("SO_REUSEADDR: " + serverSocket.getReuseAddress());
            System.out.println("RECEIVE_BUFFER_SIZE: " + serverSocket.getReceiveBufferSize());
            System.out.println("BOUND: " + serverSocket.isBound());
            System.out.println("CLOSED: " + serverSocket.isClosed());

            // Wait for client (just accept one for demonstration)
            System.out.println("Waiting for a client...");
            serverSocket.accept(); // This blocks until client connects

        } catch (SocketException se) {
            System.out.println("SocketException: " + se.getMessage());
        } catch (IOException e) {
            System.out.println("IOException: " + e.getMessage());
        }
    }

}
