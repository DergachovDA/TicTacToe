package game;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class MainForm extends JFrame{

    private JTextArea textArea;
    private JButton button;
//    private JTextArea textArea2;

    public MainForm() {
        super("Basic Layouts");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screen = toolkit.getScreenSize();

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        int x = screen.width;
        int y = screen.height;
        setSize((int)Math.round(x * 0.5), (int)Math.round(y * 0.6));

        setLocationRelativeTo(null);
        setVisible(true);

        LayoutManager layoutManager = new BorderLayout(5 ,5);
        setLayout(layoutManager);

        textArea = new JTextArea();
//        button = new JButton("Click Me");

        Dimension textAriaSize = textArea.getPreferredSize();
        textAriaSize.width = 300;
        textAriaSize.height = 100;
        textArea.setPreferredSize(textAriaSize);

        List<JButton> buttonList = new ArrayList<>();
        Toolbar toolbar = new Toolbar();
        toolbar.setButtons(buttonList);

        Player playerX = new Human('X');
        Player playerO = new Human('O');
        Board board = new Board(playerX, playerO);
        GridForm gridForm = new GridForm(board, buttonList);
        gridForm.setTextArea(textArea);



        add(toolbar, BorderLayout.NORTH);
        add(gridForm, BorderLayout.WEST);
        add(textArea, BorderLayout.EAST);


    }
}