package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
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
    private JLabel labelSort = new JLabel(" Sort:");
    private JButton buttonSortByName = new JButton("by name");
    private JButton buttonSortByWin = new JButton("by win");
    private JButton buttonSortByLoss = new JButton("by loss");

    public Toolbar(final Board board, final Statistics statistics, final JLabel label) {
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
        add(labelSort, flowLayout);
        add(buttonSortByName, flowLayout);
        add(buttonSortByWin, flowLayout);
        add(buttonSortByLoss, flowLayout);

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
                try {
                    textArea.setText(statistics.getAllWins().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonStatLoss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    textArea.setText(statistics.getAllLosses().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonStatYear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    textArea.setText(statistics.getForYear().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonStatMonth.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    textArea.setText(statistics.getForMonth().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonStatDay.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    textArea.setText(statistics.getForDay().toString());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        });

        buttonSortByName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                statistics.sortByFirstnamePlayer();
                textArea.setText(statistics.toString());
            }
        });

        buttonSortByWin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                statistics.sortByWin();
                textArea.setText(statistics.toString());
            }
        });

        buttonSortByLoss.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                statistics.sortByLoss();
                textArea.setText(statistics.toString());
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