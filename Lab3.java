import java.net.*;

public class Lab3 {

    public static void main(String[] args) {
        try {
            String ip = "127.0.0.1";
            InetAddress a = InetAddress.getByName(ip);

            System.out.println("IP Address: " + a.getHostAddress());

            System.out.println("Is Loopback Address? " + a.isLoopbackAddress());
            System.out.println("Is Any Local Address? " + a.isAnyLocalAddress());
            System.out.println("Is Link Local Address? " + a.isLinkLocalAddress());
            System.out.println("Is Site Local Address? " + a.isSiteLocalAddress());
            System.out.println("Is Multicast Address? " + a.isMulticastAddress());

        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address.");
        }
    }
}
