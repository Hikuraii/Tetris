package com.projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class GamePanel extends JPanel implements KeyListener {
    JPanel txtUi;
    JLabel labelTest, labelUp, labelDown, labelRight, labelLeft, labelSpace, labelSquare;
    JLabel[][] grid;
    private static final int TILE = 30;
    private final Board board = new Board();
    private final GameController controller;

    public GamePanel() {
        setPreferredSize(new Dimension(Board.COLS * TILE, Board.ROWS * TILE));
        setFocusable(true);
        addKeyListener(this);
        controller = new GameController(board, this::repaint);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Grille
        g.setColor(Color.BLACK);
        int[][] grid = board.getGrid();
        for (int y = 0; y < Board.ROWS; y++) {
            for (int x = 0; x < Board.COLS; x++) {
                if (grid[y][x] == 1) {
                    g.fillRect(x * TILE, y * TILE, TILE, TILE);
                }
            }
        }

        // Pièce active
        Tetromino t = controller.getCurrentTetromino();
        g.setColor(t.getColor());
        int[][] shape = t.getShape();
        for (int y = 0; y < shape.length; y++) {
            for (int x = 0; x < shape[0].length; x++) {
                if (shape[y][x] == 1) {
                    g.fillRect(
                            (t.getX() + x) * TILE,
                            (t.getY() + y) * TILE,
                            TILE,
                            TILE
                    );
                }
            }
        }

    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_LEFT -> controller.moveLeft();
            case KeyEvent.VK_RIGHT -> controller.moveRight();
            case KeyEvent.VK_SPACE -> controller.moveDown();
            /*
            case KeyEvent.VK_UP -> controller.rotate(); //TODO: rotate()
            case KeyEvent.VK_DOWN -> controller.rotate(); //TODO: rotate()
             */
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
    /*
    public Color tetrominoColor(Tetromino t) {
        t.getColor();

    }

     */
}


/*
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        // test pr voir si ca marche
        // haut = 38, bas = 40, gauche = 37, droite = 39, espace = 32
        char letter = e.getKeyChar();
        int value = e.getKeyCode();
        if (value == KeyEvent.VK_UP)
            labelUp.setBackground(Color.red);
        else if (value == KeyEvent.VK_DOWN)
            labelDown.setBackground(Color.red);
        else if (value == KeyEvent.VK_LEFT)
            labelLeft.setBackground(Color.red);
        else if (value == KeyEvent.VK_RIGHT)
            labelRight.setBackground(Color.red);
        else if (value == KeyEvent.VK_A) {

        else if (value == KeyEvent.VK_SPACE) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int value = e.getKeyCode();
        if (value == 38)
            labelUp.setBackground(Color.gray);
        else if (value == 40)
            labelDown.setBackground(Color.gray);
        else if (value == 37)
            labelLeft.setBackground(Color.gray);
        else if (value == 39)
            labelRight.setBackground(Color.gray);
        else if (value == 32)
            labelSpace.setBackground(Color.gray);
    }
}

 */
