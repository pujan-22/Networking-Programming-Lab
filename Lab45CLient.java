import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Lab45CLient {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            Lab45Interface stub = (Lab45Interface) registry.lookup("GCD Service");

            int a = 36;
            int b = 60;
            int result = stub.computeGCD(a, b);

            System.out.println("GCD of " + a + " and " + b + " is: " + result);
        } catch (NotBoundException | RemoteException e) {
            System.out.println("Client Exception: " + e);
        }
    }

}
