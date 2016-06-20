package game;

import javax.swing.*;

public class MainGUI {
    public static void main(String[] args) {
        Statistics.getInstance();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainForm();
            }
        });
    }
}
