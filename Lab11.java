import java.net.MalformedURLException;
import java.net.URL;
public class Lab11 {
    public void getDetails(String s){
        try{
            URL u = new URL(s);
            System.out.println("URL is " + u.toString());
            System.out.println("Port is " + u.getPort());
            System.out.println("Protocol is " + u.getProtocol());
            System.out.println("Host is " + u.getHost());
            System.out.println("File is " + u.getFile());
            System.out.println("Authority is " + u.getAuthority());
            System.out.println("Query is " + u.getQuery()); 
            System.out.println("Default is " + u.getDefaultPort());           
        }
        
        catch(MalformedURLException ex){
            System.out.println(ex.getMessage());
        }
    }
    public static void main(String[] args) {
        new Lab11().getDetails("https://www.pinterest.com");
    }
}
