package day09firstfractal;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Graphics;
import javax.swing.JFrame;

public class MainWindow extends JFrame {

    public static void main(String[] args) {
        MainWindow mainWindowForDrawing = new MainWindow();
    }

    public MainWindow() {
        setLayout(new BorderLayout());
        setSize(500, 375);
        setTitle("First window to draw in");
        DrawingArea drawingArea = new DrawingArea();
        add("Center", drawingArea);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }

    private class DrawingArea extends Canvas {

        @Override
        public void paint(Graphics g) {
            // Tests:
//            g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
//            g.drawLine(10, 10, getWidth() - 10, 10);

            // declare window buffer size
            int windowBuff = 10;

            // THINGS TO DRAW
            drawFractalFIRST(g, windowBuff, 2);
            
        }
    }

    private void drawFractalFIRST(Graphics g, int windowBuff, int levelY) {

        // determine canvas dimensions
        int wW = getWidth();
        int wH = getHeight();
        int canvasW = wW - 2*windowBuff;
        int canvasH = wH - 2*windowBuff;
        
        // current position of paintbrush (start at top left) //TODO REMOVE IF UNNECESSARY
        int brushX = 10;
        int brushY = 10;
        int destX = 10;
        int destY = 10;

        // line buffer
        int levelBuff = 15;
            
        // divider
        int ratio = 3;

        // test line across drawing space
        g.drawLine(brushX, brushY, destX, destY);

        // for each level, draw a line
        for (int i = 0; i < levelY; i++) {

            // i indicates the level we're on (first is 0)
            // for line 0, we don't change the length
            
            // figure out destination x, y:
            destY = canvasW / (3 * i);
            
            g.drawLine(brushX, brushY, destX, destY);
          
            // start and end for 2nd part
            
            brushY = canvasW / (3 * i)
            
            
            // after drawing each level y, add a stepY at the bottom (move down a line)
            brushY += levelBuff;
            brushX = windowBuff;
        }

    }

}
