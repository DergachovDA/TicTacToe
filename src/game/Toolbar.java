package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class Toolbar extends JPanel {

    private List<JButton> buttonList;
    private JButton buttonStart = new JButton("Start");
//    private JButton buttonGoodbye = new JButton("Goodbye");

    public Toolbar() {
        LayoutManager flowLayout = new FlowLayout();

        setLayout(flowLayout);

        add(buttonStart, flowLayout);
//        add(buttonGoodbye, flowLayout);

        buttonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
//        buttonGoodbye.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                JOptionPane.showMessageDialog(null, "Goodbye!");
//            }
//        });

    public void setButtons(List<JButton> buttonList) {
        this.buttonList = buttonList;
    }

}