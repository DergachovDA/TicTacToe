package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class GridForm extends JPanel {

    private Board board;
    private JTextArea textArea;
    private List<JButton> buttonList;


    GridForm(Board board, List<JButton> buttonList, Statistics statistics, JLabel label) {
        this.board = board;
        this.buttonList = buttonList;

        Dimension dimension = new Dimension();
        dimension.width = 150;
        dimension.height = 150;

        LayoutManager layoutManager = new GridBagLayout();
        setLayout(layoutManager);
        GridBagConstraints gc = new GridBagConstraints();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();

                button.setPreferredSize(dimension);

                gc.gridx = j;
                gc.gridy = i;

                button.setName(Integer.toString(i + 1) + Integer.toString(j + 1));
                button.setFont(new Font(null, Font.BOLD, 72));
                add(button, gc);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (!board.getStart()) return;

                        JButton btn = (JButton) e.getSource();
                        String move = btn.getName();

                        if (board.makeMove(move)) {
                            Player player = board.getCurrentPlayer();
                            char type = player.getType();
                            btn.setText(String.valueOf(type));
                        } else {
                            label.setText("Input incorrect! Repeat your move.");
                        }

                        if (board.gameFinished()) {
                            board.setStart(false);
                            addNewStatistics(board, statistics);
                            label.setText(board.getResultGame());
                            JOptionPane.showMessageDialog(null, board.getResultGame());
                        } else {
                            label.setText("Player " + board.getNextPlayer() + " move...");
                        }
                    }
                });

                buttonList.add(button);
            }
        }
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }

    private static void addNewStatistics(Board board, Statistics statistics) {
        if (board.getWinner() == null) {
            statistics.addResult(new GameResult(board.getCurrentPlayer(), GameResult.DRAW));
            statistics.addResult(new GameResult(board.getAnotherPlayer(board.getCurrentPlayer()), GameResult.DRAW));
        } else {
            statistics.addResult(new GameResult(board.getWinner(), GameResult.WIN));
            statistics.addResult(new GameResult(board.getLoser(), GameResult.LOSS));
        }
    }
}
