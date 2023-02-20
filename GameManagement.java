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
<<<<<<< Updated upstream
=======
    public int localPlayerNum = 1;  // TODO: Temporary value for testing, should use actual player number
    public int port = 1234;
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
=======
        resetBoard();
        gui.unlockButtons();

        if(isServer){
            server.sendMessage((Object)setArray(arrP1), 1);
            server.sendMessage((Object)setArray(arrP2), 2);
            server.sendMessage((Object)setArray(arrP3), 3);
            server.sendMessage((Object)setArray(arrP4), 4);
        }
        
        if(localPlayerNum == 1) {
            try {
                arrP1 = (Integer[])client.receiveMessage();
                System.out.println("arrP1: " + arrP1[0] + " " +  arrP1[1] + " " + arrP1[2]);
            } catch (Exception e) {
                // TODO: handle exception
                System.out.println("did not receive the array properly");
            }
        }
>>>>>>> Stashed changes
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
<<<<<<< Updated upstream
=======
        return Arr;
>>>>>>> Stashed changes
    }

     public void updateBoard(boolean[] arr){
        for (int i = 0; i <arr.length; i++){
            if(arr[i] == true){
                gui.lblArr[i].setIcon(gui.greenDot);
            } else{
                continue;
            }
            
        }
    }

    public void resetBoard(){
       for(int i = 0; i < gui.lblArr.length; i++){
            if(i%5 == 0){
                gui.lblArr[i].setIcon(gui.blackDot);
            }
            else{
            gui.lblArr[i].setIcon(gui.redDot);
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
        return server.getLocalAddress();    // TODO: Old server method, need to fix
    }

    public void actionPerformed(ActionEvent e) {
        
<<<<<<< Updated upstream
        if(e.getSource() == gui.amClientBtn || e.getSource() == gui.amServerBtn){
=======
        if(e.getSource() == gui.makeGuess){
            gui.guessFrame.setVisible(true);
            gui.btnSubmit.setEnabled(false);
        } else if(e.getSource() == gui.startBtn){
            gui.gameHome();
            gui.setupMenu.setVisible(false);
        }else if(e.getSource() == gui.connectBtn){
            /* TODO: Add method to connect to server, the following is the in case of no connection case (Could go in the catch part of try/catch) */
            try {
                client = new Client(gui.addressInputField.getText(), port); // 1234 is the default port used in the server
                /* TODO: Wait for 4 players connected  then call gui.gameHome */
                System.out.println("client created."); // TODO: remove from product deploy version
            } catch (Exception e1) {
                // TODO: handle exception
                gui.errorWindow("The server entered could not be connected to. Please check the entered address and try again.");
            }
        } else if(e.getSource() == gui.amClientBtn || e.getSource() == gui.amServerBtn){
>>>>>>> Stashed changes
            gui.continueBtn.setEnabled(true);
        }

        if(e.getSource() == gui.continueBtn){
        
            if(gui.amServerBtn.isSelected()){

<<<<<<< Updated upstream
                try {
                    server = new Server();  // TODO: Old server method, need to fix
                } catch(Exception error){System.out.println("Server setup failed");}
=======
                try{
                    InetAddress hostAddress = InetAddress.getLocalHost(); 
                    server = new Server(hostAddress, port); 
                    System.out.println("Server started successfully (full address): " + hostAddress.toString() + " friendly address: " + server.serverAddressFormatted);
                } catch (Exception error){
                    System.err.println("Error creating server");
                }
>>>>>>> Stashed changes

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
<<<<<<< Updated upstream
                            server.serverSetup();   // TODO: Old server method, need to fix
                            client.clientSetup();   // TODO: Old client method, need to fix
=======
                            while(server.clientNum < 1) {
                                server.acceptConnection();
                                System.out.println("clientNum: " + server.clientNum); //remove from final production version
                                gui.updatePlayerCount(server.clientNum - 1);
                            }
>>>>>>> Stashed changes
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

<<<<<<< Updated upstream
                Thread tc = new Thread() {
                    public void run(){
                        try{
                            client.clientSetup();   // TODO: Old client method, need to fix
                        }catch(Exception e){
                            System.out.println("Client setup failed");
                        }
                    }
                };

                tc.start();
=======
>>>>>>> Stashed changes
            } else{
                gui.setupMenu.setVisible(false);
                gui.gameHome();
            }
        }
    }
    
}