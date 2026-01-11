package com.projects;

import java.awt.*;

public class Tetromino {

    private int[][] shape;
    private int x, y;
    private Color color;

    public Tetromino(Shape shape) {
        this.shape = shape.matrix;
        this.x =4;
        this.y =0;
        this.color = shape.color;
    }

    public int[][] getShape() {return shape;}

    public int getX() { return x; }

    public int getY() { return y; }


    public Color getColor() {return color;}



    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public void setPosition(int x, int y ){
        this.x = x;
        this.y = y;
    }

    public int[][] getRotatedShapeR(){
        int h = shape.length;
        int w = shape[0].length;

        int[][] rotatedShapeR = new int[w][h];


        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                rotatedShapeR[x][h - 1 - y] = shape[y][x];

            }

        }
        return rotatedShapeR;
    }

    public int[][] getRotatedShapeL(){
        int h = shape.length;
        int w = shape[0].length;

        int[][] rotatedShapeL = new int[w][h];

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                rotatedShapeL[w - 1 - x][y] = shape[y][x];
            }

        }
        return rotatedShapeL;
    }

    public void setRotatedShape(int[][] rotatedShape){
        this.shape = rotatedShape;
    }
}


