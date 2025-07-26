import java.io.*;
import java.net.*;

public class Lab10 {
    public static void main(String args[]) {
        try {
            int c;
            URL url = new URL("https://www.google.com/");
            URLConnection conn = url.openConnection();

            System.out.println("=== Retrieve data ===");
            try (InputStream in = conn.getInputStream()) {
                while ((c = in.read()) != -1) {
                    System.out.print((char) c);
                }
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}