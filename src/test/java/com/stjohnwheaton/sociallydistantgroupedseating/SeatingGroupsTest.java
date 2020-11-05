/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stjohnwheaton.sociallydistantgroupedseating;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.function.Predicate;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *
 * @author emili
 */
public class SeatingGroupsTest {
    
    public SeatingGroupsTest() {
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
     * Test of clear method, of class SeatingGroups.
     */
    @Test
    public void testClear() {
        System.out.println("clear");
        SeatingGroups instance = new SeatingGroups();
        instance.clear();
        
        assertEquals(instance.size(),0);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of size method, of class SeatingGroups.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        SeatingGroups instance = new SeatingGroups();
        int expResult = 0;
        int result = instance.size();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of isEmpty method, of class SeatingGroups.
     */
    @Test
    public void testIsEmpty() {
        System.out.println("isEmpty");
        SeatingGroups instance = new SeatingGroups();
        boolean expResult = true;
        boolean result = instance.isEmpty();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class SeatingGroups.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        SeatingGroup sg = new SeatingGroup(5,null);
        SeatingGroups instance = new SeatingGroups();
        boolean expResult = false;
        boolean result = instance.contains(sg);
        assertEquals(expResult, result);
        expResult=true;
        instance.add(sg);
        result = instance.contains(sg);
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of iterator method, of class SeatingGroups.
//     */
//    @Test
//    public void testIterator() {
//        System.out.println("iterator");
//        SeatingGroups instance = new SeatingGroups();
//        Iterator expResult = null;
//        Iterator result = instance.iterator();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toArray method, of class SeatingGroups.
//     */
//    @Test
//    public void testToArray_0args() {
//        System.out.println("toArray");
//        SeatingGroups instance = new SeatingGroups();
//        Object[] expResult = null;
//        Object[] result = instance.toArray();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toArray method, of class SeatingGroups.
//     */
//    @Test
//    public void testToArray_ObjectArr() {
//        System.out.println("toArray");
//        Object[] a = null;
//        SeatingGroups instance = new SeatingGroups();
//        Object[] expResult = null;
//        Object[] result = instance.toArray(a);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of toArray method, of class SeatingGroups.
//     */
//    @Test
//    public void testToArray_IntFunction() {
//        System.out.println("toArray");
//        IntFunction generator = null;
//        SeatingGroups instance = new SeatingGroups();
//        Object[] expResult = null;
//        Object[] result = instance.toArray(generator);
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

//    /**
//     * Test of add method, of class SeatingGroups.
//     */
//    @Test
//    public void testAdd() {
//        System.out.println("add");
//        SeatingGroup sg = null;
//        SeatingGroups instance = new SeatingGroups();
//        boolean expResult = false;
//        boolean result = instance.add(sg);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of remove method, of class SeatingGroups.
//     */
//    @Test
//    public void testRemove() {
//        System.out.println("remove");
//        Object o = null;
//        SeatingGroups instance = new SeatingGroups();
//        boolean expResult = false;
//        boolean result = instance.remove(o);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of containsAll method, of class SeatingGroups.
//     */
//    @Test
//    public void testContainsAll() {
//        System.out.println("containsAll");
//        Collection c = null;
//        SeatingGroups instance = new SeatingGroups();
//        boolean expResult = false;
//        boolean result = instance.containsAll(c);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addAll method, of class SeatingGroups.
//     */
//    @Test
//    public void testAddAll() {
//        System.out.println("addAll");
//        Collection c = null;
//        SeatingGroups instance = new SeatingGroups();
//        boolean expResult = false;
//        boolean result = instance.addAll(c);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of removeAll method, of class SeatingGroups.
//     */
//    @Test
//    public void testRemoveAll() {
//        System.out.println("removeAll");
//        Collection c = null;
//        SeatingGroups instance = new SeatingGroups();
//        boolean expResult = false;
//        boolean result = instance.removeAll(c);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of removeIf method, of class SeatingGroups.
     */
    @Test
    public void testRemoveIf() {
        System.out.println("removeIf");
        Predicate<SeatingGroup> lessThanOrEqual = i -> (i.getGroupSize() <= 2);
        SeatingGroups instance = new SeatingGroups();
        SeatingGroup seatingGroup1 = new SeatingGroup(5,null);
        instance.add(seatingGroup1);
        SeatingGroup seatingGroup2 = new SeatingGroup(2,null);
        instance.add(seatingGroup2);
        boolean expResult = true;
        boolean result = instance.removeIf(lessThanOrEqual);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of retainAll method, of class SeatingGroups.
//     */
//    @Test
//    public void testRetainAll() {
//        System.out.println("retainAll");
//        Collection c = null;
//        SeatingGroups instance = new SeatingGroups();
//        boolean expResult = false;
//        boolean result = instance.retainAll(c);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of forEach method, of class SeatingGroups.
//     */
//    @Test
//    public void testForEach() {
//        System.out.println("forEach");
//        Consumer action = null;
//        SeatingGroups instance = new SeatingGroups();
//        instance.forEach(action);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /**
     * Test of getGroupSizes method, of class SeatingGroups.
     */
    @Test
    public void testGetGroupSizes() {
        System.out.println("getGroupSizes");
        SeatingGroups instance = new SeatingGroups();
        ArrayList<Integer> expResult = new ArrayList();
        ArrayList<Integer> result = instance.getGroupSizes();
        assertEquals(expResult, result);
        
        SeatingGroup seatingGroup1 = new SeatingGroup(5,null);
        instance.add(seatingGroup1);
        expResult.add(5);
        SeatingGroup seatingGroup2 = new SeatingGroup(2,null);
        instance.add(seatingGroup2);
        expResult.add(2);
        
        result = instance.getGroupSizes();
        assertEquals(expResult, result);
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetCopyForSubsets()
    {
        System.out.println("getGetCopyForSubsets");
        int expectedResult;
        SeatingGroups instance = new SeatingGroups();
        SeatingGroup seatingGroup1 = new SeatingGroup(5,new Hashtable());
        instance.add(seatingGroup1);
        SeatingGroup seatingGroup2 = new SeatingGroup(2,new Hashtable());
        instance.add(seatingGroup2);
        expectedResult=2;
        
        assertEquals(expectedResult, instance.size());
        
        SeatingGroups resultGroups = instance.getCopyForSubsets();
        
        assertEquals(expectedResult, resultGroups.size());
        
        resultGroups.remove(seatingGroup1);
        
        assertEquals(expectedResult-1,resultGroups.size());
        
        assertEquals(expectedResult, instance.size());
        
    }
    
}
