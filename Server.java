import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketAddress;

public class Server{

  ServerSocket server;
  Socket socket;
  DataInputStream in;
  DataOutputStream out;
  SocketAddress address;


  public Server() throws IOException {
    server = new ServerSocket(1234);
    System.out.println("Server Started");
    address = server.getLocalSocketAddress();
  }

  public void serverSetup() throws IOException {
  socket = server.accept();
    System.out.println("Client Connected");
    in = new DataInputStream(socket.getInputStream());
    out = new DataOutputStream(socket.getOutputStream());

    // while (true) {
    //   String message = in.readUTF();
    //   if(message.toLowerCase() == "close()") {
    //     server.close();
    //     break;
    //   }
    //   System.out.println("Client: " + message);
    //   out.writeUTF("Server: " + message);
    // }
  }

  public String getLocalAddress() {     // Not functional, going to wait for Issac's changes
    return address.toString(); 
  }
}