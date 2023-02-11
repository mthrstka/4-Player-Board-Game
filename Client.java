import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client extends Thread {

  Socket socket;
  DataInputStream in;
  DataOutputStream out;

  public void clientSetup() throws IOException {
    socket = new Socket("199.17.138.13", 1234);
    System.out.println("Connected to Server");
    in = new DataInputStream(socket.getInputStream());
    out = new DataOutputStream(socket.getOutputStream());
    Scanner scanner = new Scanner(System.in);
    
    while (true) {
      String message = scanner.nextLine();
      if(message.toLowerCase() == "close()") {
        socket.close();
        scanner.close();
        break;
      }
      out.writeUTF(message);
      System.out.println("Server: " + in.readUTF());
    }
  }
}