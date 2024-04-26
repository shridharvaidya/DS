import java.rmi.*;

public interface ServerInte extends Remote {
     double addServer(double d1 , double d2) throws RemoteException;
}