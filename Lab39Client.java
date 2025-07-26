import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Lab39Client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 1313;

        try (DatagramSocket clientSocket = new DatagramSocket()) {
            InetAddress serverIP = InetAddress.getByName(SERVER_ADDRESS);

            // Send an empty packet just to trigger the server
            byte[] sendBuffer = new byte[1];
            DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverIP, SERVER_PORT);
            clientSocket.send(sendPacket);

            // Receive response from server
            byte[] receiveBuffer = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            clientSocket.receive(receivePacket);

            String serverTime = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server time: " + serverTime);

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }

}
