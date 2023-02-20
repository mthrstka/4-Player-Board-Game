import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
  public ServerSocket serverSocket;
  public String serverAddressFormatted;
  private ArrayList<Socket> clients;
  private ArrayList<ObjectOutputStream> outputs;
  public int clientNum = 0;
  public GameManagement gm;
  

  // Constructor to initialize server socket and array lists
  public Server(InetAddress ip, int port, GameManagement g) {
    gm = g;
    try {
      serverSocket = new ServerSocket(port, 50, ip);
      clients = new ArrayList<>();
      outputs = new ArrayList<>();
      // prints the value of the ip the user needs
      String[] temp = ip.toString().split("/");
      String serverAddressDisplayed = temp[temp.length-1];
      serverAddressFormatted = serverAddressDisplayed;
      System.out.println("Server started on address: " + serverAddressDisplayed + " port: " + port + ".");

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Function to accept incoming client connections
  public void acceptConnection() {
    try {
        if(clientNum < 4) {
          // accept the new client.
          Socket client = serverSocket.accept();
          clients.add(client);
          ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
          outputs.add(out);
          ClientHandler handler = new ClientHandler(client, this, clientNum);
          new Thread(handler).start();
          String[] temp = client.getInetAddress().getHostAddress().split("/");
          //String clientAddressDisplayed = temp[temp.length-1];
          clientNum +=1;
          //System.out.println("Player " + clientNum + " as client " + ((Integer) clients.indexOf(client) + 1) + " connected from " + clientAddressDisplayed + ".");
        }
        // client limit reached, do not accept more clients.
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Function to broadcast messages to all clients
  public void broadcastMessage(Object message) {
    for (ObjectOutputStream out : outputs) {
      try {
        out.writeObject(message);
        out.flush();
        System.out.println("Message broadcast to client " + (outputs.indexOf(out)+1) + ": " + message);
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
  }

  public void sendMessage(Object message, int playerNumber) {
    try {
      ObjectOutputStream out = outputs.get(playerNumber-1);
      out.writeObject(message);
      out.flush();
      System.out.println("(Server->client " + playerNumber + ")" + message);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Function to remove a client from the array lists
  public void removeClient(Socket client, ObjectOutputStream out) {
    System.out.print("Client " + clients.indexOf(client) + " disconnected from " + client.getInetAddress().getHostAddress() + ".");
    clients.remove(client);
    outputs.remove(out);
    clientNum -= 1;
    System.out.println(" Client " + clients.indexOf(client) + " removed.");
  }

  public String getAddress() {
    return serverSocket.getInetAddress().toString();
  }
}


// ClientHandler class to handle individual clients
class ClientHandler implements Runnable {
  private Socket client;
  private ObjectInputStream in;
  private ObjectOutputStream out;
  private Server server;

  // Constructor to initialize client socket, input and output streams, and server
  public ClientHandler(Socket client, Server server, int num) {
    this.client = client;
    this.server = server;
    try {
      if(server.gm.localPlayerNum != num)
        in = new ObjectInputStream(client.getInputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void run() {
    Object message = null;
    try {
      while ((message = in.readObject()) != null) {
          
          server.broadcastMessage(message);
      }
    } catch (IOException | ClassNotFoundException e) {
    }
  }
  // Function to handle incoming messages from the client
}