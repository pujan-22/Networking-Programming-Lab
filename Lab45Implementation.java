import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Lab45Implementation extends UnicastRemoteObject implements Lab45Interface {
    protected Lab45Implementation() throws RemoteException {
        super();
    }

    @Override
    public int computeGCD(int a, int b) throws RemoteException {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
