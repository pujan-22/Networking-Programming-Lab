import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class Lab14 {
    public static void main(String[] args) {
        try {
            String original = "https://www.facebook.com/home";
            String encoded = URLEncoder.encode(original, StandardCharsets.UTF_8.toString());

            System.out.println("Original: " + original);
            System.out.println("Encoded : " + encoded);
        } catch (UnsupportedEncodingException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
