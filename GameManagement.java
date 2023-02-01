import java.awt.event.*;
import java.io.IOException;

public class GameManagement implements ActionListener{

    GUI gui;
    Server server;
    Client client;
    boolean isServer = false;

    public GameManagement(GUI g) {

        gui = g;
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