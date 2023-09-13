package com.solifsd08.fibonacci;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Fibonacci {
    
    // CONSTRUCTORS:
    
    // no-arg
    Fibonacci() { // cache defaults to ON
        this(true);
    }    
    
    // 1-arg: bool
    Fibonacci(boolean cacheOn) {
        isCacheOn = cacheOn;
        
        if (isCacheOn){
            fibsCached.put(0,0L); // #0
            fibsCached.put(1,1L); // #1
        }

        //TESTING:
        System.out.println("isCacheOn = " + isCacheOn + "\n");
    }    

    // INITIALIZATION:
    
    private boolean isCacheOn;
    private HashMap<Integer, Long> fibsCached = new HashMap<>();
    
    // count of fibs that *should* be in HashMap, i.e. = fibsCached.size()
    private int fibsCompCount = 3; // TESTING
    
    // count of fibs taken from HashMap, i.e. a saved computation
    private int fibsNotCompCount = 0; // TESTING
    
    // GETTERS: 
    
    // get fibsCompCount
    public int getCountFibsComputed() {
        return fibsCompCount;
    }
    
    // get fibsNotCompCount
    public int getCountFibsNotComputed() {
        return fibsNotCompCount;
    }
    
    // get fibsCached.size
    public int getFibsCachedSize() {
        return fibsCached.size();
    }
    
    // RESET COUNTS: 
    
    // reset fibsCompCount
    public void resetCounts() {
        fibsCompCount = 0;
        fibsNotCompCount = 0;
    }
    
    // INCREMENTORS:
    
    // increment fibsCompCount
    public void incCountFibsComputed() {
        fibsCompCount++;
    }
    
    // increment fibsNotCompCount
    public void incCountFibsNotComputed() {
        fibsNotCompCount++;
    }
    
//////////////////////////////////// MAIN METHODS /////////////////////////////
    // show nth fib
    public long getNthFib(int n) {
        
        // initialize:
        long nthFib;
        
        // initial cases: 0, 1
        if (n <= 1) {
            
            // fib @ positions 0 or 1:
            nthFib = n;
                        
            // increment Saved Computation
            incCountFibsNotComputed();
                        
            // TESTING:
            System.out.print("INITIAL CASE: ");
            
        } else if(isCacheOn && fibsCached.containsKey(n)) { // check hashmap for nth fib
            
            // if found, return nth fib
            nthFib = fibsCached.get(n);
                        
            // increment notCompCount
            incCountFibsNotComputed();
                        
            // TESTING:
            System.out.print("FROM CACHE: ");
            
        } else { // not yet in HashMap
            
            // run computeNthFib: compute 
            nthFib = computeNthFib(n);
            
            // set the fib in the HashMap            
            fibsCached.put(n, nthFib);
            
            // increment compCount
            incCountFibsComputed();
                        
            // TESTING:
            System.out.print("COMPUTED: ");

        } // END: main if-else

        /*
        // print num COMPUTED fib vals
        System.out.println("TEST: The following 2 values MUST be identical:");
        System.out.println("Computed Fibs, Count: " + getCountFibsComputed());
        System.out.println("Computed Fibs, HashMap Size: " + getFibsCachedSize());
        */
        
        // print and return the fib
        System.out.println("get fib # at position " +n +" = " +nthFib +".");
        return nthFib;
        
    }
    
    // COMPUTE nth fib if not in hashmap
    public long computeNthFib(int n) {
        
        // PLAN:
        // calculate the fib
        // return the fib
        
        // EXECUTION:
        
        // initialize
        long computedFib;
        
        // calculate computedFib
        computedFib = getNthFib((n-1)) + getNthFib((n-2));
        
        // return the fib
        return computedFib;
    }
    
    // returns all chached Fib values, comma-space-separated on a single line
    @Override
    public String toString() {
        
        // PLAN: 
        
        // initialize
        // iterate over whole set
            //build returnString
        // return returnString

        // EXECUTION:
        
        // METHOD 1: using iterator()
        
        // initialize
        String returnString = "All Cached Fibs: ";
        
        // iterate over set, building returnString
        Iterator<HashMap.Entry<Integer, Long>> fibCacheIterator = fibsCached.entrySet().iterator();
        
        // until we run out of cached fibs
        while (fibCacheIterator.hasNext()) {
            
            // get the cached fib
            Map.Entry<Integer, Long> fib = fibCacheIterator.next(); 
            
            // add the fib's value to the returnString
            returnString += fib.getValue();
            
            // add punctuation
            if (fibCacheIterator.hasNext()) { 
                
                // there's another fib, use comma
                returnString += ", ";
                
            } else {
                
                //last fib, use period
                returnString += ".";
                
            }
        }

        // METHOD 2: using foreach loop
        // ...TBD...
        
        // add more info:
        returnString += "\n";
        returnString += "Fib Cache Size: " +getFibsCachedSize() +"\n";
        returnString += "Computations: " +getCountFibsComputed() +"\n";
        returnString += "Saved Computations: " +getCountFibsNotComputed() +"\n";

        // return the string
        return returnString;
    }
//////////////////////////////////// BigInteger METHODS ///////////////////////
    // LATER TODO: replace long with BigInteger

////////////////////////////////// TESTING METHODS ////////////////////////////
    public static void singleObjOutSetup() {
        
        String setupString = "";
        
        setupString += "\n**********************************************";
        setupString += "\n**************** SINGLE OBJECT ***************";
        setupString += "\n**********************************************";
        setupString += "\n";
        
        System.out.println(setupString);
    }
    
    public static void singleObjTestOutput(int n, Fibonacci obj) {
        
        //reset calculations
        obj.resetCounts();
        
        String testString = "";
        
        testString += "******************************** NEW TEST ******************************************";
        testString += "\n***** COMPUTATIONS *****";
        testString += "\n" + "Fib #" +n +": " + obj.getNthFib(n);
        testString += "\n***** EXTRA INFO *****";
        
        System.out.println(testString);
        System.out.println(obj.toString());
    }
    
///////////////////////////////////////////// MAIN ////////////////////////////
    public static void main(String[] args) {
        System.out.println("********************* START ******************");
        
        // start with long
        System.out.println("----- Version: Long -----\n");
        
        /////////////////////////////////// TESTING: single object ////////////
        
        // INTRO output:
        singleObjOutSetup();
        
        // Create sole object:
        Fibonacci universalFibObj = new Fibonacci();
        
        // get nth Fib, n = 0,1,2,3,22,4;
        singleObjTestOutput(0, universalFibObj);
        singleObjTestOutput(1, universalFibObj);
        singleObjTestOutput(2, universalFibObj);
        singleObjTestOutput(3, universalFibObj);
        singleObjTestOutput(22, universalFibObj);
        singleObjTestOutput(4, universalFibObj);
        
        /////////////////////////////////// TESTING: multi objects ////////////
        /*        
        System.out.println("**********************************************");
        System.out.println("***************** MULTI OBJECT ***************");
        System.out.println("**********************************************");
        
        // get nth Fib0
        Fibonacci nthFib0 = new Fibonacci(); 
        System.out.println("\n" + "nthFib0: " + nthFib0.getNthFib(0));
        System.out.println("All Fibs: " + nthFib0.toString());
        
        // get nth Fib1
        Fibonacci nthFib1 = new Fibonacci(); 
        System.out.println("\n" + "nthFib1: " + nthFib1.getNthFib(1));
        System.out.println("All Fibs: " + nthFib1.toString());
        
        // get nth Fib2
        Fibonacci nthFib2 = new Fibonacci(); 
        System.out.println("\n" + "nthFib2: " + nthFib2.getNthFib(2));
        System.out.println("All Fibs: " + nthFib2.toString());
        
        // get nth Fib3
        Fibonacci nthFib3 = new Fibonacci(); 
        System.out.println("\n" + "nthFib3: " + nthFib3.getNthFib(3));
        System.out.println("All Fibs: " + nthFib3.toString());
        
        // get nth Fib22
        Fibonacci nthFib22 = new Fibonacci(); 
        System.out.println("\n" + "nthFib22: " + nthFib22.getNthFib(22));
        System.out.println("All Fibs: " + nthFib22.toString());
        
        // get nth Fib4
        Fibonacci nthFib4 = new Fibonacci(); 
        System.out.println("\n" + "nthFib4: " + nthFib4.getNthFib(4));
        System.out.println("All Fibs: " + nthFib4.toString());
        */
        
        ///////////////////////////////////////////////////////////////////////
        
        // LATER TODO
        System.out.println("\n----- Version: BigInteger -----\n");
        System.out.println("\n********************** END *******************");
    }

}
