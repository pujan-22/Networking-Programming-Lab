import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Lab43Sender {
    public static void main(String[] args) {
        final String MULTICAST_IP = "230.0.0.0";
        final int PORT = 4446;

        try (MulticastSocket socket = new MulticastSocket()) {
            String message = "Hello, Multicast Group!";
            byte[] buffer = message.getBytes();

            InetAddress group = InetAddress.getByName(MULTICAST_IP);
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length, group, PORT);

            socket.send(packet);
            System.out.println("Message sent to multicast group: " + message);
        } catch (Exception e) {
            System.out.println("Sender Error: " + e.getMessage());
        }
    }

}
