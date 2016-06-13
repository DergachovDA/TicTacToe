package game;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class MainForm extends JFrame {

    private JTextArea textArea;
    private JLabel label;

    private Player playerX;
    private Player playerO;
    private Board board;

    public MainForm() {
        super("Game");

        Statistics statistics = Statistics.getInstance();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(950, 600);
        setResizable(false);
        setLocationRelativeTo(null);
        setVisible(true);

//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension screen = toolkit.getScreenSize();
//        int x = screen.width;
//        int y = screen.height;
//        setSize((int)Math.round(x * 0.5), (int)Math.round(y * 0.7));

        LayoutManager layoutManager = new BorderLayout(5, 5);
        setLayout(layoutManager);

        textArea = new JTextArea();
        label = new JLabel("Press \"New game\"...");


        Dimension textAriaSize = textArea.getPreferredSize();
        textAriaSize.width = 350;
        textAriaSize.height = 100;
        textArea.setPreferredSize(textAriaSize);

        Player playerX = new Human("Ivan", Player.X);
        Player playerO = new Human("Anton", Player.O);
        Board board = new Board(playerX, playerO);
        List<JButton> buttonList = new ArrayList<>();

        Toolbar toolbar = new Toolbar(board, statistics, label);
        toolbar.setButtons(buttonList);
        toolbar.setTextArea(textArea);

        GridForm gridForm = new GridForm(board, buttonList, statistics, label);
        gridForm.setTextArea(textArea);


        add(toolbar, BorderLayout.NORTH);
        add(gridForm, BorderLayout.WEST);
        add(textArea, BorderLayout.EAST);
        add(label, BorderLayout.SOUTH);


    }
}