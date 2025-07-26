
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Lab43Receiver {

    public static void main(String[] args) {
        final String MULTICAST_IP = "230.0.0.0";
        final int PORT = 4446;

        try (MulticastSocket socket = new MulticastSocket(PORT)) {
            InetAddress group = InetAddress.getByName(MULTICAST_IP);
            socket.joinGroup(group);

            System.out.println("Joined multicast group. Waiting for messages...");

            byte[] buffer = new byte[1024];
            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String message = new String(packet.getData(), 0, packet.getLength());
                System.out.println("Received: " + message);
            }

            // socket.leaveGroup(group); // You can leave the group if needed
        } catch (Exception e) {
            System.out.println("Receiver Error: " + e.getMessage());
        }
    }

}
