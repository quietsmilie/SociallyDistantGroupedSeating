/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stjohnwheaton.sociallydistantgroupedseating;

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
public class SeatingGroupTest {
    
    public SeatingGroupTest() {
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
     * Test of set method, of class SeatingGroup.
     */
    @Test
    public void testSetNull() {
        System.out.println("set null");
        int size = 0;
        Hashtable info = null;
        SeatingGroup instance = new SeatingGroup();
        instance.set(size, info);
        assertEquals(instance.getGroupSize(),size);
        assertEquals(instance.getGroupInfo(),info);
    }
    /**
     * Test of set method, of class SeatingGroup.
     */
    @Test
    public void testSet() {
        System.out.println("set size & info");
        int size = 5;
        Hashtable info = new Hashtable();
        info.put("name","My Name");
        info.put("email","abc@def.com");
        SeatingGroup instance = new SeatingGroup();
        instance.set(size, info);
        assertEquals(instance.getGroupSize(),size);
        assertEquals(instance.getGroupInfo(),info);
    }
    
}
