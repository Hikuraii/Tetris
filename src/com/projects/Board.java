package com.projects;

import javax.swing.*;

import static java.awt.AWTEventMulticaster.add;

public class Board extends JPanel {
    public static final int ROWS = 20;
    public static final int COLS = 10;
    public int[][] grid = new int[ROWS][COLS];


    private void initGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                this.grid[i][j] = 0;
            }
        }
    }

    public void placeTetromino(Tetromino tetromino) {
        int[][] shape = tetromino.getShape();
        for (int y = 0; y < shape.length; y++) {
            for (int x = 0; x < shape[0].length; x++) {
                if (shape[y][x] == 1)
                    this.grid[tetromino.getY() + y][tetromino.getX() + x] = 1;

            }
        }
    }

    public void rotateTetromino(Tetromino tetromino) {
        int[][] shape = tetromino.getRotatedShape();
        for (int y = 0; y < shape.length; y++) {
            for (int x = 0; x < shape[0].length; x++) {
                if (shape[y][x] == 1)
                    this.grid[tetromino.getY() + y][tetromino.getX() + x] = 1;
            }
        }

    }

    public int[][] getGrid() {
        return grid;
    }

    public boolean canPlace(Tetromino tetromino, int newX, int newY) {
        int[][] shape = tetromino.getShape();
        for (int y = 0; y < shape.length; y++) {
            for (int x = 0; x < shape[0].length; x++) {
                if (shape[y][x] == 1) {
                    int boardX = newX + x;
                    int boardY = newY + y;

                    if (boardY >= ROWS || boardX >= COLS || boardX < 0) {
                        return false;
                    }
                    if (grid[boardY][boardX] == 1 && boardY >= 0) {
                        return false;
                    }

                }

            }
        }
        return true;
    }

    public boolean canRotate(Tetromino tetromino) {
        int[][] shape = tetromino.getRotatedShape();
        for (int y = 0; y < shape.length; y++) {
            for (int x = 0; x < shape[0].length; x++) {
                if (shape[y][x] == 1) {
                    int rotatedX = tetromino.getX() + x;
                    int rotatedY = tetromino.getY() + y;

                    if (rotatedY >= ROWS || rotatedX >= COLS || rotatedX < 0) {
                        return false;
                    }
                    if (grid[rotatedY][rotatedX] == 1 && rotatedY >= 0) {
                        return false;
                    }

                }

            }
        }
        return true;
    }

    public boolean isFullLine(int row) {
        for (int x = 0; x < COLS; x++) {
            if (grid[row][x] == 0) {
                return false;
            }
        }
        return true;
    }

    public void clearLine(int row) {
        for (int y = row; y > 0; y--) {
            grid[y] = grid[y - 1].clone();
        }
        grid[0] = new int[COLS];
    }


    public int clearFullLines() {
        int clearedLines = 0;
        for (int y = ROWS - 1; y >= 0; y--) {
            if (isFullLine(y)) {
                clearLine(y);
                clearedLines++;
                y++;
            }
        }
        return clearedLines;
    }
}