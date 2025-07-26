import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Lab38Server {
        public static void main(String[] args) {
        final int PORT = 9876;

        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            byte[] receiveBuffer = new byte[1024];

            System.out.println("UDP Echo Server started on port " + PORT);

            while (true) {
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                serverSocket.receive(receivePacket); // Wait for client message

                String receivedData = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Received from client: " + receivedData);

                // Echo the same message back to client
                InetAddress clientAddress = receivePacket.getAddress();
                int clientPort = receivePacket.getPort();
                byte[] sendBuffer = receivedData.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, clientAddress, clientPort);
                serverSocket.send(sendPacket); // Send back to client
            }

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }

}
