package com.projects;


import java.applet.Applet;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

// créer un tétris fonctionnel avec une nouvelle fonctionnalités
public class Main {

    static void main() {
        tetronimo test = new tetronimo();
        System.out.println(Arrays.deepToString(test.jPiece));
        GUI grid = new GUI();

    }
}

