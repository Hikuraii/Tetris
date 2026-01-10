package com.projects;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.Random;

public class GameController {
    private Board board;
    private Tetromino currentTetromino;
    private Timer timer, timer2;
    private boolean gameOver = false;
    public int score = 0;
    private final Runnable repaintCallback;


    // gérer le mouvement les pieces avec une vitesse
    // faire apparaitre une nouvelle piece quand elles sont placé


    public GameController(Board board, Runnable repaintCallback) {
        this.board = board;
        this.repaintCallback = repaintCallback;

        spawnTetromino();

        timer = new Timer(500, e -> update());
        // timer2 = new Timer(1000, e -> timer.setDelay(timer.getDelay()-200));
        timer.start();


    }

    public void update() {
        if (gameOver) {
            return ;
        }

        if (board.canPlace(currentTetromino, currentTetromino.getX() , currentTetromino.getY() + 1)) {
            currentTetromino.move(0, 1);
        } else {
            board.placeTetromino(currentTetromino);
            score += board.clearFullLines();
            spawnTetromino();
            if (!board.canPlace(currentTetromino, currentTetromino.getX(), currentTetromino.getY())) {
                gameOver = true;
                timer.stop();
            }

        }
        repaintCallback.run();

    }
    public void spawnTetromino() {
        Shape[] shapes = Shape.values();
        currentTetromino = new Tetromino(shapes[new Random().nextInt(shapes.length)]);
    }



    public void moveLeft(){
        if (board.canPlace(currentTetromino, currentTetromino.getX() - 1, currentTetromino.getY())) {
            currentTetromino.move(-1, 0);
            repaintCallback.run();
        }
    }
    public void moveRight(){
        if (board.canPlace(currentTetromino, currentTetromino.getX() + 1, currentTetromino.getY())) {
            currentTetromino.move(1, 0);
            repaintCallback.run();
        }
    }
    public void moveDown(){
        if (board.canPlace(currentTetromino, currentTetromino.getX() , currentTetromino.getY() + 1)) {
            currentTetromino.move(0, 1);
            repaintCallback.run();
        }
    }

    public Tetromino getCurrentTetromino() { return currentTetromino; }
}
