/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.solifsd08.day01universalarrays;

/**
 *
 * @author solil
 */
public class Day01UniversalArrays {
    
    //////////////////////////////////////////////////// STATIC UTILITY METHODS
    
    ///////// Input Array //////////
    // Ask user for each row/column value.
    
    static void inputArray(int[] data) {
        // ...
        //"Enter value 1: "
    }
    
    static void inputArray(int[][] data2d) {
        // ...
        //"Enter value row 1 column 1: "
    }
    
    ///////// Print Array //////////
    // Print: Values comma-separated. Single line.
    
    static void printArray(int[] data) {
        // ...
    }
    
    // Print: Values comma-separated. Commas align. Values right-adjusted.
    static void printArray(int[][] data2d) {
        
    }
    
    // Print: Smart -- dynamically adjjust column sizes
    static void printArraySmart(int[][] data2d) {
        // 1. find the max row length
        int maxRowLength = 0;
        for (int row = 0; row < data2d.length; row++){
            // maxRowLength = Math.max(maxRowLength, data2d[row].length);
            maxRowLength = (maxRowLength > data2d[row].length) ? maxRowLength : data2d[row].length;
        }
        
        // 2. allocate colWidth array and fill it with column widths (max string size of each cell)
        int[] colsWidth = new int[maxRowLength];
        for (int row = 0; row < data2d.length; row++) {
            for (int col = 0; col < data2d[row].length; col++) {
                // String dataStr = data2d[row][col] + "";
                // int length = dataStr.length();
                int length = String.valueOf(data2d[row][col]).length();
                colsWidth[col] =  Math.max(colsWidth[col], length);
            }
        }
        
        // 3. print data with columns appropriately sized
        for (int row = 0; row < data2d.length; row++) {
            for (int col = 0; col < data2d[row].length; col++) {
                System.out.printf(" %" + colsWidth[col] + "d", data2d[row][col]);
            }
            System.out.println();
        }
        
    }
    
    ///////// Find Duplicates //////////
    // Returns array of values that appear in both a1 and a2.
    // The returned array contains no duplicates.
    
    static int[] findDuplicates(int[] a1, int[] a2) {
        
        int[] returnable = new int[1];
        // ...
        
        return returnable;
    }
    
    static int[] findDuplicates(int[][] a1, int[][] a2) {
        
        int[] returnable = new int[1];
        // ...
        
        return returnable;
    }
    
    ////////////////////////////////////////////////////////////////////// MAIN
    public static void main(String[] args) {
        
        // exercise each method at least once
        
        // no adv. data structures: ArrayList, HashMap, etc.
        // no Arrays classes, nor Collections classes
        // only regular arrays
        
        // must use pen and paper to draw the data structures (arrays)
        // and to figure out what algorithms you need
        
        // TEST DATA:
        int data2d [][] = {
            { -234234,     9,  4,22},
            {3, 128,-2},
            { 123, -7, 0, 1, 7 }
        };
        
        
        
        // OUTPUT:
        System.out.println("************************* START **********************");
        
        System.out.println("----- NORMAL PRINT: -----");
        printArray(data2d);
        
        System.out.println("----- SMART PRINT: -----");
        printArraySmart(data2d);
        
        System.out.println("************************** END ***********************");

    }
}
