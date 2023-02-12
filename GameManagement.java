import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.stream.*;

public class GameManagement implements ActionListener{

    private GUI gui;
    private Server server;
    private Client client;
    private boolean isServer = false;
    public static int currentTurn = 1;
    public int playerTurn = 1;
    public int roundNum = 1;
    public int[] playerScores = new int[4];

    
    public GameManagement() {

        gui = new GUI(this);
        client = new Client();

    }

    public void nextTurn(){

        currentTurn++;
        playerTurn++;

        if(playerTurn == 5){
            playerTurn = 1;
        }

    }

    public void newRound() {
        roundNum++;
        currentTurn = 1;
        playerTurn = 1;
    }

    public static void setArray(int[] Arr) {
		
		for (int i = 0; i < 3; i++) {
			
			//set a temp int from 1-20
			int temp = (int)(Math.random()*20)+1;
			
			//if statement to check if the current temp is in the array to make array unique
			if (IntStream.of(Arr).anyMatch(x -> x == temp)) {
				i--;
			} else {
				
				Arr[i] = temp;
				System.out.print(Arr[i] + " ");
			}
		}
    }

    public String getServerAdress() {
        return server.getLocalAddress();
    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == gui.amClientBtn || e.getSource() == gui.amServerBtn){
            gui.continueBtn.setEnabled(true);
        }

        if(e.getSource() == gui.continueBtn){
        
            if(gui.amServerBtn.isSelected()){

                try {
                    server = new Server();
                } catch(Exception error){System.out.println("Server setup failed");}

                gui.card.show(gui.setupMenu.getContentPane(), "server");
                gui.addressBar.setText("<html><p text-align: center>Your server address is:</p><br /><h1 text-align: center>" + getServerAdress() + 
                "</h1><br /><p text-align: center;>All other players should join using this address.</p></html>");
                isServer = true;

                Thread ts = new Thread() {
                    public void run(){
                        try{
                            server.serverSetup();
                            client.clientSetup();
                        } catch(Exception e){
                            System.out.println("Server setup failed");
                        }
                    }
                };

                ts.start();
            } else if(gui.amClientBtn.isSelected()){
                Thread tc = new Thread() {
                    public void run(){
                        try{
                            client.clientSetup();
                        }catch(Exception e){
                            System.out.println("Client setup failed");
                        }
                    }
                };

                tc.start();
            } else{
                gui.setupMenu.setVisible(false);
                gui.gameHome();
            }
        }
    }
}