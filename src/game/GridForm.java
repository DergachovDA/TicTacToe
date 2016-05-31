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


    GridForm(Board board, List<JButton> buttonList) {
        this.board = board;
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

                gc.gridx = j;
                gc.gridy = i;

                button.setName(Integer.toString(i + 1) + Integer.toString(j + 1));
                button.setFont(new Font(null, Font.BOLD, 30));
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
                        }

                        if (board.gameFinished()) {
                            board.setStart(false);
                            JOptionPane.showMessageDialog(null, board.getResultGame());
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
}
