import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Lab39Server {
    public static void main(String[] args) {
        final int PORT = 1313; // Custom daytime port (RFC suggests 13, but it may be reserved)

        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.println("UDP Daytime Server is running on port " + PORT);

            byte[] receiveBuffer = new byte[1]; // Expecting any small trigger

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket); // Wait for a request

                // Get current date and time
                String currentTime = LocalDateTime.now()
                        .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

                byte[] sendBuffer = currentTime.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(
                        sendBuffer,
                        sendBuffer.length,
                        receivePacket.getAddress(),
                        receivePacket.getPort()
                );

                serverSocket.send(sendPacket);
                System.out.println("Sent time to " + receivePacket.getAddress());
            }

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }

}
