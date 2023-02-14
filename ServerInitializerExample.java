import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
// import java.util.Scanner;

public class ServerInitializerExample {
    public static void main(String[] args) throws IOException, UnknownHostException{
        InetAddress hostAddress = InetAddress.getLocalHost();
        Server testServer = new Server(hostAddress, 1234); 
        testServer.acceptConnections();
        // testing code commented out
        // Scanner sc = new Scanner(System.in);
        // System.out.println("Which client should I send the message to? (1-4): ");
        // int sendToPlayer = sc.nextInt();
        // while(sendToPlayer > 4 || sendToPlayer < 1) {
        //     System.out.println("Please try a valid player number (1-4): ");
        //     sendToPlayer = sc.nextInt();
        // }
        // sc.close();
        // testServer.sendMessage("This message should be sent from the server to the client 1 after the connection is accepted", sendToPlayer);
        // ip 10.19.80.xxxs
        // use the value after the / example machinename/11.11.11.111 the clients should use to connect would be 11.11.11.111 
    }
}