import java.awt.*;
import javax.swing.*;


public class GUI extends JFrame {

    GameManagement Listener;

    String title = "Onion Board Game";

    Boolean isServer = false;

    JRadioButton amClientBtn;
    JRadioButton amServerBtn;
    JButton startGame;
    JFrame setupMenu;

    public GUI(GameManagement obj) {

        Listener = obj;

        try{    // Sets the style to that of the native system

            String os = System.getProperty("os.name");
            if(os.toLowerCase().contains("windows"))
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            else if(os.toLowerCase().contains("mac"))
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            else if(os.toLowerCase().contains("linux"))
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            else
                throw new ClassNotFoundException("Did not recognise reported OS (" + os + ")");

        } catch (Exception e){
            System.out.println("Could not set native look and feel - " + e.getMessage());
            UIManager.put("Button.background", Color.WHITE);
            UIManager.put("ToolTip.background", Color.WHITE);
        }

        setupMenu();
    }

    public void updateBoard(boolean[] arr){
        for (int i = 0; i <arr.length; i++){
            if(arr[i] == true){
                //sett i + 1 JLabel to green
            } else{
                continue;
            }
            
        }
    }

    public void gameHome(){

       JFrame gameHome = new JFrame();
       gameHome.setSize(500,500);
       gameHome.setDefaultCloseOperation(EXIT_ON_CLOSE);
       gameHome.setLayout(new GridLayout(6,6));
       gameHome.setTitle(title);

        //first row
       JLabel lblPlayer1 = new JLabel("Player 1:", SwingConstants.CENTER);         //lbl for Player1 Score
       gameHome.add(lblPlayer1);

       JLabel p1 = new JLabel("P1", SwingConstants.CENTER);                  //Column header for game board
       p1.setVerticalAlignment(SwingConstants.BOTTOM);      //Set the position of the text to the bottom
       gameHome.add(p1);

       JLabel p2 = new JLabel("P2", SwingConstants.CENTER);
       p2.setVerticalAlignment(SwingConstants.BOTTOM);
       gameHome.add(p2);

       JLabel p3 = new JLabel("P3", SwingConstants.CENTER);
       p3.setVerticalAlignment(SwingConstants.BOTTOM);
       gameHome.add(p3);

       JLabel p4 = new JLabel("P4", SwingConstants.CENTER);
       p4.setVerticalAlignment(SwingConstants.BOTTOM);
       gameHome.add(p4);

      
       JLabel lblPlayer2 = new JLabel("Player 2:", SwingConstants.CENTER);         //lbl for Player2 Score
       gameHome.add(lblPlayer2);

   
        /////JLabel's one through sixteen represents each cell on the game board\\\\\ 
        //Second Row
        ImageIcon blackDot = new ImageIcon("black_dot.png");
        Image imageBlack = blackDot.getImage();
        Image newImageBlack = imageBlack.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        blackDot = new ImageIcon(newImageBlack);


        ImageIcon redDot = new ImageIcon("red_dot.png");
        Image imageRed = redDot.getImage();
        Image newImageRed = imageRed.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        redDot = new ImageIcon(newImageRed);

        ImageIcon greenDot = new ImageIcon("green_dot.png");
        Image imageGreen = greenDot.getImage();
        Image newImageGreen = imageGreen.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        greenDot = new ImageIcon(newImageGreen);


        JLabel[] lblArr = new JLabel[16];
        int count = 1;
        int arrIndex = 0;
        for(int i = 0; i < 24; i++){
            if(i%6 == 0){
                JLabel lbl = new JLabel("P" + Integer.toString(count), SwingConstants.RIGHT);
                count++;
                gameHome.add(lbl);
                continue;
            } else if(i%6 == 5){
                JLabel lbl = new JLabel("");
                gameHome.add(lbl);
                continue;
            } else {
                if(arrIndex%5 == 0){
                JLabel lbl = new JLabel(blackDot);
                lblArr[arrIndex] = lbl;
                arrIndex++;
                gameHome.add(lbl);
                continue;

                } else {
                JLabel lbl = new JLabel(redDot);
                lblArr[arrIndex] = lbl;
                arrIndex++;
                gameHome.add(lbl);
                continue;
                }
            }
        }

        //sixth row
       JLabel lblPlayer3 = new JLabel("Player 3:", SwingConstants.CENTER);     //lbl for Player3 score
       gameHome.add(lblPlayer3);

       gameHome.add(new JLabel(""));            //empty Jlabels along the bottom of the GUI
       gameHome.add(new JLabel(""));
       gameHome.add(new JLabel(""));
       gameHome.add(new JLabel(""));

       JLabel lblPlayer4 = new JLabel("Player 4:", SwingConstants.CENTER);    //lbl for Player 4 score
       gameHome.add(lblPlayer4);
     

            
    

       gameHome.setVisible(true);

    }

    public void setupMenu() {

        setupMenu = new JFrame();
        setupMenu.setLayout(new CardLayout());
        setupMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupMenu.setTitle(title + " - Setup");
        setupMenu.setSize(500, 500);


        /* Card 1 - Initial Menu */

        JPanel cMenu = new JPanel();
        cMenu.setLayout(new BorderLayout());

        JLabel topTxt = new JLabel("<html><h1>Welcome to the " + title + "!</h1></html>");
        JLabel instructionTxt = new JLabel("<html>Join the game as the:<br /><em>(Hover for more info)</em></html>"); // Yes! We can use HTML stuffs!

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();
        JPanel p5 = new JPanel();

        p3.setLayout(new GridLayout(2, 1));
        p4.setLayout(new FlowLayout());

        ButtonGroup scToggle = new ButtonGroup();
        amServerBtn = new JRadioButton("Host");
        amClientBtn = new JRadioButton("Client");
        amServerBtn.setToolTipText("<html><em>Select if you will be hosting the game, only one player should choose this option.</em></html>");
        amClientBtn.setToolTipText("<html><em>Select if you will be joining someone else's game, all players except host should choose this.</em></html>");

        scToggle.add(amServerBtn);
        scToggle.add(amClientBtn);

        startGame = new JButton("Start Game!");
        //startGame.setEnabled(false);                 //Uncomment before Monday

        p1.add(topTxt);
        p2.add(instructionTxt);
        p3.add(amServerBtn);
        p3.add(amClientBtn);
        p4.add(p2);
        p4.add(p3);
        p5.add(startGame);

        cMenu.add(p1, BorderLayout.NORTH);
        cMenu.add(p4, BorderLayout.CENTER);
        cMenu.add(p5, BorderLayout.SOUTH);


        /* Card 2 - Server Menu */

        JPanel cServer = new JPanel();
        cServer.setLayout(new BorderLayout());

        


        setupMenu.add(cMenu);
        setupMenu.setVisible(true);

        amServerBtn.addActionListener(Listener);
        amClientBtn.addActionListener(Listener);
        startGame.addActionListener(Listener);
    }
}