import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Lab40Client {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 4445;

        try (DatagramSocket clientSocket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress serverIP = InetAddress.getByName(SERVER_ADDRESS);

            System.out.println("Type your messages. Type 'exit' to quit.");

            while (true) {
                System.out.print("You: ");
                String message = scanner.nextLine();
                byte[] sendBuffer = message.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendBuffer, sendBuffer.length, serverIP, SERVER_PORT);
                clientSocket.send(sendPacket);

                if (message.equalsIgnoreCase("exit")) break;

                byte[] receiveBuffer = new byte[1024];
                DatagramPacket receivePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
                clientSocket.receive(receivePacket);

                String response = new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Server: " + response);
            }

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }

}
