import java.io.IOException;
import java.net.*;

public class Lab2 {
    public static void main(String[] args) throws IOException {
        try {
            InetAddress i = InetAddress.getLocalHost();

            System.out.println("Host Name       : " + i.getHostName());
            System.out.println("Host Address    : " + i.getHostAddress());
            System.out.println("Canonical Host  : " + i.getCanonicalHostName());
            System.out.println("Is Loopback     : " + i.isLoopbackAddress());
            System.out.println("Is Reachable    : " + i.isReachable(2000));
            System.out.println("Is Multicast    : " + i.isMulticastAddress());

        } catch (UnknownHostException e) {
            System.out.println("Error: Unknown Host");
        }
    }
}
