import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

  public static void main(String[] args) throws IOException {
    Socket socket = new Socket("localhost", 1234);
    System.out.println("Connected to Server");
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
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