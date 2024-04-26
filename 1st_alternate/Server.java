
import java.rmi.*;
public class Server {
    public static void main (String[] args){
        try{
            ServerImple object = new ServerImple();
            Naming.rebind("Stub",object);
        }
        catch(Exception e ){}
    }
}   