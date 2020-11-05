/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stjohnwheaton.sociallydistantgroupedseating;

import java.util.ArrayList;
import java.util.Hashtable;
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
public class SeatingRowTest {
    
    public SeatingRowTest() {
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
     * Test of setSize method, of class SeatingRow.
     */
    @Test
    public void testSetSize() {
        System.out.println("setSize");
        int size = 5;
        SeatingRow instance = new SeatingRow();
        int expResult = 5;
        int result = instance.setSize(size).getTotalSeats();
        assertEquals(expResult, result);
    }

    /**
     * Test of setInfo method, of class SeatingRow.
     */
    @Test
    public void testSetInfo() {
        System.out.println("setInfo");
        Hashtable info = new Hashtable();
        info.put("pewNumber","24A");
        info.put("door","A");
        info.put("section","5");
        SeatingRow instance = new SeatingRow();
        Hashtable expResult = info;
        Hashtable result = instance.setInfo(info).getInfo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of setDistanceFromFront method, of class SeatingRow.
     */
    @Test
    public void testSetDistanceFromFront() {
        System.out.println("setDistanceFromFront");
        int rowsFromFront = 3;
        SeatingRow instance = new SeatingRow();
        int expResult = 3;
        int result = instance.setDistanceFromFront(rowsFromFront).getDistanceFromFront();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of seatGroup method, of class SeatingRow.
     */
    @Test
    public void testSeatGroup() {
        System.out.println("seatGroup");
        SeatingGroup seatingGroup = new SeatingGroup(5,new Hashtable());
        SeatingRow instance = new SeatingRow().setSize(5);
        instance.setDistanceFromFront(1);
        boolean expResult = true;
        boolean result = instance.seatGroup(seatingGroup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of seatGroup method, of class SeatingRow.
     * Group size too large
     */
    @Test
    public void testSeatGroupTooLarge() {
        System.out.println("seatGroupTooLarge");
        SeatingGroup seatingGroup = new SeatingGroup(6,null);
        SeatingRow instance = new SeatingRow().setSize(5);
        boolean expResult = false;
        boolean result = instance.seatGroup(seatingGroup);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of unSeatGroup method, of class SeatingRow.
     * Dependent on seatGroup
     */
    @Test
    public void testUnSeatGroup() {
        System.out.println("unSeatGroup");
        SeatingGroup seatingGroup = new SeatingGroup(5,new Hashtable());
        SeatingRow instance = new SeatingRow().setSize(5).setInfo(new Hashtable());
        boolean expResult = true;
        boolean result = false;
        if (instance.seatGroup(seatingGroup))
        {
            result = instance.unSeatGroup(seatingGroup);
            assertEquals(expResult, result);            
        }

        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of unSeatGroup method, of class SeatingRow.
     * Group not seated in row
     */
    @Test
    public void testUnSeatGroupNotSeated() {
        System.out.println("unSeatGroup");
        SeatingGroup seatingGroup = new SeatingGroup(5,null);
        SeatingRow instance = new SeatingRow().setSize(5);
        boolean expResult = false;
        boolean result = instance.unSeatGroup(seatingGroup);
        assertEquals(expResult, result);            
        
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }  
    
    /**
     * Test of getGroups method, of class SeatingRow.
     * dependent on seatGroups
     */
    @Test
    public void testGetGroups() {
        System.out.println("getGroups");
        SeatingGroup seatingGroup1 = new SeatingGroup(5,new Hashtable());
        SeatingGroup seatingGroup2 = new SeatingGroup(2,new Hashtable());
        SeatingRow instance = new SeatingRow().setSize(10).setInfo(new Hashtable());
        instance.seatGroup(seatingGroup1);
        instance.seatGroup(seatingGroup2);
        ArrayList<SeatingGroup> expResult = new ArrayList();
        expResult.add(seatingGroup1);
        expResult.add(seatingGroup2);
        ArrayList<SeatingGroup> result = instance.getGroups();
        for (int i =0;i<result.size();i++)
        {
            assertEquals(expResult.get(i), result.get(i));
        }
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupSizes method, of class SeatingRow.
     * dependent on seatGroup
     */
    @Test
    public void testGetGroupSizes() {
        System.out.println("getGroupSizes");
        SeatingGroup seatingGroup1 = new SeatingGroup(5,new Hashtable());
        SeatingGroup seatingGroup2 = new SeatingGroup(2,new Hashtable());
        SeatingRow instance = new SeatingRow().setSize(10).setInfo(new Hashtable());
        instance.seatGroup(seatingGroup1);
        instance.seatGroup(seatingGroup2);
        ArrayList<Integer> expResult = new ArrayList();
        expResult.add(5);
        expResult.add(2);
        ArrayList<Integer> result = instance.getGroupSizes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of clearAllSeats method, of class SeatingRow.
     */
    @Test
    public void testClearAllSeats() {
        System.out.println("clearAllSeats");
        SeatingGroup seatingGroup1 = new SeatingGroup(5,new Hashtable());
        SeatingGroup seatingGroup2 = new SeatingGroup(2,new Hashtable());
        SeatingRow instance = new SeatingRow().setSize(10).setInfo(new Hashtable());
        instance.seatGroup(seatingGroup1);
        instance.seatGroup(seatingGroup2);
        
        instance.clearAllSeats();
        assertEquals(instance.getTotalSeats(),instance.availableSeats());
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of availableSeats method, of class SeatingRow.
     * dependent on seatGroup
     */
    @Test
    public void testAvailableSeats() {
        System.out.println("availableSeats");
        SeatingGroup seatingGroup1 = new SeatingGroup(5,new Hashtable());
        SeatingRow instance = new SeatingRow().setSize(10).setInfo(new Hashtable());
        instance.seatGroup(seatingGroup1);
        int expResult = 2;
        int result = instance.availableSeats();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}
