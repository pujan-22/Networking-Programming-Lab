import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Lab45Interface extends Remote {
    int computeGCD(int a, int b) throws RemoteException;
}
