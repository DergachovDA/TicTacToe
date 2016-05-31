package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Toolbar extends JPanel {

    private List<JButton> buttonList;
//    private Boolean start;
    private JButton buttonStart = new JButton("Start a new game");
    private Board board;

    public Toolbar(Board board) {
        this.board = board;
        LayoutManager flowLayout = new FlowLayout();
        setLayout(flowLayout);

        add(buttonStart, flowLayout);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JButton button : buttonList) {
                    button.setText("");
                }
                board.clearBoard();
                board.setStart(true);
            }
        });
    }

    public void setButtons(List<JButton> buttonList) {
        this.buttonList = buttonList;
    }

//    public void setStart(Boolean start) {
//        this.start = start;
//    }
}