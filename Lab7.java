import java.net.*;
import java.util.*;

public class Lab7 {
    public static void main(String[] args) throws Exception {
        
        String input = "wlan1"; 

        for (NetworkInterface ni : Collections.list(NetworkInterface.getNetworkInterfaces())) {
            String mac = formatMAC(ni.getHardwareAddress());
            if (ni.getName().equalsIgnoreCase(input) || mac.equalsIgnoreCase(input)) {
                System.out.println("Interface: " + ni.getName());
                System.out.println("MAC: " + (mac.isEmpty() ? "N/A" : mac));
                for (InetAddress addr : Collections.list(ni.getInetAddresses())) {
                    if (addr instanceof Inet4Address) {
                        System.out.println("IP Address: " + addr.getHostAddress());
                    }
                }
                return;
            }
        }
        System.out.println("No matching interface found.");
    }

    static String formatMAC(byte[] mac) {
        if (mac == null) return "";
        StringBuilder sb = new StringBuilder();
        for (byte b : mac) sb.append(String.format("%02X:", b));
        return sb.length() > 0 ? sb.substring(0, sb.length() - 1) : "";
    }
}
