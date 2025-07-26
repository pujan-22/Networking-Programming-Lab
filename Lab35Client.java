import java.io.IOException;
import java.net.Socket;
import javax.net.ssl.SSLSocketFactory;

public class Lab35Client {
    public static void main(String[] args) {
        try{
            SSLSocketFactory factory = (SSLSocketFactory) SSLSocketFactory.getDefault();
            Socket socket = factory.createSocket("localhost",1422);
            System.out.println("server connected\n"+socket);
            socket.close();
            
            
        } catch(IOException e){
            System.out.println(e);
        }
    }

}
