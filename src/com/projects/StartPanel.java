package com.projects;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    private static JLabel moveRulesLabel = new JLabel(), rotateRulesLabel = new JLabel();
    public JButton startButton = new JButton();


    public StartPanel() {
        setPreferredSize(new Dimension(500, 300));
        setBackground(new Color(0, 11, 89, 229));
        setFocusable(true);

        moveRulesLabel.setText("use arrow keys left and right to move left and right (crazy, i know.), and speed up with space.");
        moveRulesLabel.setForeground(new Color(255, 255, 255));
        moveRulesLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        moveRulesLabel.setVerticalAlignment(JLabel.CENTER);
        moveRulesLabel.setHorizontalAlignment(JLabel.CENTER);

        rotateRulesLabel.setText("Use up and down to rotate left and right");
        rotateRulesLabel.setForeground(new Color(255, 255, 255));
        rotateRulesLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        rotateRulesLabel.setHorizontalAlignment(JLabel.CENTER);
        rotateRulesLabel.setVerticalAlignment(JLabel.CENTER);

        startButton.setText("Start");
        startButton.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        startButton.setForeground(new Color(255, 255, 255));
        startButton.setBackground(new Color(248, 255, 30, 208));
        startButton.setOpaque(true);
        startButton.setHorizontalAlignment(JLabel.CENTER);
        startButton.setVerticalAlignment(JLabel.CENTER);

        add(moveRulesLabel);
        add(rotateRulesLabel);
        add(startButton);

    }
}