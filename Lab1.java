import java.net.*;

public class Lab1 {
    public static void main(String[] args) {
        try {
            
            InetAddress i = InetAddress.getLocalHost();

            System.out.println("Hostname: " + i.getHostName());
            System.out.println("IP Address: " + i.getHostAddress());
        } catch (UnknownHostException e) {
            System.out.println("Cannot get IP address.");
        }
    }
}
