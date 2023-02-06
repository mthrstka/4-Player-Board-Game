import java.awt.event.*;
import java.io.IOException;

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
                }
            }catch(IOException error){
                System.out.println();
            } 
        }
    }
    
}