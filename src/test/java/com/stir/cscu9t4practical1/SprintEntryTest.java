/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.stir.cscu9t4practical1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author saemundur
 */
public class SprintEntryTest {
    
    public SprintEntryTest() {
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
     * Test of getName method, of class SprintEntry.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300,
                "4x300m with 6 minute recovery in between");
        String expResult = "Alice";
        String result = instance.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDay method, of class SprintEntry.
     */
    @Test
    public void testGetDay() {
        System.out.println("getDay");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 900,
                "4x300m with 6 minute recovery in between");
        int expResult = 1;
        int result = instance.getDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMonth method, of class SprintEntry.
     */
    @Test
    public void testGetMonth() {
        System.out.println("getMonth");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300,
                "4x300m with 6 minute recovery in between");
        int expResult = 2;
        int result = instance.getMonth();
        assertEquals(expResult, result);
    }

    /**
     * Test of getYear method, of class SprintEntry.
     */
    @Test
    public void testGetYear() {
        System.out.println("getYear");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300,
        "4x300m with 6 minute recovery in between");
        int expResult = 2003;
        int result = instance.getYear();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHour method, of class SprintEntry.
     */
    @Test
    public void testGetHour() {
        System.out.println("getHour");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300,
        "4x300m with 6 minute recovery in between");
        int expResult = 0;
        int result = instance.getHour();
        assertEquals(expResult, result);
    }

    /**
     * Test of getMin method, of class SprintEntry.
     */
    @Test
    public void testGetMin() {
        System.out.println("getMin");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300,
        "4x300m with 6 minute recovery in between");
        int expResult = 16;
        int result = instance.getMin();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSec method, of class SprintEntry.
     */
    @Test
    public void testGetSec() {
        System.out.println("getSec");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300,
        "4x300m with 6 minute recovery in between");
        int expResult = 7;
        int result = instance.getSec();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDistance method, of class SprintEntry.
     */
    @Test
    public void testGetDistance() {
        System.out.println("getDistance");
        Entry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 3,
        "4x300m with 6 minute recovery in between");
        float expResult = 3.0F;
        float result = instance.getDistance();
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of getTypeOfRun method of class SprintEntry
     */
    @Test
    public void testGetTypeOfRun() {
        System.out.println("getRepetitions");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 300,
        "4x300m with 6 minute recovery in between");
        String expResult = "4x300m with 6 minute recovery in between";
        String result = instance.getTypeOfRun();
        assertEquals(expResult, result);
    }

    /**
     * Test of getEntry method, of class SprintEntry.
     */
    @Test
    public void testGetEntry() {
        System.out.println("getEntry");
        SprintEntry instance = new SprintEntry("Alice", 1, 2, 2003, 0, 16, 7, 1.2f,
        "4x300m with 6 minute recovery in between");
        String expResult = "Alice ran a 4x300m with 6 minute recovery in between, covering 1.2 km in total, in a time of 0:16:7,"
                + " on 1/2/2003\n";
        String result = instance.getEntry();
        assertEquals(expResult, result);
    }
    
}