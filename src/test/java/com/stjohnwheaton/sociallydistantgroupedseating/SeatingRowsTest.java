/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stjohnwheaton.sociallydistantgroupedseating;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author emili
 */
public class SeatingRowsTest {
    
    public SeatingRowsTest() {
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

//    /**
//     * Test of addSeatingRow method, of class SeatingRows.
//     */
//    @Test
//    public void testAddSeatingRow() {
//        System.out.println("addSeatingRow");
//        int rowsFromFront = 0;
//        int numberOfSeats = 0;
//        Hashtable info = null;
//        SeatingRows instance = new SeatingRows();
//        instance.addSeatingRow(rowsFromFront, numberOfSeats, info);
//        SeatingRow expectedRow = new SeatingRow().setSize(numberOfSeats).setInfo(info).setDistanceFromFront(rowsFromFront);
//        assertEquals(instance.contains(expectedRow),true);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

    /**
     * Test of getSeatingRowSizes method, of class SeatingRows.
     */
    @Test
    public void testGetSeatingRowSizes() {
        System.out.println("getSeatingRowSizes");
        SeatingRows instance = new SeatingRows();
        int numberOfSeats1 = 5;
        SeatingRow row1 = new SeatingRow().setSize(numberOfSeats1);
        instance.add(row1);
        int numberOfSeats2 = 12;
        SeatingRow row2 = new SeatingRow().setSize(numberOfSeats2);
        instance.add(row2);
       
        int[] expResult = new int[2];
        expResult[0]= numberOfSeats1;
        expResult[1] = numberOfSeats2;
        
        int[] result = instance.getSeatingRowSizes();
        
        assertArrayEquals(expResult, result);

    }

    
    /**
     * Test of getSeatingRowSizes method, of class SeatingRows.
     * no rows/null
     */
    @Test
    public void testGetSeatingRowSizesNoRows() {
        System.out.println("getSeatingRowSizes - no rows/null");
        SeatingRows instance = new SeatingRows();
        int[] expResult = new int[0];
        int[] result = instance.getSeatingRowSizes();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
//    /**
//     * Test of getFrontmostRowBySize method, of class SeatingRows.
//     */
//    @Test
//    public void testGetFrontmostRowBySize() {
//        System.out.println("getFrontmostRowBySize");
//        int size = 0;
//        SeatingRows instance = new SeatingRows();
//        SeatingRow expResult = null;
//        SeatingRow result = instance.getFrontmostRowBySize(size);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getRowsWithAvailableSeats method, of class SeatingRows.
     * no rows/null
     */
    @Test
    public void testGetRowsWithAvailableSeatsNoRows() {
        System.out.println("getRowsWithAvailableSeats - no rows/null");
        SeatingRows instance = new SeatingRows();
        ArrayList<SeatingRow> expResult = new ArrayList();
        ArrayList<SeatingRow> result = instance.getRowsWithAvailableSeats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getRowsWithAvailableSeats method, of class SeatingRows.
     * no groups seated
     */
    @Test
    public void testGetRowsWithAvailableSeatsNoGroups() {
        System.out.println("getRowsWithAvailableSeats - no groups seated");
        SeatingRows instance = new SeatingRows();
        int numberOfSeats1 = 5;
        SeatingRow row1 = new SeatingRow().setSize(numberOfSeats1);
        instance.add(row1);
        int numberOfSeats2 = 12;
        SeatingRow row2 = new SeatingRow().setSize(numberOfSeats2);
        instance.add(row2);

        ArrayList<SeatingRow> expResult = new ArrayList();
        expResult.add(row1);
        expResult.add(row2);
        
        ArrayList<SeatingRow> result = instance.getRowsWithAvailableSeats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of getRowsWithAvailableSeats method, of class SeatingRows.
     * with groups seated
     */
    @Test
    public void testGetRowsWithAvailableSeatsWithGroups() {
        System.out.println("getRowsWithAvailableSeats - with groups seated");
        SeatingRows instance = new SeatingRows();
        int numberOfSeats1 = 5;
        SeatingRow row1 = new SeatingRow().setSize(numberOfSeats1).setInfo(new Hashtable());
        row1.seatGroup(new SeatingGroup(5,new Hashtable()));
        instance.add(row1);
        int numberOfSeats2 = 12;
        SeatingRow row2 = new SeatingRow().setSize(numberOfSeats2);
        instance.add(row2);

        ArrayList<SeatingRow> expResult = new ArrayList();
        expResult.add(row2);
        
        ArrayList<SeatingRow> result = instance.getRowsWithAvailableSeats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of size method, of class SeatingRows.
     * no rows
     */
    @Test
    public void testSizeNoRows() {
        System.out.println("size - no rows");
        SeatingRows instance = new SeatingRows();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    /**
     * Test of size method, of class SeatingRows.
     */
    @Test
    public void testSize() {
        System.out.println("size - no rows");
        SeatingRows instance = new SeatingRows();
        int numberOfSeats1 = 5;
        SeatingRow row1 = new SeatingRow().setSize(numberOfSeats1);
        instance.add(row1);
        int numberOfSeats2 = 12;
        SeatingRow row2 = new SeatingRow().setSize(numberOfSeats2);
        instance.add(row2);

        int expResult = 2;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    /**
     * Test of isEmpty method, of class SeatingRows.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SeatingRows instance = new SeatingRows();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class SeatingRows.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        SeatingRow row = new SeatingRow().setSize(5).setInfo(null);
        SeatingRows instance = new SeatingRows();
        instance.add(row);
        boolean expResult = true;
        boolean result = instance.contains(row);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of iterator method, of class SeatingRows.
//     */
//    @Test
//    public void testIterator() {
//        System.out.println("iterator");
//        SeatingRows instance = new SeatingRows();
//        Iterator<SeatingRow> expResult = null;
//        Iterator<SeatingRow> result = instance.iterator();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        //fail("The test case is a prototype.");
//    }

//    /**
//     * Test of toArray method, of class SeatingRows.
//     */
//    @Test
//    public void testToArray_0args() {
//        System.out.println("toArray");
//        SeatingRows instance = new SeatingRows();
//        Object[] expResult = null;
//        Object[] result = instance.toArray();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of toArray method, of class SeatingRows.
//     */
//    @Test
//    public void testToArray_GenericType() {
//        System.out.println("toArray");
//        Object[] a = null;
//        SeatingRows instance = new SeatingRows();
//        Object[] expResult = null;
//        Object[] result = instance.toArray(a);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of add method, of class SeatingRows.
//     */
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        SeatingRow e = null;
//        SeatingRows instance = new SeatingRows();
//        boolean expResult = false;
//        boolean result = instance.add(e);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of remove method, of class SeatingRows.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
         SeatingRow row = new SeatingRow().setSize(5).setInfo(null);
        SeatingRows instance = new SeatingRows();
        instance.add(row);
        boolean expResult = true;
        boolean result = instance.remove(row);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of containsAll method, of class SeatingRows.
//     */
//    @Test
//    public void testContainsAll() {
//        System.out.println("containsAll");
//        Collection c = null;
//        SeatingRows instance = new SeatingRows();
//        boolean expResult = false;
//        boolean result = instance.containsAll(c);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addAll method, of class SeatingRows.
//     */
//    @Test
//    public void testAddAll() {
//        System.out.println("addAll");
//        Collection<? extends SeatingRow> c = null;
//        SeatingRows instance = new SeatingRows();
//        boolean expResult = false;
//        boolean result = instance.addAll(c);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeAll method, of class SeatingRows.
//     */
//    @Test
//    public void testRemoveAll() {
//        System.out.println("removeAll");
//        Collection c = null;
//        SeatingRows instance = new SeatingRows();
//        boolean expResult = false;
//        boolean result = instance.removeAll(c);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of retainAll method, of class SeatingRows.
//     */
//    @Test
//    public void testRetainAll() {
//        System.out.println("retainAll");
//        Collection c = null;
//        SeatingRows instance = new SeatingRows();
//        boolean expResult = false;
//        boolean result = instance.retainAll(c);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of clear method, of class SeatingRows.
//     */
//    @Test
//    public void testClear() {
//        System.out.println("clear");
//        SeatingRows instance = new SeatingRows();
//        instance.clear();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
