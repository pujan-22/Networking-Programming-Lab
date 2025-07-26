import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Lab38Client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 9876;

        try (DatagramSocket clientSocket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress serverIP = InetAddress.getByName(SERVER_ADDRESS);
            System.out.println("UDP Echo Client started. Type 'exit' to quit.");

            while (true) {
                System.out.print("Enter message: ");
                String message = scanner.nextLine();
                if ("exit".equalsIgnoreCase(message)) break;

                byte[] sendBuffer = message.getBytes();
                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverIP, SERVER_PORT);
                clientSocket.send(sendPacket);

                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                clientSocket.receive(receivePacket);

                String echoedMessage = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Echoed from server: " + echoedMessage);
            }

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }

}
