package com.projects;

import javax.swing.*;
import java.awt.*;

public class TextPanel extends JPanel {
    private static final int TILE = 30;
    public GameController controller;
    public JLabel scoreLabel = new JLabel(), lineLabel = new JLabel();

    public TextPanel() {
        setPreferredSize(new Dimension(400, 600));
        setFocusable(true);
        setBackground(new Color(0, 11, 89, 213));
/*
        scoreLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20)); TODO: fix score and line label
        scoreLabel.setText("score: " + controller.getScore());
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);

        lineLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        lineLabel.setText("Line cleared" + controller.getLineCleared());
        lineLabel.setHorizontalAlignment(JLabel.CENTER);

        add(scoreLabel);
        add(lineLabel);
 */
    }
}
