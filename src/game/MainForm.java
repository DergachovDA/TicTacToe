package game;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MainForm extends JFrame{

    private JTextArea textArea;
    private JLabel label;
    private Player playerX;
    private Player playerO;
    private Board board;

    public MainForm() {
        super("Game");

        Statistics statistics = Statistics.getInstance();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension screen = toolkit.getScreenSize();
//        int x = screen.width;
//        int y = screen.height;
//        setSize((int)Math.round(x * 0.5), (int)Math.round(y * 0.7));
        setSize(900, 600);

        setLocationRelativeTo(null);
        setVisible(true);

        LayoutManager layoutManager = new BorderLayout(5 ,5);
        setLayout(layoutManager);

        textArea = new JTextArea();

        Dimension textAriaSize = textArea.getPreferredSize();
        textAriaSize.width = 300;
        textAriaSize.height = 100;
        textArea.setPreferredSize(textAriaSize);

        Player playerX = new Human('X');
        Player playerO = new Human('O');
        Board board = new Board(playerX, playerO);
        List<JButton> buttonList = new ArrayList<>();

        Toolbar toolbar = new Toolbar(board, statistics);
        toolbar.setButtons(buttonList);
        toolbar.setTextArea(textArea);

        GridForm gridForm = new GridForm(board, buttonList, statistics);
        gridForm.setTextArea(textArea);


        add(toolbar, BorderLayout.NORTH);
//        add(label, BorderLayout.WEST);
        add(gridForm, BorderLayout.WEST);
        add(textArea, BorderLayout.EAST);


    }
}