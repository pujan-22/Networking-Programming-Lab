import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Lab45Server {
    public static void main(String[] args) {
        try {
            Lab45Interface stub = new Lab45Implementation();
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("GCDService", stub);
            System.out.println("GCD Server is running...");
        } catch (RemoteException e) {
            System.out.println("Server Exception: " + e);
        }
    }
}
