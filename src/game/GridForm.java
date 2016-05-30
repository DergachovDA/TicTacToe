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
    private boolean start;
    private List<JButton> buttonList;


    GridForm(Board board, List<JButton> buttonList) {
        this.board = board;
        start = false;
        this.buttonList = buttonList;

        Dimension dimension = new Dimension();
        dimension.width = 100;
        dimension.height = 100;

        LayoutManager layoutManager = new GridBagLayout();
        setLayout(layoutManager);
        GridBagConstraints gc = new GridBagConstraints();

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                JButton button = new JButton();

                button.setPreferredSize(dimension);

                gc.gridx = i;
                gc.gridy = j;

                button.setName(Integer.toString(i + 1) + Integer.toString(j + 1));

                add(button, gc);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {

                        if (!start) return;

                        JButton btn = (JButton) e.getSource();
                        String move = btn.getName();

                        if (board.makeMove(move)) {
                            Player player = board.getNextPlayer();
                            char type = player.getType();
                            btn.setText(String.valueOf(type));
                        }

                        if (board.gameFinished()) {
                            JOptionPane.showMessageDialog(null, board.getWinnerPlayer());
                        }
                    }
                });

                buttonList.add(button);
            }
        }
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
