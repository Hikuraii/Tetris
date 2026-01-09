package com.projects;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Arrays;

public class GUI implements KeyListener {
    JFrame frame;
    JPanel txtUi;
    JLabel labelTest, labelUp, labelDown, labelRight, labelLeft, labelSpace, labelSquare;
    JLabel[][] grid;
    JButton button;
    Board gameUi;

    public GUI() {
        frame = new JFrame();
        // les objets qu'on aura dans le panel
        labelUp = new JLabel("up", SwingConstants.CENTER);
        labelUp.setBackground(Color.gray);
        labelUp.setOpaque(true);
        labelUp.setPreferredSize(new Dimension (100, 100));

        labelDown = new JLabel("down", SwingConstants.CENTER);
        labelDown.setBackground(Color.gray);
        labelDown.setOpaque(true);
        labelDown.setPreferredSize(new Dimension (100, 100));

        labelLeft = new JLabel("left", SwingConstants.CENTER);
        labelLeft.setBackground(Color.gray);
        labelLeft.setOpaque(true);
        labelLeft.setPreferredSize(new Dimension (100, 100));

        labelRight = new JLabel("right", SwingConstants.CENTER);
        labelRight.setBackground(Color.gray);
        labelRight.setOpaque(true);
        labelRight.setPreferredSize(new Dimension (100, 100));

        labelSpace = new JLabel("space", SwingConstants.CENTER);
        labelSpace.setBackground(Color.gray);
        labelSpace.setOpaque(true);
        labelSpace.setPreferredSize(new Dimension (200, 100));

        // faire des pixel différent et au lieu de juste changer la couleur, remplacer le pixel par celui qu'on veut
        /*
        labelTest = new JLabel("test",SwingConstants.CENTER);
        labelTest.setBackground(Color.black);
        labelTest.setOpaque(true)  ;
         */
        gameUi = new Board(20,10);

        txtUi = new JPanel();
        txtUi.setBounds(341,10,311,680);//taille pour 18 pixel de length et 20 pixel de width
        txtUi.setBackground(Color.yellow);



        frame.addKeyListener(this);
        //paramètre de frenetre + tout appelé
        txtUi.add(labelUp);
        txtUi.add(labelDown);
        txtUi.add(labelLeft);
        txtUi.add(labelRight);
        txtUi.add(labelSpace);
        frame.add(txtUi);
        frame.add(gameUi);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Tetris");
        Container c = frame.getContentPane();
        c.setBackground(Color.gray);
        frame.setSize(1300, 1000);
        frame.setLayout(null);

        // frame.pack();
        frame.setVisible(true);
    }
    //static void main(String[] args) {
    //    new GUI();
    //}

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
            System.out.println(letter);
            // grid[coords[0]][coords[1]].setBackground(Color.red);

        }

        else if (value == KeyEvent.VK_SPACE) {
            labelSpace.setBackground(Color.red);
            System.out.println(Arrays.deepToString(gameUi.getGrid()));
            System.out.println(gameUi.getLabelSquare(0,0).getBackground());
            gameUi.getLabelSquare(0,0).setBackground(Color.black);



            //grid[coords[0]][coords[1]].setBackground(Color.black);
           // grid[coords[0] + 1][coords[1]].setBackground(Color.red);
           // System.out.println(Arrays.toString(coords));
           //  coords[0] += 1;
            //System.out.println(Arrays.toString(coords));
           //   if (coords[0] >= 16) {
            //      coords[0]= 0;


            }

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
