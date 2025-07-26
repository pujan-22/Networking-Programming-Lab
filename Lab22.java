import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class Lab22 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.example.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            System.out.println("HTTP Response Headers:\n");
            int i = 0;
            while (true) {
                String headerKey = conn.getHeaderFieldKey(i);
                String headerValue = conn.getHeaderField(i);
                if (headerKey == null && headerValue == null) {
                    break;
                }
                System.out.println(headerKey + ": " + headerValue);
                i++;
            }
            conn.disconnect();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
