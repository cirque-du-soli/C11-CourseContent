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
        
        setSize(1040, 551); 
        //^^ by making each dimension a power of 2 plus 16 (x) or 39 (y), we can avoid ugly initial rounding errors!
        
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
        public void paint(Graphics g) { //////////////// PUT CUSTOM CODE HERE!!!
            
            // parameters to pass to the fractal generators
            // e.g.
            int stepY = 25;
            
            // window dimensions
            int wWidth = getWidth();
            int wHeight = getHeight();            
            
            // DONE
            // draw testLine
            //masterpiece1(g, wWidth, wHeight);
            
            // DONE
            // draw basic line fractal
            //masterpiece2(g, wWidth, wHeight);
            
            // NOT DONE
            // draw easy triangle fractal
            //masterpiece3(g, wWidth, wHeight);
            
            // DONE
            // draw hard triangle fractal
            masterpiece4(g, wWidth, wHeight);
            
            // DONE
            // draw hard triangle fractal WITH DOUBLE casting!
            //masterpiece5(g, wWidth, wHeight);
            // this only marginally helps :(((
            
            // DONE
            // draw hard triangle fractal WITH DOUBLE casting && fillPolygon
            //masterpiece6(g, (double) wWidth, (double) wHeight);
            
            // NOT DONE
            // draw square plus fractal
            //masterpiece7(g, wWidth, wHeight);
            
            // NOT DONE
            // draw new tricky fractal
            //masterpiece8(g, wWidth, wHeight);
            
            //////////////////////////////////////////////// DIY: timer / eraser
            /* doesn't work becuase paintComponent is painted twice
            try {           
                // draw diagonally acrros the canvas, respecting window buffer
                g.drawLine(fromX, fromY, wWidth, wHeight);

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
    
    //////////////////////////////////////////////// masterpiece1: diagonal test
    // DIAGONAL LINE AS TEST
    private void masterpiece1(Graphics g, int wWidth, int wHeight) {
        
        // start coords (top left of canvas)
        int fromX = 0;
        int fromY = 0;
        
        // end coords (top right of canvas
        int toX = wWidth;
        int toY = wHeight;
        
        // draw diagonal line; top-left to bottom-right
        g.drawLine(fromX, fromY, toX, toY);
        
    }
    
    //////////////////////////////////////////////// masterpiece2: first fractal
    // FIRST FRACTAL (easy, lines)
    private void masterpiece2(Graphics g, int wWidth, int wHeight) {
        
        // start coords (top left of canvas)
        int fromX = 0;
        int fromY = 0;
        
        // end coords (top right of canvas
        int toX = wWidth;
        int toY = 0;
        
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

    //////////////////////////////////////////////// masterpiece3: easy triangle
    /*
// FIRST FRACTAL (easy, lines)
    private void masterpiece2(Graphics g, int wWidth, int wHeight) {
        
        // start coords (top left of canvas)
        int fromX = 0;
        int fromY = 0;
        
        // end coords (top right of canvas
        int toX = wWidth;
        int toY = 0;
        
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
        if ( currHeight < 3 ||  currWidth < 2) {
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
    
    */
    //////////////////////////////////////////////// masterpiece4: hard triangle
    
    
    // HARD TRIANGLE
    private void masterpiece4(Graphics g, int wWidth, int wHeight) {
        
        ////////////////////// consistent initial setup ///////////////////////
        
        // NOTE on polygons:
        // every polygon is drawn clockwise
        // starting at leftmost (min X) point
        // if there are equally leftward point, use top point of those (min Y)
        
        // start coords (top left of canvas)
        int fromX = 0;
        int fromY = 0;
        
        // end coords (top right of canvas
        int toX = wWidth;
        int toY = 0;
        
        // keep track of depth
        int level = 0;
        
        // setup arrays (FIXME??)
        int[] xPoints = new int[3];
        int[] yPoints = new int[3];
        
        // arrays of points for initial outer triangle
        xPoints = new int[]{0,(wWidth)/2, wWidth};
        yPoints = new int[]{wHeight,0, wHeight};
        
        // build initial outer triangle (unique first case)
        g.drawPolygon(xPoints, yPoints, 3);

        // arrays of points for initial inner triangle
        xPoints = new int[]{(xPoints[0]+xPoints[1])/2, (xPoints[1]+xPoints[2])/2, (xPoints[0]+xPoints[2])/2};
        yPoints = new int[]{(yPoints[0]+yPoints[1])/2, (yPoints[1]+yPoints[2])/2, (yPoints[0]+yPoints[2])/2};
        
        // call recursive method with inner triangle dimensions
        drawM4Component(g, xPoints, yPoints, level+1, colorsByLevel);
        
        //g.fillPolygon(outerTriangle);
        // build inner triangle, fill, and recursion x3 sub triangles.
        //g.fillPolygon(innerTriangle);
        
    }
    
    // recursion for M4 ^
    private void drawM4Component(Graphics g, int[] xPoints, int[] yPoints, int level, HashMap<Integer, Color> colorsByLevel) {
        
        int currHeight = yPoints[2]-yPoints[0];
        int currWidth = xPoints[1]-xPoints[0];
        int nextLevel = level+1;
        
        // minimum size        
        if ( currHeight < 4 ||  currWidth < 6) {
            return; // jump out of this would-be level!!!
        }
        
        // if color hasn't been decided yet, choose it:
        if (!colorsByLevel.containsKey(level)) {
            colorsByLevel.put(level, randomColor(System.nanoTime()));
        }
        
        // set color to correct one
        g.setColor(colorsByLevel.get(level));
        
        // draw component (points are passed by parent)
        g.drawPolygon(xPoints, yPoints, 3);

        ////// RECURSION SETUP

        //determine next components' points (left, right, and upward corners)
        int[] leftXPoints = new int[]{
            xPoints[0]-currWidth/4,
            xPoints[0]+currWidth/4, 
            xPoints[0]};
        int[] leftYPoints = new int[]{
            (yPoints[2]+yPoints[0])/2, //avg of curr 1st and 3rd y
            (yPoints[2]+yPoints[0])/2, //avg of curr 1st and 3rd y
            yPoints[2]}; // same as curr 3rd y
        
        int[] rightXPoints = new int[]{
            xPoints[1]-currWidth/4, 
            xPoints[1]+currWidth/4, 
            xPoints[1]};
        int[] rightYPoints = leftYPoints; // symmetrical horizontally
        
        int[] upXPoints = new int[]{
            xPoints[2]-currWidth/4, 
            xPoints[2]+currWidth/4, 
            xPoints[2]};
        int[] upYPoints = new int[]{
            yPoints[0]-currHeight/2, 
            yPoints[0]-currHeight/2, 
            yPoints[0]}; // same as curr top line
        
        // call self to draw next level's components
        
        // left sub-component
        drawM4Component(g, leftXPoints, leftYPoints, nextLevel, colorsByLevel);
        
        // right sub-component
        drawM4Component(g, rightXPoints, rightYPoints, nextLevel, colorsByLevel);
        
        // up sub-component
        drawM4Component(g, upXPoints, upYPoints, nextLevel, colorsByLevel);
    
    }    
    
    
    /////////////////////////////////////////////// masterpiece5: hard triangle2
    
    // HARD TRIANGLE (WITH CORRECTION OF floating point STRAY)
    private void masterpiece5(Graphics g, int wWidth, int wHeight) {
        
        ////////////////////// consistent initial setup ///////////////////////
        
        // NOTE on polygons:
        // every polygon is drawn clockwise
        // starting at leftmost (min X) point
        // if there are equally leftward point, use top point of those (min Y)
        
        // start coords (top left of canvas)
        int fromX = 0;
        int fromY = 0;
        
        // end coords (top right of canvas
        int toX = wWidth;
        int toY = 0;
        
        // keep track of depth
        int level = 0;
        
        // arrays of points for initial outer triangle
        int[] xPoints = new int[]{0,(wWidth)/2, wWidth};
        int[] yPoints = new int[]{wHeight,0, wHeight};
        
        // build initial outer triangle (unique first case)
        g.drawPolygon(xPoints, yPoints, 3);

        // arrays of points for initial inner triangle
        double[] xPointsDbl = new double[]{(xPoints[0]+xPoints[1])/2, (xPoints[1]+xPoints[2])/2, (xPoints[0]+xPoints[2])/2};
        double[] yPointsDbl = new double[]{(yPoints[0]+yPoints[1])/2, (yPoints[1]+yPoints[2])/2, (yPoints[0]+yPoints[2])/2};
        
        // call recursive method with inner triangle dimensions
        drawM5Component(g, xPointsDbl, yPointsDbl, level+1, colorsByLevel);
        
        //g.fillPolygon(outerTriangle);
        // build inner triangle, fill, and recursion x3 sub triangles.
        //g.fillPolygon(innerTriangle);
        
    }
    
    // recursion for M5 ^
    private void drawM5Component(Graphics g, double[] xPointsDbl, double[] yPointsDbl, int level, HashMap<Integer, Color> colorsByLevel) {
        
        double currHeight = yPointsDbl[2]-yPointsDbl[0];
        double currWidth = xPointsDbl[1]-xPointsDbl[0];
        int nextLevel = level+1;
        
        // minimum size        
        if ( currHeight < 4 ||  currWidth < 6) {
            return; // jump out of this would-be level!!!
        }
        
        // if color hasn't been decided yet, choose it:
        if (!colorsByLevel.containsKey(level)) {
            colorsByLevel.put(level, randomColor(System.nanoTime()));
        }
        
        // set color to correct one
        g.setColor(colorsByLevel.get(level));
        
        // cast double[] to int[] before drawing
        int[] xPointsInt = new int[xPointsDbl.length];
        for (int i=0; i<xPointsInt.length; ++i)
            xPointsInt[i] = (int) xPointsDbl[i];
        
        int[] yPointsInt = new int[yPointsDbl.length];
        for (int i=0; i<yPointsInt.length; ++i)
            yPointsInt[i] = (int) yPointsDbl[i];
        
        // draw component (points are passed by parent)
        g.drawPolygon(xPointsInt, yPointsInt, 3);

        ////// RECURSION SETUP

        //determine next components' points (left, right, and upward corners)
        double[] leftXPointsDbl = new double[]{
            xPointsDbl[0]-currWidth/4,
            xPointsDbl[0]+currWidth/4, 
            xPointsDbl[0]};
        double[] leftYPointsDbl = new double[]{
            (yPointsDbl[2]+yPointsDbl[0])/2, //avg of curr 1st and 3rd y
            (yPointsDbl[2]+yPointsDbl[0])/2, //avg of curr 1st and 3rd y
            yPointsDbl[2]}; // same as curr 3rd y
        
        double[] rightXPointsDbl = new double[]{
            xPointsDbl[1]-currWidth/4, 
            xPointsDbl[1]+currWidth/4, 
            xPointsDbl[1]};
        double[] rightYPointsDbl = leftYPointsDbl; // symmetrical horizontally
        
        double[] upXPointsDbl = new double[]{
            xPointsDbl[2]-currWidth/4, 
            xPointsDbl[2]+currWidth/4, 
            xPointsDbl[2]};
        double[] upYPointsDbl = new double[]{
            yPointsDbl[0]-currHeight/2, 
            yPointsDbl[0]-currHeight/2, 
            yPointsDbl[0]}; // same as curr top line
        
        // call self to draw next level's components
        // PASS THE double[] so that accurracy is preserved!
        
        // left sub-component
        drawM5Component(g, leftXPointsDbl, leftYPointsDbl, nextLevel, colorsByLevel);
        
        // right sub-component
        drawM5Component(g, rightXPointsDbl, rightYPointsDbl, nextLevel, colorsByLevel);
        
        // up sub-component
        drawM5Component(g, upXPointsDbl, upYPointsDbl, nextLevel, colorsByLevel);
    
    }    
    
    
    /////////////////////////////////////////////// masterpiece6: hard triangle3
    
    // HARD TRIANGLE (WITH CORRECTION OF floating point STRAY)
    private void masterpiece6(Graphics g, double wWidth, double wHeight) {
        
        ////////////////////// consistent initial setup ///////////////////////
        
        // NOTE on polygons:
        // every polygon is drawn clockwise
        // starting at leftmost (min X) point
        // if there are equally leftward point, use top point of those (min Y)
        
        // keep track of depth
        int level = 0;
        
        // arrays of points for initial outer triangle
        double[] xPointsDblInit = new double[]{0,(wWidth)/2, wWidth};
        double[] yPointsDblInit = new double[]{wHeight,0, wHeight};
        
        // cast double[] to int[] before drawing
        int[] xPointsInt = new int[xPointsDblInit.length];
        for (int i=0; i<xPointsInt.length; ++i)
            xPointsInt[i] = (int) xPointsDblInit[i];
        int[] yPointsInt = new int[yPointsDblInit.length];
        for (int i=0; i<yPointsInt.length; ++i)
            yPointsInt[i] = (int) yPointsDblInit[i];
        
        //TROUBLESHOOTING FIXME
        System.out.println("Level: " + level);
        for (int i = 0; i < xPointsDblInit.length; i++) {
            System.out.println("xPoint " + i + ": " + xPointsDblInit[i]); 
        }
        for (int i = 0; i < yPointsDblInit.length; i++) {
            System.out.println("yPoint " + i + ": " + yPointsDblInit[i]); 
        }
        
        // build initial outer triangle (unique first case)
        g.fillPolygon(xPointsInt, yPointsInt, 3);

        // arrays of points for initial inner triangle
        double[] xPointsDbl = new double[]{(xPointsDblInit[0]+xPointsDblInit[1])/2, (xPointsDblInit[1]+xPointsDblInit[2])/2, (xPointsDblInit[0]+xPointsDblInit[2])/2};
        double[] yPointsDbl = new double[]{(yPointsDblInit[0]+yPointsDblInit[1])/2, (yPointsDblInit[1]+yPointsDblInit[2])/2, (yPointsDblInit[0]+yPointsDblInit[2])/2};
        
        // call recursive method with inner triangle dimensions
        drawM6Component(g, xPointsDbl, yPointsDbl, level+1, colorsByLevel);
        
        //g.fillPolygon(outerTriangle);
        // build inner triangle, fill, and recursion x3 sub triangles.
        //g.fillPolygon(innerTriangle);
        
    }
    
    // recursion for M6 ^
    private void drawM6Component(Graphics g, double[] xPointsDbl, double[] yPointsDbl, int level, HashMap<Integer, Color> colorsByLevel) {
        
        System.out.println("Level: " + level);
        for (int i = 0; i < xPointsDbl.length; i++) {
            System.out.println("xPoint " + i + ": " + xPointsDbl[i]); 
        }
        for (int i = 0; i < yPointsDbl.length; i++) {
            System.out.println("yPoint " + i + ": " + yPointsDbl[i]); 
        }
        
        double currHeight = yPointsDbl[2]-yPointsDbl[0];
        double currWidth = xPointsDbl[1]-xPointsDbl[0];
        int nextLevel = level+1;
        
        // minimum size        
        if ( currHeight < 4 ||  currWidth < 6) {
            return; // jump out of this would-be level!!!
        }
        
        // if color hasn't been decided yet, choose it:
        if (!colorsByLevel.containsKey(level)) {
            colorsByLevel.put(level, randomColor(System.nanoTime()));
        }
        
        // set color to correct one
        g.setColor(colorsByLevel.get(level));
        
        // cast double[] to int[] before drawing
        int[] xPointsInt = new int[xPointsDbl.length];
        for (int i=0; i<xPointsInt.length; ++i)
            xPointsInt[i] = (int) xPointsDbl[i];
        
        int[] yPointsInt = new int[yPointsDbl.length];
        for (int i=0; i<yPointsInt.length; ++i)
            yPointsInt[i] = (int) yPointsDbl[i];
        
        // draw component (points are passed by parent)
        g.fillPolygon(xPointsInt, yPointsInt, 3);

        ////// RECURSION SETUP

        //determine next components' points (left, right, and upward corners)
        double[] leftXPointsDbl = new double[]{
            xPointsDbl[0]-currWidth/4,
            xPointsDbl[0]+currWidth/4, 
            xPointsDbl[0]};
        double[] leftYPointsDbl = new double[]{
            (yPointsDbl[2]+yPointsDbl[0])/2, //avg of curr 1st and 3rd y
            (yPointsDbl[2]+yPointsDbl[0])/2, //avg of curr 1st and 3rd y
            yPointsDbl[2]}; // same as curr 3rd y
        
        double[] rightXPointsDbl = new double[]{
            xPointsDbl[1]-currWidth/4, 
            xPointsDbl[1]+currWidth/4, 
            xPointsDbl[1]};
        double[] rightYPointsDbl = leftYPointsDbl; // symmetrical horizontally
        
        double[] upXPointsDbl = new double[]{
            xPointsDbl[2]-currWidth/4, 
            xPointsDbl[2]+currWidth/4, 
            xPointsDbl[2]};
        double[] upYPointsDbl = new double[]{
            yPointsDbl[0]-currHeight/2, 
            yPointsDbl[0]-currHeight/2, 
            yPointsDbl[0]}; // same as curr top line
        
        // call self to draw next level's components
        // PASS THE double[] so that accurracy is preserved!
        
        // left sub-component
        drawM6Component(g, leftXPointsDbl, leftYPointsDbl, nextLevel, colorsByLevel);
        
        // right sub-component
        drawM6Component(g, rightXPointsDbl, rightYPointsDbl, nextLevel, colorsByLevel);
        
        // up sub-component
        drawM6Component(g, upXPointsDbl, upYPointsDbl, nextLevel, colorsByLevel);
    
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
