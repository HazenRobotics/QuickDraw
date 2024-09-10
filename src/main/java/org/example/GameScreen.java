package org.example;

import javax.swing.*;
import java.awt.*;

public class GameScreen {
    private static final JFrame SYSTEM = new JFrame("");
    private static final JLabel LABEL = new JLabel();
    private static final JLabel TEXT1 = new JLabel();
    private static final JLabel TEXT2 = new JLabel();
    public GameScreen() {

        SYSTEM.add(TEXT1);
        TEXT1.setFont(new Font("Lato", Font.BOLD, 20));
        TEXT1.setHorizontalAlignment(0);
        TEXT1.setBounds(0, 30, 1920, 20);

        SYSTEM.add(TEXT2);
        TEXT2.setFont(new Font("Lato", Font.BOLD, 20));
        TEXT2.setHorizontalAlignment(0);
        TEXT2.setBounds(0, 0, 1920, 20);

        SYSTEM.add(LABEL);
        LABEL.setIcon(new ImageIcon("ui_images/ui.png"));
        SYSTEM.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        SYSTEM.getContentPane().setBackground(Color.GRAY);
        SYSTEM.setVisible(true);
        SYSTEM.setExtendedState(JFrame.MAXIMIZED_BOTH);
        SYSTEM.pack();


    }
}
