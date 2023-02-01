import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

  ServerSocket server;
  Socket socket;
  DataInputStream in;
  DataOutputStream out;

  public void serverSetup() throws IOException {
    server = new ServerSocket(1234);
    System.out.println("Server Started");
    socket = server.accept();
    System.out.println("Client Connected");
    in = new DataInputStream(socket.getInputStream());
    out = new DataOutputStream(socket.getOutputStream());

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