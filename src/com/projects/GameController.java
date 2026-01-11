package com.projects;

import javax.swing.*;
import java.util.Random;

public class GameController {
    private Board board;
    private Tetromino currentTetromino;
    public Timer timer, timer2;
    public boolean gameOver = false;
    public double  score, lineCleared, previousLineCleared;
    private final Runnable repaintCallback;



    public GameController(Board board, Runnable repaintCallback) {
        this.board = board;
        this.repaintCallback = repaintCallback;

        spawnTetromino();

        timer2 = new Timer(60000, e -> timer.setDelay(timer.getDelay()-50));
        timer = new Timer(500, e -> update());
        timer.start();
        timer2.start();


    }

    public void update() {
        if (gameOver) {
            return ;
        }

        if (timer.getDelay() <= 50)
            timer2.stop();
        if (board.canPlace(currentTetromino, currentTetromino.getX() , currentTetromino.getY() + 1)) {
            currentTetromino.move(0, 1);
        } else {
            board.placeTetromino(currentTetromino);
            lineCleared += board.clearFullLines();
            if (lineCleared != previousLineCleared)
                score += 100 * Math.pow(lineCleared - previousLineCleared, 2);
            previousLineCleared = lineCleared;
            spawnTetromino();
            if (!board.canPlace(currentTetromino, currentTetromino.getX(), currentTetromino.getY())) {
                gameOver = true;
                timer.stop();
                timer2.stop();
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

    public void rotateLeft(){
        if (board.canRotateLeft(currentTetromino)) {
            currentTetromino.setRotatedShape(currentTetromino.getRotatedShapeL());
            repaintCallback.run();


        }

    }

    public void rotateRight(){
        if (board.canRotateRight(currentTetromino)) {
            currentTetromino.setRotatedShape(currentTetromino.getRotatedShapeR());
            repaintCallback.run();
        }


    }


    public double getScore() { return score;}

    public double getLineCleared() { return lineCleared;}

    public Tetromino getCurrentTetromino() { return currentTetromino;}


}








