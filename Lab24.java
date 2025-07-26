import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class Lab24 {
    public static void main(String[] args) {
        String webpage = "https://www.example.com";

        try {
            URL url = new URL(webpage);
            URLConnection conn = url.openConnection();
            InputStream in = conn.getInputStream();

            int byteData;
            while ((byteData = in.read()) != -1) {
                System.out.print((char) byteData); 
            }

            in.close();

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
