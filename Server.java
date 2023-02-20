import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {
  public ServerSocket serverSocket;
  private ArrayList<Socket> clients;
  private ArrayList<ObjectOutputStream> outputs;
  private int clientNum = 0;

  // Constructor to initialize server socket and array lists
  public Server(InetAddress ip, int port) {
    try {
      serverSocket = new ServerSocket(port, 50, ip);
      clients = new ArrayList<>();
      outputs = new ArrayList<>();
      // prints the value of the ip the user needs
      String[] temp = ip.toString().split("/");
      String serverAddressDisplayed = temp[temp.length-1];
      System.out.println("Server started on address: " + serverAddressDisplayed + " port: " + port + ".");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Function to accept incoming client connections
  public void acceptConnections() {
    try {
      while (true) {
        if(clientNum >= 4) {
          // client limit reached, do not accept more clients.
        } else {
          // accept the new client.
          Socket client = serverSocket.accept();
          clients.add(client);
          ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
          outputs.add(out);
          ClientHandler handler = new ClientHandler(client, this);
          new Thread(handler).start();
          String[] temp = client.getInetAddress().getHostAddress().split("/");
          String clientAddressDisplayed = temp[temp.length-1];
          clientNum +=1;
<<<<<<< Updated upstream
          System.out.println("Client " + clients.indexOf(client)+1 + "connected from " + clientAddressDisplayed + ".");
=======
          System.out.println("Player " + clientNum + " as client " + ((Integer) clients.indexOf(client) + 1) + " connected from " + clientAddressDisplayed + ".");
          sendMessage(clientNum, clientNum);
          sendMessage("You have connected to " + serverAddressFormatted + ". You are Player: " + clientNum, clientNum);
>>>>>>> Stashed changes
        }
      }
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
      System.out.println("Message sent to client" + playerNumber);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

<<<<<<< Updated upstream
  public void sendData(int gameStatus, boolean[] gridValues, int currentPlayer, ) {

=======
  public void sendData(int gameStatus, boolean[] gridValues, int currentPlayer) {
    String temp = "";
    for (boolean b : gridValues) {
      temp = temp + b + " ";
    }
    String msg = ("" + gameStatus + " / " + temp + "/ " + "");
    broadcastMessage(msg);
>>>>>>> Stashed changes
  }

  // Function to remove a client from the array lists
  public void removeClient(Socket client, ObjectOutputStream out) {
    clients.remove(client);
    outputs.remove(out);
    System.out.println("Client disconnected from " + client.getInetAddress().getHostAddress() + ".");
  }
<<<<<<< Updated upstream
=======

  public String getAddress() {
    return serverSocket.getInetAddress().toString();
  }
<<<<<<< Updated upstream
>>>>>>> Stashed changes
=======
>>>>>>> Stashed changes
}

// ClientHandler class to handle individual clients
class ClientHandler implements Runnable {
  private Socket client;
  private ObjectInputStream in;
  private ObjectOutputStream out;
  private Server server;

  // Constructor to initialize client socket, input and output streams, and server
  public ClientHandler(Socket client, Server server) {
    this.client = client;
    this.server = server;
    try {
      in = new ObjectInputStream(client.getInputStream());
      out = new ObjectOutputStream(client.getOutputStream());
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  // Function to handle incoming messages from the client
  public void run() {
    Object message = null;
    try {
      while ((message = in.readObject()) != null) {
        String msg = message.toString();
        System.out.println("Message received from " + client.getInetAddress().getHostAddress() + ": " + message);
<<<<<<< Updated upstream
<<<<<<< Updated upstream
        // Handle private messages
        if(message.toString().contains("player")) {
          int sendTo = Integer.parseInt(message.toString().substring(6, 6));
          server.sendMessage(message.toString().substring(9), sendTo);
        }
        // Handle public messages
        else { 
          server.broadcastMessage(message);
        }
=======
        int flag = (Integer.parseInt(msg.substring(0,0)));
          String[] temp = msg.split(" / ");
           

        }
        server.broadcastMessage(message);
>>>>>>> Stashed changes
=======
        int flag = (Integer.parseInt(msg.substring(0,1)));
        
        String[] temp = msg.split(" / ");
        for (String string : temp) {
          System.out.println(string);
        }

>>>>>>> Stashed changes
      }
      //server.broadcastMessage(message);
    } catch (IOException | ClassNotFoundException e) {
      server.removeClient(client, out);
    }
  }
}