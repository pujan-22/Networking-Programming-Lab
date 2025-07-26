import java.io.IOException;
import java.net.Socket;


public class Lab25 {
    public static void main(String[] args) {
        try {
            Socket s = new Socket("www.facebook.com", 80);
            System.out.println("Remote Address: " + s.getInetAddress());
            System.out.println("Remote Port: " + s.getPort());
            System.out.println("Local Address: " + s.getLocalAddress());
            System.out.println("Local Port: " + s.getLocalPort());
            s.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}