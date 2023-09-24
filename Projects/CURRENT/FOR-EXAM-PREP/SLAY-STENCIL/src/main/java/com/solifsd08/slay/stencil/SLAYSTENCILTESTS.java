package com.solifsd08.slay.stencil;

/**
 *
 * @author SLAY
 */
public class SLAYSTENCILTESTS {
    
    public static void sstMethod1() {
        System.out.println("HELLO! From sstMethod1 <3");
    }
    
    /*
    STEPS:
    1. Generate tests automatically to make sure full coverage
    2. Elaborate tests, checking:
        a. many calls of same method
        b. calling different combinations of methods
    3. Check edge cases (off by one in either direction)
    */
    
    
///////////////////////////////////////////////////////////////////// FROM: Fibs
    /*
    // get one
    // get many
    // get count
    // get count of cache
    
    // TODO: test exception on getNthFib(-1)
    @Test
    public void testGetNthFib() {
        System.out.println("getNthFib");
        int n = 0;
        Fibonacci instance = new Fibonacci(false);
        long expResult = 55L;
        long result = instance.getNthFib(10);
        assertEquals(expResult, result);
    }

    @Test
    public void testGetNthFibMany() {
        long expRes [] = { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 };
        System.out.println("getNthFib");
        int n = 0;
        Fibonacci instance = new Fibonacci(false);
        for (int i = 0; i < expRes.length; i++) {
            long exp = expRes[i];
            long result = instance.getNthFib(i);
            assertEquals(exp, result);
        }
    }
    
    *
     * Test of getCountOfFibsComputed method, of class Fibonacci.
     
    @Test
    public void testGetCountOfFibsComputed() {
        System.out.println("getCountOfFibsComputed");
        Fibonacci instance = new Fibonacci(false);
        instance.getNthFib(10);
        int expResult = 90;
        int result = instance.getCountOfFibsComputed();
        assertEquals(expResult, result);
    }

    @Test
    public void testGetCountOfFibsComputedCache() {
        System.out.println("getCountOfFibsComputed");
        Fibonacci instance = new Fibonacci(true);
        instance.getNthFib(10);
        int expResult = 11;
        int result = instance.getCountOfFibsComputed();
        assertEquals(expResult, result);
    }
    */


}
