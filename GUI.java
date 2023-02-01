import javax.swing.*;

public class GUI extends JFrame {

    GameManagement Listener = new GameManagement(this);
    String title = "Onion Board Game";

    Boolean isServer = false;

    JButton amClientBtn;
    JButton amServerBtn;

    public GUI() {
        setupMenu();
    }

    public void setupMenu() {

        JFrame setupMenu = new JFrame();

        setupMenu.setTitle(title + " - Setup");
        setupMenu.setSize(500, 500);

        JLabel topTxt = new JLabel("Welcome to the " + title);
        JLabel instructionTxt = new JLabel("Set up game as:");

        JPanel p1 = new JPanel();
        JPanel p2 = new JPanel();
        JPanel p3 = new JPanel();

        amServerBtn = new JButton();
        amClientBtn = new JButton();

        p1.add(topTxt);
        p2.add(instructionTxt);
        p3.add(amServerBtn, amClientBtn);

        setupMenu.add(p1);
        setupMenu.add(p2);
        setupMenu.add(p3);

        setupMenu.setVisible(true);

    }

}