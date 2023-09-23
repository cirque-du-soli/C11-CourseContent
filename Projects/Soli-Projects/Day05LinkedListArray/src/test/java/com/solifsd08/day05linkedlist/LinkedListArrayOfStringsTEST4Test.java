/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.solifsd08.day05linkedlist;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author solil
 */
public class LinkedListArrayOfStringsTEST4Test {
    
    public LinkedListArrayOfStringsTEST4Test() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    //////////////////////////// BASIC TESTS ///////////////////////
    /**
     * Tests of getSize()
     */
    @Test
    public void testGetSize0() {
        System.out.println("***** Test of getSize() (initial condition) *****");
        LinkedListArrayOfStrings llas = new LinkedListArrayOfStrings();
        assertEquals(0, llas.getSize());
    }
    
    @Test
    public void testGetSize1() {
        System.out.println("***** Test of getSize() (later (5 item) condition) *****");
        LinkedListArrayOfStrings llas = new LinkedListArrayOfStrings();
        llas.add("aaa");
        llas.add("bbb");
        llas.add("ccc");
        llas.add("ddd");
        llas.add("eee");
        assertEquals(5, llas.getSize());
    }

    /**
     * Test of add() and get()
     */
    @Test
    public void testAddAndGet() {
        System.out.println("***** Test of add() and get() *****");
        LinkedListArrayOfStrings llas = new LinkedListArrayOfStrings();
        llas.add("aaa");
        llas.add("bbb");
        llas.add("ccc");
        llas.add("ddd");
        llas.add("eee");
        assertEquals("aaa", llas.get(0));
        assertEquals("bbb", llas.get(1));
        assertEquals("ccc", llas.get(2));
        assertEquals("ddd", llas.get(3));
        assertEquals("eee", llas.get(4));
        
    }
    
    /**
     * Test that add() throws IOOB exceptions
     */
    @Test
    public void testAddIOOB() {
        System.out.println("***** Test of add() IOOB *****");
        LinkedListArrayOfStrings llas = new LinkedListArrayOfStrings();
        
        assertThrows(IndexOutOfBoundsException.class, () -> {
            llas.get(-1);
        });
        assertThrows(IndexOutOfBoundsException.class, () -> {
            llas.get(llas.getSize()); // edge case
        });
    }
    
    /**
     * Test of get method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        int index = 0;
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        String expResult = "";
        String result = instance.get(index);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of insertValueAtIndex method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testInsertValueAtIndex() {
        System.out.println("insertValueAtIndex");
        String value = "";
        int index = 0;
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.insertValueAtIndex(value, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of replaceValueAtIndex method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testReplaceValueAtIndex() {
        System.out.println("replaceValueAtIndex");
        String value = "";
        int index = 0;
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.replaceValueAtIndex(value, index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByIndex method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testDeleteByIndex() {
        System.out.println("deleteByIndex");
        int index = 0;
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.deleteByIndex(index);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteByValue method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testDeleteByValue() {
        System.out.println("deleteByValue");
        String value = "";
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        boolean expResult = false;
        boolean result = instance.deleteByValue(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of main method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testMain() {
        System.out.println("main");
        String[] args = null;
        LinkedListArrayOfStrings.main(args);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
