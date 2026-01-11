package com.projects;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Date;

public class TextPanel extends JPanel {
    // private static final int TILE = 30;
    public static JLabel scoreLabel = new JLabel(),timerLabel = new JLabel(), lineLabel = new JLabel();

    public TextPanel() {
        setPreferredSize(new Dimension(400, 600));
        setFocusable(true);
        setBackground(new Color(0, 11, 89, 213));


        scoreLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        scoreLabel.setText("Score: 0");
        scoreLabel.setForeground(new Color(255, 255, 255));
        scoreLabel.setHorizontalAlignment(JLabel.CENTER);

        lineLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        lineLabel.setText("Line cleared: 0");
        lineLabel.setForeground(new Color(255, 255, 255));
        lineLabel.setHorizontalAlignment(JLabel.CENTER);

        timerLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        timerLabel.setText("00:00");
        startTimer(timerLabel);
        timerLabel.setForeground(new Color(255, 255, 255));
        timerLabel.setHorizontalAlignment(JLabel.CENTER);

        add(scoreLabel);
        add(lineLabel);
        add(timerLabel);



    }
    public static void startTimer(JLabel label) {
        final int[] seconds = {0};

        new javax.swing.Timer(1000, e -> {
            seconds[0]++;

            int min = seconds[0] / 60;
            int sec = seconds[0] % 60;

            label.setText(String.format("%02d:%02d", min, sec));
        }).start();
    }
}


