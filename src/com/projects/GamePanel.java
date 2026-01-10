package com.projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel implements KeyListener {
    private static final int TILE = 30;
    private final Board board = new Board();
    private final GameController controller;
    public JLabel scoreLabel = new JLabel(), lineLabel = new JLabel();

    public GamePanel() {
        setPreferredSize(new Dimension(Board.COLS * TILE, Board.ROWS * TILE));
        setFocusable(true);
        setBackground(new Color(51, 1, 1, 190));
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
            case KeyEvent.VK_UP -> controller.rotateLeft();
            /*
            case KeyEvent.VK_DOWN -> controller.rotateRight();
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
