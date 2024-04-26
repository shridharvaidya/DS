import java.rmi.*;
import java.util.Scanner;
public class Client {
    
 public static void main(String[] args){
    
    try{ 
        Scanner sc = new Scanner(System.in);
        String Url = "rmi://localhost/Stub";
        ServerInte serverInte = (ServerInte)Naming.lookup(Url);
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        System.out.println("Sum is : " + serverInte.addServer(num1,num2));
    }catch(Exception e )
   {

   }  
}
}