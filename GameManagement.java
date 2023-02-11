import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;
import java.util.stream.*;

import sun.awt.www.content.audio.x_aiff;

public class GameManagement implements ActionListener{

    private GUI gui;
    private Server server;
    private Client client;
    private boolean isServer = false;
    public static int currentTurn;

    public GameManagement() {

        gui = new GUI(this);
        client = new Client();
        
        

    }


    //not sure where these should go? GE
    public static Boolean playerBl[] = new Boolean[16];
    public static Integer arrP1[] = new Integer[3];
    public static Integer arrP2[] = new Integer[3];
    public static Integer arrP3[] = new Integer[3];
    public static Integer arrP4[] = new Integer[3];
    
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
    
    
    
    
    
    
    
    
    
    

    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == gui.startGame){
            
            try{
                if(gui.amServerBtn.isSelected()){
                    server = new Server();
                    isServer = true;
                    server.serverSetup();
                    client.clientSetup();
                } else if(gui.amClientBtn.isSelected()){
                    client.clientSetup();
                } else{
                    gui.setupMenu.setVisible(false);
                    gui.gameHome();
                }
            }catch(IOException error){
                System.out.println();
            } 
        }
    }
    
    
    
}