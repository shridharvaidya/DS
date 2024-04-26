import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ServerImplement extends UnicastRemoteObject implements ServerInterface
{
    LocalTime currentTime;
    ServerImplement(LocalTime currentTime) throws RemoteException{
        this.currentTime=currentTime;
    }
    public LocalTime getTime() throws RemoteException{
        return this.currentTime;
    }
    public void adjustTime(LocalTime Time,long timediff) throws RemoteException{
        long TimeNano = Time.toNanoOfDay();//
        long adjusted = timediff + TimeNano ; 
        LocalTime adjustedTime = LocalTime.ofNanoOfDay(adjusted);
        System.out.println("Adjusted time is: " + adjustedTime.format(DateTimeFormatter.ofPattern("HH:mm:ss")));
        this.currentTime=adjustedTime;
    }

}