import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Lab29Client {
    public static void main(String[] args) throws IOException {
        Scanner inp = new Scanner(System.in);
        Socket soc = new Socket("localhost",34345);
        DataOutputStream out = new DataOutputStream(soc.getOutputStream());
        DataInputStream in = new DataInputStream(soc.getInputStream());
        System.out.print("Enter Number : ");
        int num = inp.nextInt();
        out.writeUTF(String.valueOf(num));
        out.flush();
        int fact = Integer.parseInt(in.readUTF());
        System.out.println("Factorial : "+fact);
        soc.close();
    }

}
