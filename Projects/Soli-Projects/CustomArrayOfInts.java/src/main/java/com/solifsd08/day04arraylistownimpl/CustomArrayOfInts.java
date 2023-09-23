package com.solifsd08.day04arraylistownimpl;

public class CustomArrayOfInts {

    private int [] data = new int[2]; // only grows by doubling size, never shrinks
    private int size = 0; // how many items do you really have

    public int size() { 
        
        return size; 

    }
    
    public void add(int value) {
        System.out.println("***** DEV: Beginning of add() method. *****");
        
        System.out.println("Data: " + data);
        
        
        
        
        System.out.println("***** DEV: End of add() method. *****");
    }
    
    
    
    public void deleteByIndex(int index) {
        
    }
    
    
    
    public boolean deleteByValue(int value) { // delete first value matching, true if value found, false otherwise
    
        
        return true; //FIXME
    }
    
    
    public void insertValueAtIndex(int value, int index) {
        
    }
    
    
    
    public void clear() { 
        size = 0; 
    }
    
    
    
    public int get(int index) { // may throw ArrayIndexOutOfBoundsException
        
        
        return 3; //FIXME
    } 
    
    
   /* 
    public int[] getSlice(int startIdx, int length) {// may throw ArrayIndexOutOfBoundsException
        
        return ; //FIXME
    } 
    
    
    
    public int[] toArray() { // ensure no reference leak

        
    } 

    */
    
    
    @Override
    public String toString() {// returns String similar to: [3, 5, 6, -23]
        
        return ""; //FIXME
    } 










    public static void main(String[] args) {
        System.out.println("Hello World!");
        
        
    } //END: main.
    
}

// You may add:
//// private helper methods 
//// a public constructor.

// Methods may throw ArrayIndexOutOfBoundsException if parameters (indexes) are invalid.

// ??? Create a Generic version of the class ???

// Add 10-20 junit tests

// To use random nums: pass initialization integer as parameter to Random() constructor... e.g. 
//// Random rand = new Random(984723);