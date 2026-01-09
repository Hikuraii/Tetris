package com.projects;

import java.awt.*;

// Contient les différentes formes de pièces
public enum Shape {

    iPiece(new int[][] {
            {1, 1, 1, 1}
    }, new Color(255, 0, 0)),

    jPiece(new int[][] {
            {1, 0, 0},
            {1, 1, 1}
    }, new Color(0, 255, 0)),

    lPiece(new int[][] {
            {0, 0, 1},
            {1, 1, 1}
    }, new Color(0, 0, 255)),

    oPiece(new int[][] {
            {1, 1},
            {1, 1}
    }, new Color(255, 255, 0)),

    sPiece(new int[][] {
            {0, 1, 1},
            {1, 1, 0}
    }, new Color(255, 0, 255)),

    zPiece(new int[][] {
            {1, 1, 0},
            {0, 1, 1}
    }, new Color(0, 255, 255)),

    tPiece(new int[][] {
            {1, 1, 1},
            {0, 1, 0}
    }, new Color(127, 127, 127));

    public final int[][] matrix;

    public final Color color;

    Shape(int[][] matrix, Color color) {
        this.matrix = matrix;
        this.color = color;
    }

}