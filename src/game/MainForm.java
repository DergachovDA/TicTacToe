package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame{

    public MainForm(Board board) {
        super("Game");

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

        add(new BoardForm(board), BorderLayout.CENTER);

    }
}