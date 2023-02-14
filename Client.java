import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;

    // Constructor to initialize socket, in and out streams
    public Client(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Connected to server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to send messages to the server
    public void sendMessage(Object message) {
        try {
            out.writeObject(message);
             System.out.println("Message sent to server: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Function to receive messages from the server
    public Object receiveMessage() {
        Object message = "";
        try {
            message = in.readObject();
            System.out.println("Message received from server: " + message);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("error receiving message.");
        }
        return message;
    }

    public void receiveAllMessages() {
        try {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
            Object message = in.readObject();
            while (message != null) {
                System.out.println("Message Received: " + message);
                message = in.readObject();
            }
        } catch (EOFException e) {
            System.out.println("No more messages to read currently...");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("There was an error reading the messages. ");
        }
    }
    
    // Function to close the socket connection
    public void closeConnection() {
        try {
            in.close();
            out.close();
            socket.close();
            System.out.println("Disconnected from server.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
