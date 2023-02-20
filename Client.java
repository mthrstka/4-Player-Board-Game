import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Client implements Runnable {
    private Socket socket;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    public int gameStatus;
    public boolean[] grid;
    private String[] messagePieces;
    GameManagement gm;

    // Constructor to initialize socket, in and out streams
    public void setupClient(String ip, int port, GameManagement g) {
        gm = g;
        try {
            socket = new Socket(ip, port);

            if(!gm.isServer)
                out = new ObjectOutputStream(socket.getOutputStream());

            in = new ObjectInputStream(socket.getInputStream());
            System.out.println("Connected to server.");
            try {
                run();
            } catch (Exception e) {
                System.out.println("No messages remaining.");
                e.printStackTrace();
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
        String msg = guess + " / " + playerNum;
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
            e.printStackTrace();
        }
        return message;
    }

    // Function to handle incoming messages from the client
  public void run() {
    Object message = null;
    System.out.println("waiting");
        while ((message = receiveMessage()) != null) {
            System.out.println("running");
            try {
                messagePieces = (message.toString()).split(" / ");
                System.out.println("p1: " + messagePieces[0]);   
                System.out.println("p2: " + messagePieces[1]);              
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("Message didn't contain /. Message: " + message);
            }
            String status = messagePieces[0];
            switch(status) {
                //new match
                case "2":   
                    gm.newRound(Integer.parseInt(messagePieces[1]));
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
                            gm.localPlayerNum = Integer.parseInt(messagePieces[1]);
                            System.out.println("Set player number to: " + messagePieces[1]);
                        }
                    } catch (Exception e) {
                        System.out.println("The message was not an integer value: " + messagePieces[1] + " full message: " + message);
                    }
                break;

                //match in progress
                case "1":
                    //TODO: handle instructions for non-guessing users. 
                    gm.nextTurn();
                    if(Integer.parseInt(messagePieces[1]) == gm.localPlayerNum) {
                        System.out.println("This machine should guess");
                        //TODO: handle guess instructions in GameManagement
                    }
                break;

                case "4":
                    System.out.println("Recieved array");
                    Scanner arrScan = new Scanner(messagePieces[1]);

                    gm.gui.guessesMade.add(arrScan.nextInt());
                    gm.gui.guessesMade.add(arrScan.nextInt());
                    gm.gui.guessesMade.add(arrScan.nextInt());
                    gm.gui.updateGuessesMade();
                break;

                case "5":
                    gm.gui.updatePlayerCount(Integer.parseInt(messagePieces[1]));
                break;

                //case to update board array
                case "6":
                    // parse the string input into a boolean array
                    System.out.println("Updating grid: ");
                    grid = new boolean[16];
                    String[] tempArr = messagePieces[1].split(" ");
                    for(int i = 0; i < 16; i++) {
                        if (tempArr.equals("true")) {
                            grid[i] = true;
                        } else {
                            grid[i] = false;
                        }
                        System.out.print(grid[i]);
                    }
                    //update the board grid
                    gm.updateBoard(grid);
            }
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
