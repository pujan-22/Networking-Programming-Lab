import java.net.*;

public class Lab6 {
    public static void main(String[] args) {
        try {
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("IP Address: " + localHost.getHostAddress());

            NetworkInterface ni = NetworkInterface.getByInetAddress(localHost);
            byte[] mac = ni.getHardwareAddress();

            if (mac != null) {
                StringBuilder sb = new StringBuilder();
                for (byte b : mac) {
                    sb.append(String.format("%02X", b));
                }
                System.out.println("MAC Address: " + sb.toString());
            } else {
                System.out.println("MAC Address not available.");
            }
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
