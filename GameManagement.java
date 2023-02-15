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
//        client = new Client();

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

    public static void setArray(Integer[] Arr) {
		
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

//     public String getServerAdress() {
//       return server.getLocalAddress();    // TODO: Old server method, need to fix
//     }

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == gui.amClientBtn || e.getSource() == gui.amServerBtn){
            gui.continueBtn.setEnabled(true);

        } else if(e.getSource() == gui.continueBtn){
        
            if(gui.amServerBtn.isSelected()){

                try {
                    // server = new Server();  // TODO: Old server method, need to fix
                } catch(Exception error){System.out.println("Server setup failed");}

                gui.card.show(gui.setupMenu.getContentPane(), "server");
                gui.addressBar.setText("<html><p text-align: center>Your server address is:</p><br /><h1 text-align: center>" + /* getServerAdress() + */
                "</h1><br /><p text-align: center;>All other players should join using this address.</p></html>");
                isServer = true;
                
                gui.serverPlayerPanel.add(gui.p1Connect);        // moves player panel to active card
                gui.serverPlayerPanel.add(gui.p2Connect);
                gui.serverPlayerPanel.add(gui.p3Connect);
                gui.serverPlayerPanel.add(gui.p4Connect);
                Thread ts = new Thread() {
                    public void run(){
                        try{
                            // server.serverSetup();   // TODO: Old server method, need to fix
                            // client.clientSetup();   // TODO: Old client method, need to fix
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
                            // client.clientSetup();   // TODO: Old client method, need to fix
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
			System.out.println(gui.guess);	// TODO: test output, remove later
		} else {
            for(int i = 0; i < 20; i++){
                if(e.getSource() == gui.tglBtn[i]) {
                        gui.untoggleButtons(i);
                        gui.tglBtn[i].setSelected(true);
                        return;
                }
            }
	    }
    }
    
}