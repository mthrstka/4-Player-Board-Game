import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  public static void main(String[] args) throws IOException {
    ServerSocket server = new ServerSocket(1234);
    System.out.println("Server Started");
    Socket socket = server.accept();
    System.out.println("Client Connected");
    DataInputStream in = new DataInputStream(socket.getInputStream());
    DataOutputStream out = new DataOutputStream(socket.getOutputStream());

    while (true) {
      String message = in.readUTF();
      if(message.toLowerCase() == "close()") {
        server.close();
        break;
      }
      System.out.println("Client: " + message);
      out.writeUTF("Server: " + message);
    }
  }
}
