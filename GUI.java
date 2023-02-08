import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.UIManager;
import javax.swing.SwingConstants;


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

        try{
            UIManager.put("Button.background", Color.WHITE);
            UIManager.put("ToolTip.background", Color.WHITE);
        } catch (Exception e){
            System.out.println("Something broke");
        }

        setupMenu();
    }

    public void gameHome(){

       JFrame gameHome = new JFrame();
       gameHome.setSize(500,500);
       gameHome.setDefaultCloseOperation(EXIT_ON_CLOSE);
       gameHome.setLayout(new GridLayout(6,6));

       JLabel lblPlayer1 = new JLabel("Player 1:", SwingConstants.CENTER);         //lbl for Player1 Score
       gameHome.add(lblPlayer1);

       JLabel p1 = new JLabel("      P1");                  //Column header for game board
       p1.setVerticalAlignment(SwingConstants.BOTTOM);      //Set the position of the text to the bottom
       gameHome.add(p1);

       JLabel p2 = new JLabel("      P2");
       p2.setVerticalAlignment(SwingConstants.BOTTOM);
       gameHome.add(p2);

       JLabel p3 = new JLabel("      P3");
       p3.setVerticalAlignment(SwingConstants.BOTTOM);
       gameHome.add(p3);

       JLabel p4 = new JLabel("      P4");
       p4.setVerticalAlignment(SwingConstants.BOTTOM);
       gameHome.add(p4);

      
       JLabel lblPlayer2 = new JLabel("Player 2:", SwingConstants.CENTER);         //lbl for Player2 Score
       gameHome.add(lblPlayer2);

       gameHome.add(new JLabel("P1  ", SwingConstants.RIGHT));  //Row label with text postitioned to right
       ImageIcon img = new ImageIcon("black_dot.png");      //Black dot Image 


       /////JLabel's one through sixteen represents each cell on the game board\\\\\ 
       JLabel one = new JLabel(img);
       JLabel two = new JLabel(img);
       JLabel three = new JLabel(img);
       JLabel four = new JLabel(img);

       gameHome.add(one);
       gameHome.add(two);
       gameHome.add(three);
       gameHome.add(four);

       gameHome.add(new JLabel(""));
       gameHome.add(new JLabel("P2  ", SwingConstants.RIGHT));

       JLabel five = new JLabel(img);
       JLabel six = new JLabel(img);
       JLabel seven = new JLabel(img);
       JLabel eight = new JLabel(img);

       gameHome.add(five);
       gameHome.add(six);
       gameHome.add(seven);
       gameHome.add(eight);

       gameHome.add(new JLabel(""));
       gameHome.add(new JLabel("P3  ", SwingConstants.RIGHT));

       JLabel nine = new JLabel(img);
       JLabel ten = new JLabel(img);
       JLabel eleven = new JLabel(img);
       JLabel twelve = new JLabel(img);

       gameHome.add(nine);
       gameHome.add(ten);
       gameHome.add(eleven);
       gameHome.add(twelve);

       gameHome.add(new JLabel(""));
       gameHome.add(new JLabel("P4  ", SwingConstants.RIGHT));

       JLabel thirteen = new JLabel(img);
       JLabel fourteen = new JLabel(img);
       JLabel fifteen = new JLabel(img);
       JLabel sixteen = new JLabel(img);

       gameHome.add(thirteen);
       gameHome.add(fourteen);
       gameHome.add(fifteen);
       gameHome.add(sixteen);

       gameHome.add(new JLabel(""));
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
        setupMenu.setLayout(new GridLayout(4, 1));
        setupMenu.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setupMenu.setTitle(title + " - Setup");
        setupMenu.setSize(500, 500);

        JLabel topTxt = new JLabel("Welcome to the " + title);
        JLabel instructionTxt = new JLabel("Join the game as the:");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();
        JPanel p4 = new JPanel();

        ButtonGroup scToggle = new ButtonGroup();
        amServerBtn = new JRadioButton("Host");
        amClientBtn = new JRadioButton("Client");
        amServerBtn.setToolTipText("Select if you will be hosting the game, only one player should choose this option.");
        amClientBtn.setToolTipText("Select if you will be joining someone else's game, all players except host should choose this.");

        scToggle.add(amServerBtn);
        scToggle.add(amClientBtn);

        startGame = new JButton("Start Game!");

        p1.add(topTxt);
        p2.add(instructionTxt);
        p3.add(amServerBtn);
        p3.add(amClientBtn);
        p4.add(startGame);

        setupMenu.add(p1);
        setupMenu.add(p2);
        setupMenu.add(p3);
        setupMenu.add(p4);

        setupMenu.setVisible(true);

        startGame.addActionListener(Listener);
    }
}