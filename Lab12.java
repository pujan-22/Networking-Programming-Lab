import java.io.IOException;
import java.net.URL;

public class Lab12 {
    public static void main(String[] args) {
        String[] protocols = {
            "http", "https", "ftp", "file", "jar", "mailto", "gopher", "nfs", "jdbc"
        };

        for (String protocol : protocols) {
            try {
                URL url = new URL(protocol + "://google.com");
                url.openConnection(); 
                System.out.println(protocol + " is supported.");
            } catch (IOException e) {
                System.out.println(protocol + " is NOT supported.");
            }
        }
    }
}
