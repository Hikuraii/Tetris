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


    /**
     *
     * @param piece rotation a 90° => matrice de rotation
     *          ou on échange juste les axes x et y => pas besoin de faire des produits matriciel
     * @return
     */
    /* public int[][]  rotatePiece(int[][] piece) {

        int[][] R90 = {{0,1},{-1,0}};


        return RotatedPiece;
    }
    */

}


