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
public class LinkedListArrayOfStringsIT {
    
    public LinkedListArrayOfStringsIT() {
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

    /**
     * Test of getSize method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testGetSize() {
        System.out.println("getSize");
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        int expResult = 0;
        int result = instance.getSize();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of add method, of class LinkedListArrayOfStrings.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        String value = "";
        LinkedListArrayOfStrings instance = new LinkedListArrayOfStrings();
        instance.add(value);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
