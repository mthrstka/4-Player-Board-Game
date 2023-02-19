import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetAddress;
import java.util.stream.*;
import java.util.Arrays;

public class GameManagement implements ActionListener{

    private GUI gui;
    private Server server;
    private Client client;
    private boolean isServer = false;
    public static int currentTurn = 1;
    public int playerTurn = 1;
    public int roundNum = 0;
    public int[] playerScores = new int[4];
    public int localPlayerNum = 1;  // TODO: Temporary value for testing, should use actual player number

    public Boolean playerBl[] = new Boolean[16];

    public Integer arrP1[] = new Integer[3];
    public Integer arrP2[] = new Integer[3];
    public Integer arrP3[] = new Integer[3];
    public Integer arrP4[] = new Integer[3];

    public Integer guessArrP1[] = new Integer[20];
    public Integer guessArrP2[] = new Integer[20];
    public Integer guessArrP3[] = new Integer[20];
    public Integer guessArrP4[] = new Integer[20];
    
    public GameManagement() {
        gui = new GUI(this);
    }

    public void nextTurn(){
        currentTurn++;
        playerTurn++;

        if(playerTurn == 5){
            playerTurn = 1;
        }

        gui.updatePlayerTurn(currentTurn);

        if(isServer){
            checkWin(1, guessArrP1);
            checkWin(2, guessArrP2);
            checkWin(3, guessArrP3);
            checkWin(4, guessArrP4);
        }
    }

    public void newRound() {

        roundNum++;
        currentTurn = 1;
        playerTurn = 1;
        resetBoard();
        gui.unlockButtons();

        if(isServer){
            server.sendMessage((Object)setArray(arrP1), 1);
            server.sendMessage((Object)setArray(arrP2), 2);
            server.sendMessage((Object)setArray(arrP3), 3);
            server.sendMessage((Object)setArray(arrP4), 4);
        }
        
        if(localPlayerNum == 1) {
            arrP1 = (Integer[])client.receiveMessage();
        }

    }

    public Integer[] setArray(Integer[] Arr) {
		for (int i = 0; i < 3; i++) {
			//set a temp int from 1-20
			int temp = (int)(Math.random()*20)+1;
			
			//if statement to check if the current temp is in the array to make array unique
			if (Arrays.asList(Arr).contains(temp)) {
				i--;
			} else {
				Arr[i] = temp;
				System.out.print(Arr[i] + " ");
			}
		}

        return Arr;

    }

     public void updateBoard(boolean[] arr) {
        for (int i = 0; i <arr.length; i++){
            if(arr[i] == true){
                gui.lblArr[i].setIcon(gui.greenDot);
            } else{
                continue;
            }
        }
    }

    public void resetBoard() {
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
    public void checkWin(int player, Integer[] Arr) {
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
    	}
    }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == gui.makeGuess){
            gui.guessFrame.setVisible(true);
            gui.btnSubmit.setEnabled(false);
        } else if(e.getSource() == gui.startBtn){
            gui.gameHome();
            gui.setupMenu.setVisible(false);
        }else if(e.getSource() == gui.connectBtn){
            /* TODO: Add method to connect to server, the following is the in case of no connection case (Could go in the catch part of try/catch) */
            try {
                client = new Client(gui.addressInputField.getText(), 1234); // 1234 is the default port used in the server
                System.out.println("client created."); // TODO: remove from product deploy version
            } catch (Exception e1) {
                // TODO: handle exception
                gui.errorWindow("The server entered could not be connected to. Please check the entered address and try again.");
            }
        } else if(e.getSource() == gui.amClientBtn || e.getSource() == gui.amServerBtn){
            gui.continueBtn.setEnabled(true);

        } else if(e.getSource() == gui.continueBtn){
        
            if(gui.amServerBtn.isSelected()){

                try{
                    InetAddress hostAddress = InetAddress.getLocalHost(); 
                    server = new Server(hostAddress, 1234); 
                    System.out.println("Server started successfully (full address): " + hostAddress.toString() + " friendly address: " + server.serverAddressFormatted);
                } catch (Exception error){
                    System.err.println("Error creating server");
                }

                gui.switchCard("server");
                gui.setAddress(server.serverAddressFormatted);
                isServer = true;
                gui.updatePlayerCount(server.clientNum);
                
                for(int i = 0; i < 4; i++){
                    gui.serverPlayerPanel.add(gui.playerConnect[i]);
                }

                Thread ts = new Thread() {
                    public void run(){
                        try{
                            while(server.clientNum < 4) {
                                server.acceptConnection();
                                System.out.println("clientNum: " + server.clientNum); //remove from final production version
                                gui.updatePlayerCount(server.clientNum - 1);
                            }
                        } catch(Exception e){
                            System.out.println("Server setup failed");
                        }
                    }
                };
                ts.start();

            } else if(gui.amClientBtn.isSelected()){

                gui.switchCard("client");

                for(int i = 0; i < 4; i++){
                    gui.clientPlayerPanel.add(gui.playerConnect[i]);
                }

                Thread tc = new Thread() {
                    public void run(){
                        try{
                            //client = new Client();   // TODO: Old client method, need to fix
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

        } else if(e.getSource() == gui.btnSubmit){
			gui.guess = gui.getGuessNumber();
            gui.guessesMade.add(gui.guess);
            gui.lockButtons();
            gui.tglBtn[gui.guess - 1].setSelected(false);
            gui.guessFrame.setVisible(false);
            client.sendGuess(gui.guess, playerTurn);
            nextTurn();

		} else {
            for(int i = 0; i < 20; i++){
                if(e.getSource() == gui.tglBtn[i]) {
                        gui.untoggleButtons(i);
                        gui.tglBtn[i].setSelected(true);
                        gui.btnSubmit.setEnabled(true);
                        return;
                }
            }
	    }        
    }
}