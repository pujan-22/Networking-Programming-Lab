import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class Lab32 {
    public static void main(String[] args) {
        String host = "google.com"; // or use your test server
        int port = 80;

        try (Socket socket = new Socket()) {
            // Set a connection timeout of 5 seconds
            socket.connect(new InetSocketAddress(host, port), 5000);

            // Set socket options
            socket.setSoTimeout(3000); // Read timeout (milliseconds)
            socket.setTcpNoDelay(true); // Disable Nagle's algorithm for low-latency
            socket.setKeepAlive(true); // Enable keep-alive packets
            socket.setReuseAddress(true); // Allow address reuse
            socket.setSendBufferSize(8192); // Set send buffer size
            socket.setReceiveBufferSize(8192); // Set receive buffer size

            // Print out the socket settings
            System.out.println("Connected to: " + socket.getRemoteSocketAddress());
            System.out.println("SO_TIMEOUT: " + socket.getSoTimeout());
            System.out.println("TCP_NO_DELAY: " + socket.getTcpNoDelay());
            System.out.println("KEEP_ALIVE: " + socket.getKeepAlive());
            System.out.println("REUSE_ADDRESS: " + socket.getReuseAddress());
            System.out.println("SEND_BUFFER_SIZE: " + socket.getSendBufferSize());
            System.out.println("RECEIVE_BUFFER_SIZE: " + socket.getReceiveBufferSize());

        } catch (IOException e) {
            System.out.println("Socket error: " + e.getMessage());
        }
    }

}
