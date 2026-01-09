package com.projects;

import javax.swing.*;
import java.awt.*;

import static java.awt.AWTEventMulticaster.add;

public class Board extends JPanel {
    public JLabel[][] grid;
    JLabel labelSquare;
    private final int rows;
    private final int cols;


    public Board(int rows, int cols) {

        this.rows = rows;
        this.cols = cols;
        this.grid = new JLabel[rows][cols];

        setLayout(new GridLayout(rows, cols));
        setBackground(Color.white);
        setBounds(30,10,311, 680);

        initGrid();
    }


    private void initGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++){
                labelSquare = new JLabel("", SwingConstants.CENTER);
                labelSquare.setOpaque(true);
                labelSquare.setBackground(Color.black);
                labelSquare.setBorder(BorderFactory.createLineBorder(Color.white));
                labelSquare.setText("<html><font size ='3' color=white>" + '(' + i + ',' + j + ')');

                grid[i][j] = labelSquare;
                add(labelSquare);

            }
        }
    }

    public JLabel[][] getGrid() {
        return this.grid;
    }

    public JLabel getLabelSquare(int row, int col) {
        return this.grid[row][col];
    }
}
