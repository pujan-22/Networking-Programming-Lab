import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Lab41Client {
    public static void main(String[] args) {
        final String SERVER = "localhost";
        final int PORT = 4446;

        try (DatagramSocket clientSocket = new DatagramSocket();
             Scanner scanner = new Scanner(System.in)) {

            InetAddress serverAddress = InetAddress.getByName(SERVER);

            System.out.print("Enter a number to check if it's an Armstrong number: ");
            String input = scanner.nextLine();

            byte[] sendData = input.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverAddress, PORT);
            clientSocket.send(sendPacket);

            byte[] receiveData = new byte[1024];
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            clientSocket.receive(receivePacket);

            String result = new String(receivePacket.getData(), 0, receivePacket.getLength());
            System.out.println("Server Response: " + result);

        } catch (Exception e) {
            System.out.println("Client Error: " + e.getMessage());
        }
    }

}
