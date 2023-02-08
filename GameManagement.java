import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.stream.*;

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