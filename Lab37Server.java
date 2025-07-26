
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class Lab37Server {

    public static void main(String[] args) {
        final int PORT = 5000;

        try (ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {
            serverSocketChannel.bind(new InetSocketAddress(PORT));
            System.out.println("NIO TCP Server is running on port " + PORT + "...");

            while (true) {
                SocketChannel client = serverSocketChannel.accept(); // Blocking accept
                System.out.println("Client connected: " + client.getRemoteAddress());

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                client.read(buffer);

                buffer.flip(); // switch to read mode
                String message = new String(buffer.array(), 0, buffer.limit());
                System.out.println("Received from client: " + message);

                // Respond back to client
                String response = "Server received: " + message;
                buffer.clear();
                buffer.put(response.getBytes());
                buffer.flip();
                client.write(buffer);

                client.close(); // Close after one exchange (for simplicity)
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
