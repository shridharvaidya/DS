import java.rmi.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter; // hh:mm:ss

public interface ServerInterface extends Remote {
    
    public void adjustTime(LocalTime serverTime,long timediff) throws RemoteException;
    public LocalTime getTime() throws RemoteException;

}
