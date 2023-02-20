// import java.net.InetAddress;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
<<<<<<< Updated upstream
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the server ip: ");
        String serverIP = "192.168.1.241";
        serverIP = sc.next();
        System.out.println("Enter the server port: ");
        int port = 1234;
        port = sc.nextInt();
        Client client = new Client(serverIP, port);
        client.sendMessage("Player connected");
        for(int i=0; i<2; i++) {
            client.sendMessage(sc.nextLine());
        }
        client.receiveAllMessages();
        // System.out.println("Enter the ip address: ");
=======
        int ex = Integer.parseInt("".substring(2,3));
        System.out.println(ex);
        // String serverIP = "192.168.1.232";
        // System.out.print("Enter the server ip: ");
        // int port = 1234;
        // System.out.println(port);
        // Client client = new Client(serverIP, port);
        // client.sendMessage("Player connected from " + InetAddress.getLocalHost());
        // while(true) {
        //     try {
        //         Object e = client.receiveMessage();
        //         System.out.println("" + e);
        //     } catch (Exception e) {
        //         System.out.println("No messages to read. ");
        //         e.printStackTrace();
        //     }
        // }
>>>>>>> Stashed changes
    }
}
