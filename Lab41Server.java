import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Lab41Server {
    public static void main(String[] args) {
        final int PORT = 4446;

        try (DatagramSocket serverSocket = new DatagramSocket(PORT)) {
            System.out.println("UDP Armstrong Server is running on port " + PORT);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket requestPacket = new DatagramPacket(buffer, buffer.length);
                serverSocket.receive(requestPacket);

                String received = new String(requestPacket.getData(), 0, requestPacket.getLength());
                int number = Integer.parseInt(received.trim());

                String response;
                if (isArmstrong(number)) {
                    response = number + " is an Armstrong number.";
                } else {
                    response = number + " is not an Armstrong number.";
                }

                byte[] responseData = response.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(
                        responseData,
                        responseData.length,
                        requestPacket.getAddress(),
                        requestPacket.getPort()
                );

                serverSocket.send(responsePacket);
            }

        } catch (Exception e) {
            System.out.println("Server Error: " + e.getMessage());
        }
    }
    private static boolean isArmstrong(int number) {
        int original = number, sum = 0;
        int digits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        return sum == original;
    }
}
