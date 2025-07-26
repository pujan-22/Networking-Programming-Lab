import java.net.*;
import java.util.*;

public class Lab5 {
    public static void main(String[] args) {
        try {
            List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
            
            System.out.println("Available network interfaces:");
            for (NetworkInterface ni : interfaces) {
                System.out.println("- " + ni.getName() + " (" + ni.getDisplayName() + ")");
            }
        } catch (SocketException e) {
            System.out.println("Error fetching network interfaces: ");
        }
    }
}
