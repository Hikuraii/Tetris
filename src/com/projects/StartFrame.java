package com.projects;

import javax.swing.*;

public class StartFrame extends JFrame {

    public StartFrame() {

        setTitle("Tetris");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StartPanel startPanel = new StartPanel();

        add(startPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);

        startPanel.startButton.addActionListener(e -> startGame());

    }
    private void startGame() {
        GameFrame gameFrame = new GameFrame();
        dispose();
    }
}

