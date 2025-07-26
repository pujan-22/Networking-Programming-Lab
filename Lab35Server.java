import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.net.ssl.SSLServerSocketFactory;

public class Lab35Server {
        public static void main(String[] args) {
        try{
            SSLServerSocketFactory factory = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
            ServerSocket socket = factory.createServerSocket(1422);
            Socket s = socket.accept();
            System.out.println(s+"\nclient accept the connection");
            s.close();
            
        } catch(IOException e){
            System.out.println(e);
        }
            
    }

}
