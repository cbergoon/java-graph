package com.cbergoon.utility;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Pair.
 */
public class PairTest extends TestCase {
	
    /**
     * Create the test case
     * @param testName name of the test case
     */
    public PairTest(String testName){
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite(PairTest.class);
    }

    /**
     * Test Create
     */
    public void testCreate(){
    	Pair<String, String> ps1 = new Pair<String, String>();
        assertEquals(null, ps1.getFirst());
        assertEquals(null, ps1.getSecond());
    	
    	Pair<String, String> ps2 = new Pair<String, String>("f", "s");
    	assertEquals("f", ps2.getFirst());
        assertEquals("s", ps2.getSecond());
        
    	Pair<String, Integer> pi1 = new Pair<String, Integer>();
    	assertEquals(null, pi1.getFirst());
        assertEquals(null, pi1.getSecond());
    	
        Pair<Integer, String> pi2 = new Pair<Integer, String>(1, "s");
        assertEquals(Integer.valueOf(1), pi2.getFirst());
        assertEquals("s", pi2.getSecond());
    }
    
    /**
     * Test Data Consistency
     */
    public void testData(){
    	Pair<String, Integer> pi1 = new Pair<String, Integer>();
    	assertEquals(null, pi1.getFirst());
        assertEquals(null, pi1.getSecond());
        
        pi1.setFirst("Hello");
        assertEquals("Hello", pi1.getFirst());
        pi1.setSecond(100);
        assertEquals(Integer.valueOf(100), pi1.getSecond());
        pi1.setFirst("Hello1");
        assertEquals("Hello1", pi1.getFirst());
        pi1.setSecond(101);
        assertEquals(Integer.valueOf(101), pi1.getSecond());
        
        Pair<Integer, String> pi2 = new Pair<Integer, String>(1, "s");
        assertEquals(Integer.valueOf(1), pi2.getFirst());
        assertEquals("s", pi2.getSecond());
        pi2.setFirst(101);
        assertEquals(Integer.valueOf(101), pi2.getFirst());
        pi2.setSecond("Hello1");
        assertEquals("Hello1", pi2.getSecond());
    }
    
    /**
     * Test Equals
     */
    public void testEquals(){
    	Pair<String, Integer> pi1 = new Pair<String, Integer>();
    	Pair<String, Integer> pi2 = new Pair<String, Integer>();
    	Pair<Integer, String> pi3 = new Pair<Integer, String>();
    	Pair<Integer, String> pi4 = new Pair<Integer, String>(1, "s");
    	Pair<Integer, String> pi5 = new Pair<Integer, String>(10, "hello");
    	Pair<Integer, String> pi6 = new Pair<Integer, String>(10, "hello");
    	
    	assertTrue(pi1.equals(pi2));
    	assertTrue(pi5.equals(pi6));
    	
    	assertTrue(pi1.equals(pi3));
    	
    	assertFalse(pi1.equals(pi4));
    	assertFalse(pi1.equals(pi5));
    	
    	assertTrue(pi2.equals(pi3));
    	
    	assertFalse(pi4.equals(pi5));
    	assertFalse(pi4.equals(pi6));
    }
    
    /**
     * Test Hash Code
     */
    public void testHashCode(){
    	Pair<Integer, String> pi1 = new Pair<Integer, String>();
    	Pair<Integer, String> pi2 = new Pair<Integer, String>(1, "s");
    	Pair<Integer, String> pi3 = new Pair<Integer, String>(10, "hello");
    	
    	assertNotNull(pi1.hashCode());
    	assertNotNull(pi2.hashCode());
    	assertNotNull(pi3.hashCode());
    }
    
}
