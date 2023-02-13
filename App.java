// import java.net.InetAddress;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the server ip: ");
        String serverIP = "192.168.1.241";
        System.out.println("Enter the server port: ");
        int port = 1234;
        Client client = new Client(serverIP, port);
        client.sendMessage("Player connected");
        for(int i=0; i<2; i++) {
            client.sendMessage(sc.nextLine());
        }
        client.receiveAllMessages();
        // System.out.println("Enter the ip address: ");
    }
}
