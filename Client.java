import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client implements Runnable {
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    public int gameStatus;
    public int playerIndex;
    public boolean[] grid;
    private String[] messagePieces;

    // Constructor to initialize socket, in and out streams
    public Client(String ip, int port) {
        try {
            socket = new Socket(ip, port);
            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Connected to server.");
            try {
                
            } catch (Exception e) {
                System.out.println("No messages remaining.");
            }
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

    public void sendGuess(int guess, int playerNum) {
        String msg = "Guess: " + guess + " from " + playerNum;
        sendMessage(msg);
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

    // Function to handle incoming messages from the client
  public void run() {
    Object message = null;
    try {
        while ((message = in.readObject()) != null) {
            try {
                messagePieces = (message.toString()).split(" / ");
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Message didn't contain /. Message: " + message.toString());
            }
            String status = ((String) message).substring(0, 1);
            switch(status) {
                //new match
                case "2":   
                    //TODO: start new match, set turn to player1, update initial arrays
                    System.out.println("All machines should get a fresh gamegrid and update the scores and their initial arrays");
                break;

                //game over
                case "3":
                    //TODO: Display winner in the turn label, disable buttons and close the connections on dispose. 
                    System.out.println("Game over, display final scores and let the player exit the GUI");
                break;

                //starting game messages
                case "0": 
                    //set player value
                    try {
                        if(Integer.parseInt(messagePieces[1]) > 0 && Integer.parseInt(messagePieces[1]) <= 4) {
                            playerIndex = Integer.parseInt(messagePieces[0]);
                        }
                    } catch (Exception e) {
                        System.out.println("The message was not an integer value: " + messagePieces[1] + " full message: " + message);
                    }
                break;

                //match in progress
                case "1":
                    if(Integer.parseInt(messagePieces[2]) == playerIndex) {
                        System.out.println("This machine should guess");
                        //TODO: handle guess instructions in GameManagement
                        
                    } else {
                        //TODO: update the board grid
                        System.out.println("Updating grid: ");
                        grid = new boolean[16];
                        String[] tempArr = messagePieces[1].split(" , ");
                        for(int i = 0; i < 16; i++) {
                            if (tempArr.equals("true")) {
                                grid[i] = true;
                            } else {
                                grid[i] = false;
                            }
                            System.out.print(grid[i]);
                        }
                    }
                break;
            }
        }
    } catch (IOException | ClassNotFoundException e) {
        // no more messages to read.
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
