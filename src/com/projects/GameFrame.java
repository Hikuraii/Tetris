package com.projects;

import javax.swing.*;

public class GameFrame extends JFrame {


    public GameFrame() {
        setTitle("Mon Jeu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();

        add(gamePanel);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
