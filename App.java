import java.net.InetAddress;
import java.util.Scanner;

// For testing client connection to server. Remove from final deploy
public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String serverIP = "";
        System.out.print("Enter the server ip: ");
        System.out.println(serverIP);
        serverIP = sc.next();
        int port = 1234;
        System.out.println(port);
        Client client = new Client(serverIP, port);
        client.sendMessage("Player connected from " + InetAddress.getLocalHost());
        try {
            client.receiveAllMessages();
        } catch (Exception e) {
            System.out.println("No messages to read. ");
            e.printStackTrace();
        }
    }
}
