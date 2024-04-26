import java.rmi.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ClientClock {
    public static void main(String[] args ){
        try{
            String clock1 = "rmi://localhost/"+args[0];
            String clock2 = "rmi://localhost/"+args[1];
            String clock3 = "rmi://localhost/"+args[2];

            LocalTime serverTime = LocalTime.parse("03:00:00",DateTimeFormatter.ofPattern("HH:mm:ss"));
            System.out.println("Server Time is " + serverTime.toString());

            ServerInterface c1 = (ServerInterface)Naming.lookup(clock1);
            System.out.println("clock one time =  " + c1.getTime());

            ServerInterface c2 = (ServerInterface)Naming.lookup(clock2);
            System.out.println("clock one time =  " + c2.getTime());

            ServerInterface c3 = (ServerInterface)Naming.lookup(clock3);
            System.out.println("clock one time =  " + c3.getTime());
            
            long serverNano = serverTime.toNanoOfDay();
            long c1Nano = c1.getTime().toNanoOfDay()-serverNano;
            long c2Nano = c2.getTime().toNanoOfDay()-serverNano;
            long c3Nano = c3.getTime().toNanoOfDay()-serverNano;
            long avg = (c1Nano+c2Nano+c3Nano)/4;

            c1.adjustTime(serverTime, avg);
            c2.adjustTime(serverTime, avg);
            c3.adjustTime(serverTime, avg);
            serverTime=serverTime.plusNanos(avg);
            System.out.println("clock one updated time =  " + c1.getTime());
            System.out.println("clock two updated time =  " + c2.getTime());
            System.out.println("clock three updated time =  " + c3.getTime());
            System.out.println("updated time"+serverTime);


        }
        catch(Exception e)
        {
            System.out.println("exception" + e);
        }
    }
}