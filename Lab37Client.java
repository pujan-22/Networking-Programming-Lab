import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.Scanner;

public class Lab37Client {
    public static void main(String[] args) {
        final String SERVER_HOST = "localhost";
        final int SERVER_PORT = 5000;

        try (SocketChannel socketChannel = SocketChannel.open()) {
            socketChannel.connect(new InetSocketAddress(SERVER_HOST, SERVER_PORT));
            System.out.println("Connected to server at " + SERVER_HOST + ":" + SERVER_PORT);

            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a message to send to the server: ");
            String message = scanner.nextLine();

            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            socketChannel.write(buffer);

            // Prepare to read response
            buffer.clear();
            socketChannel.read(buffer);
            buffer.flip();

            String response = new String(buffer.array(), 0, buffer.limit());
            System.out.println("Response from server: " + response);
            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
