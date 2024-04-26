import java.rmi.*;
import java.rmi.server.*;

public class ServerImple extends UnicastRemoteObject implements ServerInte {
    public ServerImple() throws RemoteException{}
    public double addServer(double d1 , double d2) throws RemoteException
    {
        return d1+d2;
    }

}