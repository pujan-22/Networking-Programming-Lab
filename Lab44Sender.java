import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Lab44Sender {
    public static void main(String[] args) {
        final String GROUP_ADDRESS = "230.0.0.0";
        final int PORT = 4446;

        try (MulticastSocket socket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(GROUP_ADDRESS);
            String message = "Test message from sender";

            DatagramPacket packet = new DatagramPacket(
                    message.getBytes(), message.length(), group, PORT);

            socket.send(packet);
            System.out.println("Sent message to multicast group");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
