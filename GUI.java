import java.awt.*;
import java.util.List;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class GUI {

    GameManagement Listener;
    String title = "Onion Board Game";
    Boolean isServer = false;
    JFrame gameHome = new JFrame();
    JRadioButton amClientBtn;
    JRadioButton amServerBtn;
    JButton startGame;
    JFrame setupMenu;
    JLabel[] lblArr = new JLabel[16];
    JButton continueBtn, startBtn;
    CardLayout card = new CardLayout();
    JLabel addressBar;
    JLabel p1Connect, p2Connect, p3Connect, p4Connect;
    JTextField addressInputField;
    JPanel serverPlayerPanel, clientPlayerPanel; // Player panels made sep
    ImageIcon blackDot = new ImageIcon("img/black_dot.png");
    ImageIcon redDot = new ImageIcon("img/red_dot.png");
    ImageIcon greenDot = new ImageIcon("img/green_dot.png");

        

    int[] GuessesMade = {1, 5, 14, 19}; // Should probably be pulled from the player object eventually?
    int guess = 0;
    JButton btnSubmit;
	JToggleButton[] tglBtn = new JToggleButton[20];
    JPanel guessWindow;
    JFrame guessFrame;

    public GUI(GameManagement obj) {

        Listener = obj;
        Image imageGreen = greenDot.getImage();
        Image newImageGreen = imageGreen.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        greenDot = new ImageIcon(newImageGreen);
         Image imageBlack = blackDot.getImage();
        Image newImageBlack = imageBlack.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        blackDot = new ImageIcon(newImageBlack);
        Image imageRed = redDot.getImage();
        Image newImageRed = imageRed.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        redDot = new ImageIcon(newImageRed);
       
   

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

        GuessFrame();
        setupMenu();
    }


    public void gameHome(){

      
       gameHome.setSize(500,500);
       gameHome.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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

   
        //ROWS 2-5
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
        setupMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        //startGame.setEnabled(false);                 // TODO: Uncomment before release

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

    public void GuessFrame() {

		guessFrame = new JFrame();
		guessFrame.setTitle("Number Selecter");
		guessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  // TODO: Maybe prevent this from closing unless user uses submit button?
		guessFrame.setBounds(100, 100, 435, 282);
        guessFrame.setSize(400,350);
		JPanel guessWindow;
		guessWindow = new JPanel();
		guessWindow.setBorder(new EmptyBorder(5, 5, 5, 5));

		guessFrame.setContentPane(guessWindow);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] {60, 60, 60, 60, 60};
		gbl_contentPane.rowHeights = new int[] {0, 0, 0, 0, 0, 50, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		guessWindow.setLayout(gbl_contentPane);

		JLabel lblInstructions = new JLabel("Please select your guess number.");
		lblInstructions.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_lblInstructions = new GridBagConstraints();
		gbc_lblInstructions.insets = new Insets(0, 0, 5, 0);
		gbc_lblInstructions.gridwidth = 5;
		gbc_lblInstructions.gridx = 0;
		gbc_lblInstructions.gridy = 0;
		guessWindow.add(lblInstructions, gbc_lblInstructions);

		GridBagConstraints[] gbc_tglBtn = new GridBagConstraints[20];

		for(int i = 0; i < 20; i++){
			tglBtn[i] = new JToggleButton((i + 1) + "");
			tglBtn[i].setFont(new Font("Tahoma", Font.PLAIN, 15));
			gbc_tglBtn[i] = new GridBagConstraints();
			gbc_tglBtn[i].fill = GridBagConstraints.BOTH;
			gbc_tglBtn[i].insets = new Insets(0, 0, 5, 5);
			gbc_tglBtn[i].gridx = i % 5;

			int yPos;

			if(i < 5)
				yPos = 1;
			else if(i < 10)
				yPos = 2;
			else if(i < 15)
				yPos = 3;
			else
				yPos = 4;

			gbc_tglBtn[i].gridy = yPos;

			guessWindow.add(tglBtn[i], gbc_tglBtn[i]);

			tglBtn[i].addActionListener(Listener);
		}

		lockButtons(GuessesMade); 			// Run the lockButtons method with intArray <-- MAY NEED TO BE RELOCATED

		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(Listener);
		
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		GridBagConstraints gbc_btnSubmit = new GridBagConstraints();
		gbc_btnSubmit.gridwidth = 3;
		gbc_btnSubmit.insets = new Insets(0, 0, 0, 5);
		gbc_btnSubmit.gridx = 1;
		gbc_btnSubmit.gridy = 6;
		guessWindow.add(btnSubmit, gbc_btnSubmit);

        guessFrame.setVisible(true);

	}


    /* TODO: All following methods should be considered as something to maybe move to GM in the future? (Specifically getGuessNumber()) */

    public void unlockButtons() {

		for(int i = 0; i < 20; i++)	{

			tglBtn[i].setEnabled(true);

		}

	} // End unlockButtons method

    public void lockButtons(int[] arr) {

    	for (int i = 0; i < arr.length; i++) {

    		System.out.println(arr[i]);

			for(int j = 0; j < 20; j++){
				if(arr[i]-1 == j){
					tglBtn[j].setEnabled(false);
				}
			}
    	} // End for loop
    } // End lockButtons method

    public void untoggleButtons(int num) {

		for(int i = 0; i < 20; i++){
			if(num != i){
				tglBtn[i].setSelected(false);
			}
		}
    }

    public int getGuessNumber() {

		for (int i = 0; i < 20; i++) {

			if (tglBtn[i].isSelected() == true) return i + 1;

		}

		return 0; // If the method hasn't already returned a value by this point, return 0

	}

}