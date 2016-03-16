package com.cbergoon.graph;

import java.util.HashSet;
import java.util.Set;

import com.cbergoon.exceptions.InvalidVertexIndexException;
import com.cbergoon.exceptions.MaximumSizeReachedException;
import com.cbergoon.utility.Pair;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for Pair.
 */
public class AdjacencyListGraphTest extends TestCase {
	
	AdjacencyListGraph<String, String> testGraph = null;
	AdjacencyListGraph<String, String> testGraphLabel = null;
	AdjacencyListGraph<String, String> testGraphContent = null;
	AdjacencyListGraph<String, String> testGraphLabelContent = null;
	
    /**
     * Create the test case
     * @param testName name of the test case
     */
    public AdjacencyListGraphTest(String testName){
        super(testName);
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite(){
        return new TestSuite(AdjacencyListGraphTest.class);
    }
 
    /**
     * Test Graph Create
     */
    public void testCreate(){
    	AdjacencyListGraph<String, String> localGraph = new AdjacencyListGraph<String, String>();
    	assertNotNull(localGraph);
    	
    	testGraph = new AdjacencyListGraph<String, String>();
    	assertNotNull(testGraph);
    	
    	testGraphLabel = new AdjacencyListGraph<String, String>();
    	assertNotNull(testGraphLabel);
    	
    	testGraphContent = new AdjacencyListGraph<String, String>();
    	assertNotNull(testGraphContent);
    	
    	testGraphLabelContent = new AdjacencyListGraph<String, String>();
    	assertNotNull(testGraphLabelContent);
    }
    
    /**
     * Test Graph Add Vertex
     */
    public void testAddVertex(){
    	testCreate();
    	
	//No Labels, No Content.
    	Set<Integer> expectedVertices = new HashSet<Integer>();
    	for(int i = 0; i < 100; i++){
    		expectedVertices.add(i);
    		try {
				testGraph.addVertex();
			} catch (MaximumSizeReachedException e) {
				fail("Graph Exception Thrown");
			}
    	}
    	
    	assertEquals(expectedVertices, testGraph.getVertices());
    	assertEquals(testGraph.getNumVertices(), testGraph.getVertices().size());
    	
	//Labels, No Content.    	
    	expectedVertices = new HashSet<Integer>();
    	for(int i = 0; i < 100; i++){
    		expectedVertices.add(i);
    		try {
    			testGraphLabel.addVertex("Label" + i, null);
			} catch (MaximumSizeReachedException e) {
				fail("Graph Exception Thrown");
			}
    	}
    	
    	assertEquals(expectedVertices, testGraphLabel.getVertices());
    	assertEquals(testGraphLabel.getNumVertices(), testGraphLabel.getVertices().size());
    	
	//No Labels, Content.
    	expectedVertices = new HashSet<Integer>();
    	for(int i = 0; i < 100; i++){
    		expectedVertices.add(i);
    		try {
    			testGraphContent.addVertex(null, "Content" + i);
			} catch (MaximumSizeReachedException e) {
				fail("Graph Exception Thrown");
			}
    	}
    	
    	assertEquals(expectedVertices, testGraphContent.getVertices());
    	assertEquals(testGraphContent.getNumVertices(), testGraphContent.getVertices().size());

	//Labels, Content.
    	expectedVertices = new HashSet<Integer>();
    	for(int i = 0; i < 100; i++){
    		expectedVertices.add(i);
    		try {
    			testGraphLabelContent.addVertex("Label" + i, "Content" + i);
			} catch (MaximumSizeReachedException e) {
				fail("Graph Exception Thrown");
			}
    	}
    	
    	assertEquals(expectedVertices, testGraphLabelContent.getVertices());
    	assertEquals(testGraphLabelContent.getNumVertices(), testGraphLabelContent.getVertices().size());

    }
    
    /**
     * Test Graph Add Edge
     */
    public void testAddEdge(){
    	testCreate();
    	
    //No Labels, No Content.
    	Set<Integer> expectedVertices = new HashSet<Integer>();
    	for(int i = 0; i < 100; i++){
    		expectedVertices.add(i);
    		try {
				testGraph.addVertex();
			} catch (MaximumSizeReachedException e) {
				fail("Graph Exception Thrown");
			}
    	}
    	
    	Set<Pair<Integer, Integer>> expectedEdges = new HashSet<Pair<Integer, Integer>>();
    	for(Integer v1 : testGraph.getVertices()){
    		for(Integer v2 : testGraph.getVertices()){
    			try {
					testGraph.addEdge(v1, v2);
				} catch (InvalidVertexIndexException e) {
					fail("Invalid index for vertex.");
				}
    			expectedEdges.add(new Pair<Integer, Integer>(v1, v2));
    		}
    	}
    	
    	assertEquals(expectedEdges, testGraph.getEdges());
    	
    //Labels, No Content.    	
    	expectedVertices = new HashSet<Integer>();
    	for(int i = 0; i < 100; i++){
    		expectedVertices.add(i);
    		try {
    			testGraphLabel.addVertex("Label" + i, null);
			} catch (MaximumSizeReachedException e) {
				fail("Graph Exception Thrown");
			}
    	}
    	
    	expectedEdges = new HashSet<Pair<Integer, Integer>>();
    	for(Integer v1 : testGraphLabel.getVertices()){
    		for(Integer v2 : testGraphLabel.getVertices()){
    			try {
    				testGraphLabel.addEdge(v1, v2, "Label" + v1 + v2, null);
				} catch (InvalidVertexIndexException e) {
					fail("Invalid index for vertex.");
				}
    			expectedEdges.add(new Pair<Integer, Integer>(v1, v2));
    		}
    	}
    	
    	assertEquals(expectedEdges, testGraphLabel.getEdges());
    	
    //No Labels, Content.
    	expectedVertices = new HashSet<Integer>();
    	for(int i = 0; i < 100; i++){
    		expectedVertices.add(i);
    		try {
    			testGraphContent.addVertex(null, "Content" + i);
			} catch (MaximumSizeReachedException e) {
				fail("Graph Exception Thrown");
			}
    	}
    	
    	expectedEdges = new HashSet<Pair<Integer, Integer>>();
    	for(Integer v1 : testGraphContent.getVertices()){
    		for(Integer v2 : testGraphContent.getVertices()){
    			try {
    				testGraphContent.addEdge(v1, v2, null, "Content" + v1 + v2);
				} catch (InvalidVertexIndexException e) {
					fail("Invalid index for vertex.");
				}
    			expectedEdges.add(new Pair<Integer, Integer>(v1, v2));
    		}
    	}
    	
    	assertEquals(expectedEdges, testGraphContent.getEdges());
    	
    //Labels, Content.
    	expectedVertices = new HashSet<Integer>();
    	for(int i = 0; i < 100; i++){
    		expectedVertices.add(i);
    		try {
    			testGraphLabelContent.addVertex("Label" + i, "Content" + i);
			} catch (MaximumSizeReachedException e) {
				fail("Graph Exception Thrown");
			}
    	}
    	
    	expectedEdges = new HashSet<Pair<Integer, Integer>>();
    	for(Integer v1 : testGraphLabelContent.getVertices()){
    		for(Integer v2 : testGraphLabelContent.getVertices()){
    			try {
    				testGraphLabelContent.addEdge(v1, v2, "Label" + v1 + v2, "Content" + v1 + v2);
				} catch (InvalidVertexIndexException e) {
					fail("Invalid index for vertex.");
				}
    			expectedEdges.add(new Pair<Integer, Integer>(v1, v2));
    		}
    	}
    	
    	assertEquals(expectedEdges, testGraphLabelContent.getEdges());
    	
    }
    
    /**
     * Test Neighbors
     */
    public void testNeighbors(){
    	testCreate();
    	
    	Set<Integer> expectedVertices = new HashSet<Integer>();
    	for(int i = 0; i < 1000; i++){
    		expectedVertices.add(i);
    		try {
				testGraph.addVertex();
			} catch (MaximumSizeReachedException e) {
				fail("Graph Exception Thrown");
			}
    	}
    	
    	try {
			testGraph.addEdge(1, 2);
			testGraph.addEdge(1, 3);
	    	testGraph.addEdge(1, 4);
	    	testGraph.addEdge(2, 3);
	    	testGraph.addEdge(2, 6);
	    	testGraph.addEdge(4, 2);
	    	testGraph.addEdge(5, 2);
		} catch (InvalidVertexIndexException e) {
			fail("Failed to add edge.");
		}
    	
    	HashSet<Integer> expected = new HashSet<Integer>();
    	expected.add(2);
    	expected.add(3);
    	expected.add(4);
    	try {
			assertEquals(expected, testGraph.getNeighbors(1));
		} catch (InvalidVertexIndexException e) {
			fail("Could not get neighbors.");
		}
    	
    	expected = new HashSet<Integer>();
    	expected.add(3);
    	expected.add(6);
    	try {
			assertEquals(expected, testGraph.getNeighbors(2));
		} catch (InvalidVertexIndexException e) {
			fail("Could not get neighbors.");
		}
    	
    	expected = new HashSet<Integer>();
    	expected.add(2);
    	try {
			assertEquals(expected, testGraph.getNeighbors(5));
		} catch (InvalidVertexIndexException e) {
			fail("Could not get neighbors.");
		}
    	
    	expected = new HashSet<Integer>();
    	expected.add(2);
    	try {
			assertEquals(expected, testGraph.getNeighbors(4));
		} catch (InvalidVertexIndexException e) {
			fail("Could not get neighbors.");
		}
    	
    	expected = new HashSet<Integer>();
    	expected.add(1);
    	expected.add(4);
    	expected.add(5);
    	try {
			assertEquals(expected, testGraph.getInNeighbors(2));
		} catch (InvalidVertexIndexException e) {
			fail("Could not get neighbors.");
		}
    	
    	expected = new HashSet<Integer>();
    	expected.add(1);
    	expected.add(2);
    	try {
			assertEquals(expected, testGraph.getInNeighbors(3));
		} catch (InvalidVertexIndexException e) {
			fail("Could not get neighbors.");
		}
    	
    }
    
    /**
     * Test Strings
     */
    public void testStrings(){
    	testCreate();
    	
    	Set<Integer> expectedVertices = new HashSet<Integer>();
    	for(int i = 0; i < 100; i++){
    		expectedVertices.add(i);
    		try {
				testGraph.addVertex();
			} catch (MaximumSizeReachedException e) {
				fail("Graph Exception Thrown");
			}
    	}
    	
    	Set<Pair<Integer, Integer>> expectedEdges = new HashSet<Pair<Integer, Integer>>();
    	for(Integer v1 : testGraph.getVertices()){
    		for(Integer v2 : testGraph.getVertices()){
    			try {
					testGraph.addEdge(v1, v2);
				} catch (InvalidVertexIndexException e) {
					fail("Invalid index for vertex.");
				}
    			expectedEdges.add(new Pair<Integer, Integer>(v1, v2));
    		}
    	}
    	
    	assertNotNull(testGraph.toAdjacencyString());
    	
    }
    
}