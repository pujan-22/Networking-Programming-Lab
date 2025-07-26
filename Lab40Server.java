import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Lab40Server {
    public static void main(String[] args) {
        final int PORT = 4445;

        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            byte[] buffer = new byte[1024];

            System.out.println("UDP Text Server is running on port " + PORT);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(receivePacket); // Wait for client message

                String message = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Client says: " + message);

                if (message.equalsIgnoreCase("exit")) {
                    System.out.println("Client ended the chat.");
                    break;
                }

                // Optional: You could echo the message back or reply something
                String reply = "Server received: " + message;
                byte[] replyBytes = reply.getBytes();

                DatagramPacket replyPacket = new DatagramPacket(
                        replyBytes,
                        replyBytes.length,
                        receivePacket.getAddress(),
                        receivePacket.getPort()
                );

                serverSocket.send(replyPacket);
            }

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }

}
