import java.net.*;

public class Lab8 {
    public static void main(String[] args) throws Exception {
        
        String ipAddress = "192.168.1.3";

        InetAddress inet = InetAddress.getByName(ipAddress);
        NetworkInterface ni = NetworkInterface.getByInetAddress(inet);

        byte[] mac = ni.getHardwareAddress();
       
        System.out.print("MAC address for IP " + ipAddress + ": ");
        for (int i = 0; i < mac.length; i++) {
            System.out.format("%02X%s", mac[i], (i < mac.length - 1) ? ":" : "");
        }
        System.out.println();
    }
}
