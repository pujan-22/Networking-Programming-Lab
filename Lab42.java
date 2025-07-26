import java.net.DatagramSocket;
import java.net.SocketException;

public class Lab42 {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();

            // Set socket options
            socket.setSoTimeout(3000); // 3 seconds timeout
            socket.setSendBufferSize(8192); // 8 KB send buffer
            socket.setReceiveBufferSize(8192); // 8 KB receive buffer
            socket.setReuseAddress(true); // Enable address reuse
            socket.setBroadcast(true); // Enable broadcast

            // Display the configured options
            System.out.println("UDP Socket Options:");
            System.out.println("SoTimeout: " + socket.getSoTimeout() + " ms");
            System.out.println("Send Buffer Size: " + socket.getSendBufferSize() + " bytes");
            System.out.println("Receive Buffer Size: " + socket.getReceiveBufferSize() + " bytes");
            System.out.println("Reuse Address: " + socket.getReuseAddress());
            System.out.println("Broadcast Enabled: " + socket.getBroadcast());

            socket.close();
        } catch (SocketException e) {
            System.out.println("Socket Error: " + e.getMessage());
        }
    }

}
