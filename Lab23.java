import java.net.HttpURLConnection;
import java.net.URL;

public class Lab23 {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.facebook.com");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(3000);
            conn.setReadTimeout(3000);
            conn.connect();
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}