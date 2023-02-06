import java.awt.*;
import javax.swing.*;

public class GUI extends JFrame {

    GameManagement Listener;

    String title = "Onion Board Game";

    Boolean isServer = false;

    JRadioButton amClientBtn;
    JRadioButton amServerBtn;
    JButton startGame;

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

    public void setupMenu() {

        JFrame setupMenu = new JFrame();
        setupMenu.setLayout(new GridLayout(4, 1));

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