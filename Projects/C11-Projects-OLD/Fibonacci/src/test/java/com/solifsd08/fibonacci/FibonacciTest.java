/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.solifsd08.fibonacci;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author solil
 */
public class FibonacciTest {
    
    public FibonacciTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getCountFibsComputed method, of class Fibonacci.
     */
    @org.junit.jupiter.api.Test
    public void testGetCountFibsComputed() {
        System.out.println("getCountFibsComputed");
        Fibonacci instance = new Fibonacci();
        int expResult = 0;
        int result = instance.getCountFibsComputed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCountFibsNotComputed method, of class Fibonacci.
     */
    @org.junit.jupiter.api.Test
    public void testGetCountFibsNotComputed() {
        System.out.println("getCountFibsNotComputed");
        Fibonacci instance = new Fibonacci();
        int expResult = 0;
        int result = instance.getCountFibsNotComputed();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFibsCachedSize method, of class Fibonacci.
     */
    @org.junit.jupiter.api.Test
    public void testGetFibsCachedSize() {
        System.out.println("getFibsCachedSize");
        Fibonacci instance = new Fibonacci();
        int expResult = 0;
        int result = instance.getFibsCachedSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incCountFibsComputed method, of class Fibonacci.
     */
    @org.junit.jupiter.api.Test
    public void testIncCountFibsComputed() {
        System.out.println("incCountFibsComputed");
        Fibonacci instance = new Fibonacci();
        instance.incCountFibsComputed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of incCountFibsNotComputed method, of class Fibonacci.
     */
    @org.junit.jupiter.api.Test
    public void testIncCountFibsNotComputed() {
        System.out.println("incCountFibsNotComputed");
        Fibonacci instance = new Fibonacci();
        instance.incCountFibsNotComputed();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNthFib method, of class Fibonacci.
     */
    @org.junit.jupiter.api.Test
    public void testGetNthFib() {
        System.out.println("getNthFib");
        int n = 0;
        Fibonacci instance = new Fibonacci();
        long expResult = 0L;
        long result = instance.getNthFib(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of computeNthFib method, of class Fibonacci.
     */
    @org.junit.jupiter.api.Test
    public void testComputeNthFib() {
        System.out.println("computeNthFib");
        int n = 0;
        Fibonacci instance = new Fibonacci();
        long expResult = 0L;
        long result = instance.computeNthFib(n);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Fibonacci.
     */
    @org.junit.jupiter.api.Test
    public void testToString() {
        System.out.println("toString");
        Fibonacci instance = new Fibonacci();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of singleObjOutSetup method, of class Fibonacci.
     */
    @org.junit.jupiter.api.Test
    public void testSingleObjOutSetup() {
        System.out.println("singleObjOutSetup");
        Fibonacci.singleObjOutSetup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of singleObjTestOutput method, of class Fibonacci.
     */
    @org.junit.jupiter.api.Test
    public void testSingleObjTestOutput() {
        System.out.println("singleObjTestOutput");
        int n = 0;
        Fibonacci obj = null;
        Fibonacci.singleObjTestOutput(n, obj);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class Fibonacci.
     */
    @org.junit.jupiter.api.Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        Fibonacci.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetCounts method, of class Fibonacci.
     */
    @org.junit.Test
    public void testResetCounts() {
        System.out.println("resetCounts");
        Fibonacci instance = new Fibonacci();
        instance.resetCounts();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
