package com.projects;

import javax.naming.Name;
import java.awt.*;

// Contient les différentes formes de pièces
public enum Shape {

    iPiece(new int[][]{
            {1, 1, 1, 1}
    }, new Color(255, 0, 0), "Ipiece"),

    jPiece(new int[][]{
            {1, 0, 0},
            {1, 1, 1}
    }, new Color(0, 255, 0), "JPiece"),

    lPiece(new int[][]{
            {0, 0, 1},
            {1, 1, 1}
    }, new Color(0, 0, 255), "LPiece"),

    oPiece(new int[][]{
            {1, 1},
            {1, 1}
    }, new Color(255, 255, 0), "OPiece"),

    sPiece(new int[][]{
            {0, 1, 1},
            {1, 1, 0}
    }, new Color(255, 0, 255), "SPiece"),

    zPiece(new int[][]{
            {1, 1, 0},
            {0, 1, 1}
    }, new Color(0, 255, 255), "ZPiece"),

    tPiece(new int[][]{
            {1, 1, 1},
            {0, 1, 0}
    }, new Color(127, 127, 127), "TPiece"),;

    public final int[][] matrix;

    public final Color color;

    public final String pieceName;

    Shape(int[][] matrix, Color color, String pieceName) {
        this.matrix = matrix;
        this.color = color;
        this.pieceName = pieceName;
    }
}