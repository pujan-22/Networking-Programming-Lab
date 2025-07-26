import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Lab44Sniffer {
    public static void main(String[] args) {
        final String GROUP_ADDRESS = "230.0.0.0";
        final int PORT = 4446;

        try (MulticastSocket socket = new MulticastSocket(PORT)) {
            InetAddress group = InetAddress.getByName(GROUP_ADDRESS);
            socket.joinGroup(group);

            System.out.println("Multicast Sniffer started...");
            System.out.println("Listening on group: " + GROUP_ADDRESS + " port: " + PORT);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);

                String received = new String(packet.getData(), 0, packet.getLength());
                String sender = packet.getAddress().getHostAddress();

                System.out.println("Received from " + sender + ": " + received);
            }

        } catch (IOException e) {
            System.err.println("Error in sniffer: " + e.getMessage());
            
        }
    }

}
