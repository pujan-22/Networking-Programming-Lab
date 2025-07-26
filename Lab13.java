import java.net.URI;
import java.net.URISyntaxException;

public class Lab13 {
    public static void main(String[] args) {
        try {
            URI uri = new URI("https://user:pass@example.com:8080/path/to/resource?query=java#section");

            System.out.println("Scheme: " + uri.getScheme());
            System.out.println("User Info: " + uri.getUserInfo());
            System.out.println("Host: " + uri.getHost());
            System.out.println("Port: " + uri.getPort());
            System.out.println("Path: " + uri.getPath());
            System.out.println("Query: " + uri.getQuery());
            System.out.println("Fragment: " + uri.getFragment());

        } catch (URISyntaxException e) {
            System.out.println("Invalid URI");
        }
    }
}
