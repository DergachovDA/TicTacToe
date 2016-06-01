package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Toolbar extends JPanel {

    private List<JButton> buttonList;
    private Board board;
    private JTextArea textArea;

    private JButton buttonStart = new JButton("New game");
    private JLabel labelStat = new JLabel("    Results:");
    private JButton buttonStatAll = new JButton("all");
    private JButton buttonStatWin = new JButton("winers");
    private JButton buttonStatLoss = new JButton("losses");
    private JButton buttonStatYear = new JButton("year");
    private JButton buttonStatMonth = new JButton("month");
    private JButton buttonStatDay = new JButton("day");

    public Toolbar(Board board, Statistics statistics, JLabel label) {
        this.board = board;
        LayoutManager flowLayout = new FlowLayout();
        setLayout(flowLayout);

        add(buttonStart, flowLayout);
        add(labelStat, flowLayout);
        add(buttonStatAll, flowLayout);
        add(buttonStatWin, flowLayout);
        add(buttonStatLoss, flowLayout);
        add(buttonStatYear, flowLayout);
        add(buttonStatMonth, flowLayout);
        add(buttonStatDay, flowLayout);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (JButton button : buttonList) {
                    button.setText("");
                }
                board.clearBoard();
                board.setStart(true);
                label.setText("Player " + board.getNextPlayer() + " move...");
            }
        });

        buttonStatAll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText(statistics.toString());
            }
        });

        buttonStatWin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText(statistics.getAllWins().toString());
            }
        });

        buttonStatLoss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText(statistics.getAllLosses().toString());
            }
        });

        buttonStatYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText(statistics.getForYear().toString());
            }
        });

        buttonStatMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText(statistics.getForMonth().toString());
            }
        });

        buttonStatDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea.setText(statistics.getForDay().toString());
            }
        });
    }

    public void setButtons(List<JButton> buttonList) {
        this.buttonList = buttonList;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }


}