import java.net.*;

public class Lab4 {
    public static void main(String[] args) {
        String ipv4 = "192.168.1.6";
        String ipv6 = "2001:db8::1";

        System.out.println("Checking IPv4 Address:");
        checkIPType(ipv4);

        System.out.println("\nChecking IPv6 Address:");
        checkIPType(ipv6);
    }

    public static void checkIPType(String ip) {
        try {
            InetAddress add = InetAddress.getByName(ip);

            if (add instanceof Inet4Address) {
                System.out.println(ip + " is a valid IPv4 address.");
            } else if (add instanceof Inet6Address) {
                System.out.println(ip + " is a valid IPv6 address.");
            } else {
                System.out.println(ip + " is an unknown type.");
            }
        } catch (UnknownHostException e) {
            System.out.println(ip + " is an invalid IP address.");
        }
    }
}
