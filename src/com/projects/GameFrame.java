package com.projects;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {


    public GameFrame() {
        setTitle("Mon Jeu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GamePanel gamePanel = new GamePanel();
        TextPanel textPanel = new TextPanel();

        add(textPanel, BorderLayout.EAST);
        add(gamePanel,  BorderLayout.WEST);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
