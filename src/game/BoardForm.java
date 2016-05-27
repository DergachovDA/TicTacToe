package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardForm extends JPanel {

    private JButton button11;
    private JButton button12;
    private JButton button13;
    private JButton button21;
    private JButton button22;
    private JButton button23;
    private JButton button31;
    private JButton button32;
    private JButton button33;

    BoardForm(Board board) {
        Dimension dimension = new Dimension();
        dimension.width = 100;
        dimension.height = 100;

        button11 = new JButton(" ");
        button12 = new JButton(" ");
        button13 = new JButton(" ");
        button21 = new JButton(" ");
        button22 = new JButton(" ");
        button23 = new JButton(" ");
        button31 = new JButton(" ");
        button32 = new JButton(" ");
        button33 = new JButton(" ");

        button11.setPreferredSize(dimension.getSize());
        button12.setPreferredSize(dimension.getSize());
        button13.setPreferredSize(dimension.getSize());
        button21.setPreferredSize(dimension.getSize());
        button22.setPreferredSize(dimension.getSize());
        button23.setPreferredSize(dimension.getSize());
        button31.setPreferredSize(dimension.getSize());
        button32.setPreferredSize(dimension.getSize());
        button33.setPreferredSize(dimension.getSize());


        LayoutManager layoutManager = new GridBagLayout();
        setLayout(layoutManager);

        GridBagConstraints gc = new GridBagConstraints();
        gc.gridx = 0;
        gc.gridy = 0;
        add(button11, gc);

        gc.gridx = 1;
        gc.gridy = 0;
        add(button12, gc);

        gc.gridx = 2;
        gc.gridy = 0;
        add(button13, gc);

        gc.gridx = 0;
        gc.gridy = 1;
        add(button21, gc);

        gc.gridx = 1;
        gc.gridy = 1;
        add(button22, gc);

        gc.gridx = 2;
        gc.gridy = 1;
        add(button23, gc);

        gc.gridx = 0;
        gc.gridy = 2;
        add(button31, gc);

        gc.gridx = 1;
        gc.gridy = 2;
        add(button32, gc);

        gc.gridx = 2;
        gc.gridy = 2;
        add(button33, gc);

        button11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button11.setText("X");
            }
        });

    }

}
