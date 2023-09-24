package com.solifsd08.slay.stencil;

// IMPORTS
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

public class FractalFun extends JFrame {
    
    // INITIAL SETUP
    public static void setupTheWindow() {
        FractalFun fractalWindow = new FractalFun();
    }
    
    // colors to choose from! (stays consistent after window is resized
    HashMap<Integer, Color> colorsByLevel = new HashMap<Integer, Color>();

    
    
    // CONSTRUCTOR
    public FractalFun() {
        setLayout(new BorderLayout());
        setSize(500, 375);
        setTitle("What a nice looking window to draw in!!");
        DrawingArea drawingArea = new DrawingArea();
        
        System.out.println("WOWOWOWOWOWO " + drawingArea.isDoubleBuffered());
        add("Center", drawingArea);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // center on screen
        setVisible(true);
    }
    
    // Inner Class: the canvas to stick in the window
    private class DrawingArea extends Canvas {
        
        
        @Override
        public void paint(Graphics g) { //////////////// PUT CUSTOM CODE HERE!!!
            
            // parameters to pass to the fractal generators
            // e.g.
            int stepY = 25;
            
            ///////////////////////////////////////////////// DIY: window border
            // window border
            int wB = 25;
            
            // window dimensions
            int wW = getWidth();
            int wH = getHeight();            
            
            // draw testLine
            //masterpiece1(g, wB, wW, wH);
            
            // draw basic line fractal
            masterpiece2(g, wB, wW, wH);
            
            //////////////////////////////////////////////// DIY: timer / eraser
            /* doesn't work becuase paintComponent is painted twice
            try {           
                // draw diagonally acrros the canvas, respecting window buffer
                g.drawLine(fromX, fromY, wW-wB, wH-wB);

                // wait and then clear window
                TimeUnit.MILLISECONDS.sleep(1500);
            } catch (InterruptedException ex) {
                System.out.println("whatevrrrrrrrr...");
            }
            */
            
        } // END: override paint(g)
    } //END: DrawingArea      
    
    //////////////////////////////////////////////////////////////// AUX METHODS
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
    
    //////////////////////////////////////////////////////////// DRAWING METHODS
    
    // DIAGONAL LINE AS TEST
    private void masterpiece1(Graphics g, int wB, int wW, int wH) {
        
        // start coords (top left of canvas)
        int fromX = wB;
        int fromY = wB;
        
        // end coords (top right of canvas
        int toX = wW-wB;
        int toY = wH-wB;
        
        // draw diagonal line; top-left to bottom-right
        g.drawLine(fromX, fromY, toX, toY);
        
    }
    
    // FIRST FRACTAL (easy, lines)
    private void masterpiece2(Graphics g, int wB, int wW, int wH) {
        
        // start coords (top left of canvas)
        int fromX = wB;
        int fromY = wB;
        
        // end coords (top right of canvas
        int toX = wW-wB;
        int toY = wB;
        
        // space between lines
        int step = 10;
        int level = 0;
        
        // call the fractal's recursive method
        drawM2Component(g, fromX, toX, fromY, toY, level, step, colorsByLevel);
        
    }
    // recursion for M2 ^
    private void drawM2Component(Graphics g, int fromX, int toX, int fromY, int toY, int level, int step, HashMap<Integer, Color> colorsByLevel) {
        
        //int currHeight = fromY - toY;
        int currWidth = toX-fromX;
        int nextLevel = level+1;
        
        // minimum size        
        if (/* currHeight < 3 || */ currWidth < 2) {
            return; // jump out of this would-be level!!!
        }
        
        // if color hasn't been decided yet, choose it:
        if (!colorsByLevel.containsKey(level)) {
            colorsByLevel.put(level, randomColor(System.nanoTime()));
        }
        
        // set color to correct one
        g.setColor(colorsByLevel.get(level));

        // draw component
        g.drawLine(fromX, fromY, toX, toY);
        
        // call self to draw next level's components
        
        // left sub-component
        drawM2Component(g, fromX, fromX+(currWidth/3), fromY+step, toY+step, nextLevel, step, colorsByLevel);
        
        // right sub-component
        drawM2Component(g, toX-(currWidth/3), toX, fromY+step, toY+step, nextLevel, step, colorsByLevel);
        
    
    }
    
/* OTHER DRAWING METHODS/CLASSES:

drawPolygon(int[], int[], int)

public abstract void fillPolygon(int[] xPoints, int[] yPoints, int nPoints)

public void fillPolygon(Polygon p)

public abstract void drawPolyline(int[] xPoints, int[] yPoints, int nPoints)

public abstract void fillPolygon(int[] xPoints, int[] yPoints, int nPoints)
Fills a closed polygon defined by arrays of x and y coordinates.
This method draws the polygon defined by nPoint line segments, where the first nPoint - 1 line segments are line segments from (xPoints[i - 1], yPoints[i - 1]) to (xPoints[i], yPoints[i]), for 1 ≤ i ≤ nPoints. The figure is automatically closed by drawing a line connecting the final point to the first point, if those points are different.
The area inside the polygon is defined using an even-odd fill rule, also known as the alternating rule.
Parameters:
xPoints - a an array of x coordinates.
yPoints - a an array of y coordinates.
nPoints - a the total number of points.

public void fillPolygon(Polygon p)
Fills the polygon defined by the specified Polygon object with the graphics context's current color.
The area inside the polygon is defined using an even-odd fill rule, also known as the alternating rule.

Parameters:
p - the polygon to fill.
*/
                
                
                
                ///////// Call to the fractal logic method!! ////////////

            
            
        
    
    
    /////////////////////////////////////////////////////// CUSTOM FRACTAL LOGIC
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
