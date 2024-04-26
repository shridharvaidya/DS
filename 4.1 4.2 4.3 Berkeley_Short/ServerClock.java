import java.rmi.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ServerClock {
    public static void main(String[] args)
    {
        try{
            ServerImplement serverclock = new ServerImplement(LocalTime.parse(args[1],DateTimeFormatter.ofPattern("HH:mm:ss")));
            Naming.rebind(args[0],serverclock);
        }
        catch(Exception e){ System.out.println("exception - "+e);}
    }
}