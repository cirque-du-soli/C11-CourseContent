package com.soli.finalexamsolitask1;

// IMPORTS
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Random;
import javax.swing.JFrame;

public class FinalExamSoliTask1 extends JFrame {

    public static void main(String[] args) {
        
        System.out.println("Hi!");
        
        // start
        FinalExamSoliTask1 fractalWindow = new FinalExamSoliTask1();
        
    }
    
    // FIELDS:
    // colors to choose from (stays consistent after window is resized)
    HashMap<Integer, Color> colorsByLevel = new HashMap<Integer, Color>();

    // CONSTRUCTOR
    public FinalExamSoliTask1() {
        
        setLayout(new BorderLayout());
        
        setSize(600, 600); 
        
        setTitle("What a nice looking window to draw in!!");
        DrawingArea drawingArea = new DrawingArea();
        add("Center", drawingArea);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }
    
    // Inner Class: the canvas to stick in the window
    private class DrawingArea extends Canvas {        
        
        @Override
        public void paint(Graphics g) { 
            
            // window dimensions
            int wWidth = getWidth();
            int wHeight = getHeight();            
            
            // DRAW: Test
            //drawTestLine(g, wWidth, wHeight);

            // DRAW: Fractal
            drawSquareFractal(g, wWidth, wHeight);

        } // END: override paint(g)
    } //END: DrawingArea      

    ////////// AUX METHODS
    
    // get random color
    private Color randomColor() {
        Random random = new Random();
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }
    
    // get seeded random color
    private Color randomColor(long seed) {
        Random random = new Random(seed);
        int red = random.nextInt(256);
        int green = random.nextInt(256);
        int blue = random.nextInt(256);
        return new Color(red, green, blue);
    }
    
    ////////// DRAWING METHODS
    /*
    // 1. Diagonal Line as Test
    private void drawTestLine(Graphics g, int wWidth, int wHeight) {
        
        // start coords (top left of canvas)
        int fromX = 0;
        int fromY = 0;
        
        // end coords (top right of canvas
        int toX = wWidth;
        int toY = wHeight;
        
        // draw diagonal line; top-left to bottom-right
        g.drawLine(fromX, fromY, toX, toY);
        
    }
    
    */

    // 2.a. Draw Squares Fractal
    private void drawSquareFractal(Graphics g, int wWidth, int wHeight) {
        // Note: every polygon is drawn clockwise from top left
        
        // get min dimension
        int minDim = wHeight;
        if (wWidth < wHeight) {
            minDim = wWidth;
        }
        
        // keep track of depth
        int level = 0;
        
        // setup arrays
        int[] xPoints = new int[4];
        int[] yPoints = new int[4];

        // arrays of points for initial square
        xPoints = new int[]{minDim/3, (2*minDim)/3, (2*minDim)/3, minDim/3};
        yPoints = new int[]{minDim/3, minDim/3, (2*minDim)/3  ,(2*minDim)/3};

        // call recursive method with inner triangle dimensions
        drawSquareComponent(g, xPoints, yPoints, level, colorsByLevel);
        
    }
    
    // 2.b. Recursive method
    private void drawSquareComponent(Graphics g, int[] xPoints, int[] yPoints, int level, HashMap<Integer, Color> colorsByLevel) {
        
        int currDim = yPoints[2]-yPoints[0];
        int nextLevel = level + 1;
        
        // minimum size        
        if ( currDim < 4) {
            return; // jump out of this would-be level!!!
        }
        
        // if color hasn't been decided yet, choose it:
        if (!colorsByLevel.containsKey(level)) {
            colorsByLevel.put(level, randomColor(System.nanoTime()));
        }
        
        // set color to correct one
        g.setColor(colorsByLevel.get(level));
        
        // draw component (points are passed by parent)
        g.drawPolygon(xPoints, yPoints, 4);

        
        ////////// RECURSION SETUP

        //determine next components' points (left, right, and upward corners)
        int[] leftXPoints = new int[]{xPoints[0]-(currDim/3), xPoints[0], xPoints[0], xPoints[0]-(currDim/3)};
        int[] leftYPoints = new int[]{yPoints[0]+(currDim/3), yPoints[0]+(currDim/3), yPoints[0]+(2*currDim/3), yPoints[0]+(2*currDim/3)};
        
        int[] rightXPoints = new int[]{xPoints[1], xPoints[1]+(currDim/3), xPoints[1]+(currDim/3), xPoints[1]};
        int[] rightYPoints = leftYPoints;
        
        int[] upXPoints = new int[]{xPoints[0]+(currDim/3), xPoints[1]-(currDim/3), xPoints[1]-(currDim/3),xPoints[0]+(currDim/3)};
        int[] upYPoints = new int[]{yPoints[0]-(currDim/3), yPoints[0]-(currDim/3), yPoints[0], yPoints[0]}; 

        int[] downXPoints = upXPoints;
        int[] downYPoints = new int[]{yPoints[2], yPoints[2], yPoints[2]+(currDim/3), yPoints[2]+(currDim/3)};
        
        // call self to draw next level's components
        
        // left sub-component
        drawSquareComponent(g, leftXPoints, leftYPoints, nextLevel, colorsByLevel);
        
        // right sub-component
        drawSquareComponent(g, rightXPoints, rightYPoints, nextLevel, colorsByLevel);
        
        // up sub-component
        drawSquareComponent(g, upXPoints, upYPoints, nextLevel, colorsByLevel);
        
        // down sub-component
        drawSquareComponent(g, downXPoints, downYPoints, nextLevel, colorsByLevel);
    
    }    
}

    
    
    
    
    
    
    
    

