import java.net.DatagramSocket;
import java.net.InetAddress;

public class Lab36 {
    public static void main(String[] args) {
        try {
            // Create a UDP socket and bind to port 0 (automatically assigned)
            DatagramSocket socket = new DatagramSocket();

            // Display UDP socket information
            System.out.println("UDP Socket Information:");
            System.out.println("Local Port: " + socket.getLocalPort());
            System.out.println("Local Address: " + socket.getLocalAddress());

            // Check if socket is bound and connected
            System.out.println("Is Bound: " + socket.isBound());
            System.out.println("Is Connected: " + socket.isConnected());

            // Connect to a remote address (optional)
            InetAddress remoteAddress = InetAddress.getByName("8.8.8.8");
            int remotePort = 53; // DNS port
            socket.connect(remoteAddress, remotePort);

            // After connecting
            System.out.println("After connecting to 8.8.8.8:53");
            System.out.println("Remote Address: " + socket.getInetAddress());
            System.out.println("Remote Port: " + socket.getPort());

            // Close the socket
            socket.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
