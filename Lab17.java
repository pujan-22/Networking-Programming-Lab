import java.net.CookiePolicy;
import java.net.HttpCookie;
import java.net.URI;

public class Lab17 {
    public static void main(String[] args) {
        CookiePolicy blockGovPolicy = new CookiePolicy() {
            @Override
            public boolean shouldAccept(URI uri, HttpCookie cookie) {
                if (uri == null || cookie == null) return false;

                String host = uri.getHost();
                if (host != null && host.endsWith(".gov")) {
                    // Block cookies from .gov domains
                    System.out.println("Blocking cookie from .gov domain: " + host);
                    return false;
                }
                // Allow cookies from all other domains
                return true;
            }
        };

        // Example usage:
        URI govUri = URI.create("http://example.gov");
        URI eduUri = URI.create("http://university.edu");

        HttpCookie cookie1 = new HttpCookie("session", "abc123");
        HttpCookie cookie2 = new HttpCookie("session", "xyz789");

        System.out.println("Should accept gov cookie? " + blockGovPolicy.shouldAccept(govUri, cookie1));
        System.out.println("Should accept edu cookie? " + blockGovPolicy.shouldAccept(eduUri, cookie2));
    }
}
