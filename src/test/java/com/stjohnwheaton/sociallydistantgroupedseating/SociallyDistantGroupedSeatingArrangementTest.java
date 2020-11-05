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
public class SociallyDistantGroupedSeatingArrangementTest {
    
    public SociallyDistantGroupedSeatingArrangementTest() {
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
     * Test of AddSeatingGroup method, of class SociallyDistantGroupedSeatingArrangement.
     */
    @Test
    public void testAddSeatingGroup() {
        System.out.println("AddSeatingGroup");
        SeatingGroup group = new SeatingGroup(5,null);
        SociallyDistantGroupedSeatingArrangement instance = new SociallyDistantGroupedSeatingArrangement();
        boolean expResult = true;
        boolean result = instance.addSeatingGroup(group);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of AddSeatingRow method, of class SociallyDistantGroupedSeatingArrangement.
     */
    @Test
    public void testAddSeatingRow() {
        System.out.println("AddSeatingRow");
        SeatingRow row = new SeatingRow().setSize(5);
        SociallyDistantGroupedSeatingArrangement instance = new SociallyDistantGroupedSeatingArrangement();
        boolean expResult = true;
        boolean result = instance.addSeatingRow(row);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

//    /**
//     * Test of setSeating method, of class SociallyDistantGroupedSeatingArrangement.
//     */
//    @Test
//    public void testSetSeating() {
//        System.out.println("setSeating");
//        SeatingGroups alreadySeatedGroups = null;
//        SeatingRows rowsAlreadyOccupied = null;
//        SeatingRows rowsStillEmpty = null;
//        SociallyDistantGroupedSeatingArrangement instance = new SociallyDistantGroupedSeatingArrangement();
//        SociallyDistantGroupedSeatingArrangement expResult = null;
//        SociallyDistantGroupedSeatingArrangement result = instance.setSeating(alreadySeatedGroups, rowsAlreadyOccupied, rowsStillEmpty);
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
  
    /**
     * Test seating swap
     */
    @Test
    public void testSeatAllGroups()
    {
        SeatingGroups seatingGroups = new SeatingGroups();
        Hashtable sg1Info = new Hashtable();
        sg1Info.put("Name","Group 1");
        sg1Info.put("Number of People","5");
        SeatingGroup seatingGroup1 = new SeatingGroup(5,sg1Info);
        seatingGroups.add(seatingGroup1);
        Hashtable sg2Info = new Hashtable();
        sg2Info.put("Name","Group 2");
        sg2Info.put("Number of People","2");
        SeatingGroup seatingGroup2 = new SeatingGroup(2,sg2Info);
        seatingGroups.add(seatingGroup2);
        
        SeatingRows seatingRows = new SeatingRows();
        Hashtable sr1Info = new Hashtable();
        sr1Info.put("Pew #","15");
        sr1Info.put("Section","Front Right");
        SeatingRow seatingRow1 = new SeatingRow().setSize(10).setDistanceFromFront(1).setInfo(sr1Info);
        seatingRows.add(seatingRow1);
        
        SociallyDistantGroupedSeatingArrangement instance = new SociallyDistantGroupedSeatingArrangement(seatingGroups,seatingRows);
        boolean expectedResult = true;
        instance.seatAllGroups();
        //assertEquals(expectedResult,result);
        
        ArrayList<SeatingGroup> expectedUnSeatedGroups = new ArrayList();
        ArrayList<SeatingGroup> unSeatedGroups = instance.getUnSeatedGroups();
        assertEquals(expectedUnSeatedGroups,unSeatedGroups);
        
        
        ArrayList<SeatingGroup> expectedSeatedGroups = new ArrayList();
        expectedSeatedGroups.add(seatingGroup1);
        expectedSeatedGroups.add(seatingGroup2);
        ArrayList<SeatingGroup> seatedGroups = instance.getSeatedGroups();
        for (int i=0;i<seatedGroups.size();i++)
        {
            assertEquals(expectedSeatedGroups.get(i).getGroupSize(),seatedGroups.get(i).getGroupSize());
        }
        
    }
    
      
}
