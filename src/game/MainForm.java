package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainForm extends JFrame{

    private JLabel textLabel;
    private JButton startGame;
    Statistics statistics = Statistics.getInstance();
    Player playerX;
    Player playerO;
    Board board;


    public MainForm() {
        super("Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        Dimension screen = toolkit.getScreenSize();
//        int x = screen.width;
//        int y = screen.height;
        setSize(350, 300);
        LayoutManager layoutManager = new BorderLayout(5 ,5);
        setLayout(layoutManager);

        startGame = new JButton("Start game");
        textLabel = new JLabel();

        startGame.setSize(50, 50);
        textLabel.setSize(50, 300);

        add(startGame, BorderLayout.NORTH);

        game();
    }

    private void game() {
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playerX = new Human('X');
                playerO = new Human('O');
                board = new Board(playerX, playerO);
                textLabel.setText("Player " + board.getCurrentPlayer() + " move...");
                add(textLabel, BorderLayout.NORTH);
                remove(startGame);
                add(new BoardForm(board), BorderLayout.SOUTH);
            }
        });
    }

    public void

    public static void main(String[] args) {
        MainForm app = new MainForm();
        app.setVisible(true);
//        app.pack();
    }
}