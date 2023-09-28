package com.soli.finalroundqueue;

import java.util.Iterator;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoundFIFOQueueStringTest {
    
    public RoundFIFOQueueStringTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        // create instance
        RoundFIFOQueueString instance = new RoundFIFOQueueString(5);
        
        // create iterator
        Iterator testIterator = instance.iterator();

    }
    
    @After
    public void tearDown() {
    }
/*

*prove* that your implementation works

TO TEST:
    two behaviours of enqueue, 
    exception throwing, 
    many cases where you enqueu/deque more items than max Queue 
        (e.g. max queue is 5, you enque 4 items, deque 3, agaqin enque 4)

COVERAGE
    combinations of paths
    combos of call sequences

NOT printQueue() method.

*/
    
    
    ////////// PASS
    /**
     * Test of iterator methods & toArray method
     */
    @Test
    public void testIteratorAndToArray() {
        System.out.println("Test: iterator & toArray");
        
        // create instance        
        RoundFIFOQueueString instance = new RoundFIFOQueueString(5);
        
        // add data
        String[] testVals = new String[]{"first", "second", "third"};
        
        instance.enqueue(testVals[2], false);
        instance.enqueue(testVals[1], false);
        instance.enqueue(testVals[0], false);
        
        // create iterator
        Iterator testIterator = instance.iterator();
        
        String[] testStringArray = new String[3];
        int i = 0;
        while(testIterator.hasNext()) {
            testStringArray[i] = (String) testIterator.next();
            i++;
        }
        
        // REMEMBER: iterator uses the toArray method, which REVERSES the order!
        for (int j = 0; j < testStringArray.length; j++) {
            assertEquals(testVals[j], testStringArray[j]);
        }
        
        String[] template = new String[3]; // size is 3
        String[] expResult = instance.toArray(template);
        
        assertEquals(testVals.length, expResult.length);
        
        for (int j = 0; j < 3; j++) {
            assertEquals(testVals[j], expResult[j]);
        }
        
    }

    ////////// PASS
    /**
     * Test of enqueue & dequeue & size methods, of class RoundFIFOQueueString.
     * Tests Exception thrown during dequeue of size 0;
     */
    @Test
    public void testEnqueueDequeueSize() {
        System.out.println("Test: enqueue, dequeue, size, dequeue-too-many");
        
        // create instance        
        RoundFIFOQueueString instance = new RoundFIFOQueueString(5);
        
        // add data
        boolean willGrow = false;
        String[] testVals = new String[]{"first", "second", "third"};
        
        // initial size test
        assertEquals(0, instance.size());
        
        // ENQUEUE TESTS
        instance.enqueue(testVals[0], willGrow);
        assertEquals(1, instance.size());
        
        instance.enqueue(testVals[1], willGrow);
        assertEquals(2, instance.size());
        
        instance.enqueue(testVals[2], willGrow);
        assertEquals(3, instance.size());
        
        // DEQUEUE TESTS
        assertEquals("first", instance.dequeue());
        assertEquals(2, instance.size());
        
        assertEquals("second", instance.dequeue());
        assertEquals(1, instance.size());
        
        assertEquals("third", instance.dequeue());
        assertEquals(0, instance.size());
        
        // test dequeueing one too many
        try {
            instance.dequeue();
            fail();
        } catch (RuntimeException e) {
            //pass
        }

    }

    ////// PASS
    /**
     * Test of countValues method
     */
    @Test
    public void testCountValues() {
        System.out.println("Basic test: countValues");
        
       // create instance        
        RoundFIFOQueueString instance = new RoundFIFOQueueString(5);
        
        // add data
        boolean willGrow = false;
        String[] testVals = new String[]{"first", "second", "third"};
        
        // initial size test
        assertEquals(0, instance.size());
        
        // ENQUEUE 4x same val
        
        instance.enqueue(testVals[0], willGrow);
        assertEquals(1, instance.size());
        
        instance.enqueue(testVals[0], willGrow);
        assertEquals(2, instance.size());
        
        instance.enqueue(testVals[0], willGrow);
        assertEquals(3, instance.size());
        
        instance.enqueue(testVals[0], willGrow);
        assertEquals(4, instance.size());
        
        assertEquals(4, instance.countValues(testVals[0]));

    }

    /**
     * Elaborate testing (many method calls, overSize, not growable)
     */
    @Test
    public void testManyCalls() {
        // added these tests to the one above, to avoid redundancy!!
    }

    
    
}
