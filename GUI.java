import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;


public class GUI extends JFrame {

    GameManagement Listener;
    String title = "Onion Board Game";
    Boolean isServer = false;
    JRadioButton amClientBtn, amServerBtn;
    JButton continueBtn, startBtn;
    JFrame setupMenu;
    CardLayout card = new CardLayout();
    JLabel addressBar;
    JLabel p1Connect, p2Connect, p3Connect, p4Connect;
    JTextField addressInputField;
    JPanel serverPlayerPanel, clientPlayerPanel; // Player panels made seperate so we will only have to edit one of them.

    public GUI(GameManagement obj) {

        Listener = obj;

        try{    // Sets the style to that of the system

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
        ImageIcon blackDot = new ImageIcon("img/black_dot.png");
        Image imageBlack = blackDot.getImage();
        Image newImageBlack = imageBlack.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        blackDot = new ImageIcon(newImageBlack);


        ImageIcon redDot = new ImageIcon("img/red_dot.png");
        Image imageRed = redDot.getImage();
        Image newImageRed = imageRed.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        redDot = new ImageIcon(newImageRed);

        ImageIcon greenDot = new ImageIcon("img/green_dot.png");
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
        setupMenu.setLayout(card);
        setupMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupMenu.setTitle(title + " - Setup");
        setupMenu.setSize(500, 500);

        p1Connect = new JLabel("Player 1: Waiting...", SwingConstants.CENTER);
        p2Connect = new JLabel("Player 2: Waiting...", SwingConstants.CENTER);
        p3Connect = new JLabel("Player 3: Waiting...", SwingConstants.CENTER);
        p4Connect = new JLabel("Player 4: Waiting...", SwingConstants.CENTER);


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

        continueBtn = new JButton("Continue");
        //startGame.setEnabled(false);                 // TODO: Uncomment before Monday

        p1.add(topTxt);
        p2.add(instructionTxt);
        p3.add(amServerBtn);
        p3.add(amClientBtn);
        p4.add(p2);
        p4.add(p3);
        p5.add(continueBtn);

        cMenu.add(p1, BorderLayout.NORTH);
        cMenu.add(p4, BorderLayout.CENTER);
        cMenu.add(p5, BorderLayout.SOUTH);


        /* Card 2 - Server Menu */

        JPanel cServer = new JPanel();
        cServer.setLayout(new BorderLayout());

        JPanel serverPanel1 = new JPanel();
        JPanel serverPanel2 = new JPanel();
        serverPlayerPanel = new JPanel();
        JPanel serverPanel4 = new JPanel();

        serverPanel1.setLayout(new GridLayout(2, 1));
        serverPlayerPanel.setLayout(new GridLayout(2, 2));

        addressBar = new JLabel("Server not initialized", SwingConstants.CENTER);
        serverPanel2.add(addressBar);

        startBtn = new JButton("Start Game");
        startBtn.setEnabled(false);
        serverPanel4.add(startBtn);

        serverPanel1.add(serverPanel2);
        serverPanel1.add(serverPlayerPanel);

        cServer.add(serverPanel1, BorderLayout.CENTER);
        cServer.add(serverPanel4, BorderLayout.SOUTH);


        /* Card 3 - Client Menu */

        JPanel cClient = new JPanel();
        cClient.setLayout(new BorderLayout());

        JLabel clientLabel = new JLabel("Enter the server address to connect to:", SwingConstants.CENTER);
        addressInputField = new JTextField(30);

        JPanel clientPanel1 = new JPanel();
        JPanel clientPanel2 = new JPanel();
        clientPlayerPanel = new JPanel();
        JPanel clientPanel4 = new JPanel();

        clientPanel2.add(clientLabel);
        clientPanel2.add(addressInputField);
        clientPlayerPanel.setLayout(new GridLayout(2, 2));

        clientPanel1.setLayout(new GridLayout(2, 1));

        clientPanel1.add(clientPanel2);
        clientPanel1.add(clientPlayerPanel);

        cClient.add(clientPanel1, BorderLayout.CENTER);
        cClient.add(clientPanel4, BorderLayout.SOUTH);  // For later adding a cancel button to both server and client cards

        setupMenu.add(cMenu, "menu");
        setupMenu.add(cServer, "server");
        setupMenu.add(cClient, "client");

        setupMenu.setVisible(true);

        amServerBtn.addActionListener(Listener);
        amClientBtn.addActionListener(Listener);
        continueBtn.addActionListener(Listener);
        startBtn.addActionListener(Listener);
    }
}