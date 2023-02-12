import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.stream.*;
import java.util.Arrays;

public class GameManagement implements ActionListener{

    private GUI gui;
    private Server server;
    private Client client;
    private boolean isServer = false;
    public static int currentTurn = 1;
    public int playerTurn = 1;
    public int roundNum = 1;
    public int[] playerScores = new int[4];

    public static Boolean playerBl[] = new Boolean[16];
    public static Integer arrP1[] = new Integer[3];
    public static Integer arrP2[] = new Integer[3];
    public static Integer arrP3[] = new Integer[3];
    public static Integer arrP4[] = new Integer[3];

    
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
    
    //takes int value to represent player and their guess array.
    public static void checkWin(int player, Integer[] Arr) {
    	
    	switch(player) {
    	
    	case 1: {
    		
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP1))) {playerBl[0] = true;}
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP2))) {playerBl[1] = true;}
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP3))) {playerBl[2] = true;}
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP4))) {playerBl[3] = true;}
			
			break;
    		
    	}
    	case 2: {
    		
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP1))) {playerBl[4] = true;}
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP2))) {playerBl[5] = true;}
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP3))) {playerBl[6] = true;}
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP4))) {playerBl[7] = true;}
			
			break;
    		
    	}
    	case 3: {
    		
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP1))) {playerBl[8] = true;}
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP2))) {playerBl[9] = true;}
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP3))) {playerBl[10] = true;}
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP4))) {playerBl[11] = true;}
			
			break;
    		
    	}
    	case 4: {
    		
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP1))) {playerBl[12] = true;}
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP2))) {playerBl[13] = true;}
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP3))) {playerBl[14] = true;}
			if(Arrays.asList(Arr).containsAll(Arrays.asList(arrP4))) {playerBl[15] = true;}
			
			break;
    		
    	}
    	case 5: {
    		//reset array on player being set to win? GE
    		
    		break;
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
                
                gui.serverPlayerPanel.add(gui.p1Connect);        // moves player panel to active card
                gui.serverPlayerPanel.add(gui.p2Connect);
                gui.serverPlayerPanel.add(gui.p3Connect);
                gui.serverPlayerPanel.add(gui.p4Connect);
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

                gui.card.show(gui.setupMenu.getContentPane(), "client");

                gui.clientPlayerPanel.add(gui.p1Connect);        // moves player panel to active card
                gui.clientPlayerPanel.add(gui.p2Connect);
                gui.clientPlayerPanel.add(gui.p3Connect);
                gui.clientPlayerPanel.add(gui.p4Connect);

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