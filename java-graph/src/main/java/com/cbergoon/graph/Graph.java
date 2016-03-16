package com.cbergoon.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import com.cbergoon.exceptions.InvalidVertexIndexException;
import com.cbergoon.exceptions.MaximumSizeReachedException;
import com.cbergoon.utility.Pair;

/**
 * Abstract implementation of a graph class.
 * @author cbergoon
 * @param <V> Class that a vertex will represent
 * @param <E> Class that an edge will represent
 */
public abstract class Graph<V, E> {

	/**
	 * Represents the number of vertices in the graph.
	 */
	private int numVertices;
	
	/**
	 * Represents the number of edges in the graph. 
	 */
	private int numEdges;
	
	/**
	 * Map that relates the vertices to an object of type T.
	 */
	private Map<Integer, V> vertexContent;
	
	/**
	 * Map that relates the vertices to their labels. 
	 */
	private Map<Integer, String> vertexLabel;
	
	/**
	 * Map that relates the edge to an object of type T.
	 */
	private Map<Pair<Integer, Integer>, E> edgeContent;
	
	/**
	 * Map that relates the edge to their labels. 
	 */
	private Map<Pair<Integer, Integer>, String> edgeLabel;
	
	
	/**
	 * Default constructor for the graph class.
	 */
	public Graph(){
		numVertices = 0;
		numEdges = 0;
		vertexContent = new HashMap<Integer, V>();
		vertexLabel = new HashMap<Integer, String>();
		edgeContent = new HashMap<Pair<Integer, Integer>, E>();
		edgeLabel = new HashMap<Pair<Integer, Integer>, String>();
	}
	
	/**
	 * Get the number of vertices in the graph.
	 * @return Number of vertices in the graph.
	 */
	public int getNumVertices(){
		return numVertices;
	}
	
	/**
	 * Get the number of edges in the graph.
	 * @return Number of edges in the graph.
	 */
	public int getNumEdges(){
		return numEdges;
	}
	
	/**
	 * Adds a vertex to the graph. Calls the implementation specific version
	 * of the add vertex function. 
	 * @return The index representing the new vertex.
	 * @throws MaximumSizeReachedException
	 */
	public int addVertex() throws MaximumSizeReachedException {
		return addVertexFunctionality(null, null);
	}
	
	/**
	 * Adds a vertex to the graph. Calls the implementation specific version
	 * of the add vertex function. 
	 * @param label The label to be added to the vertex.
	 * @param content The content that is represented by the vertex.
	 * @return The index representing the new vertex.
	 * @throws MaximumSizeReachedException
	 */
	public int addVertex(String label, V content) throws MaximumSizeReachedException {
		return addVertexFunctionality(label, content);
	}
	
	/**
	 * Adds a vertex to the graph. Calls the implementation specific version
	 * of the add vertex function. Adds the content to the vertex.
	 * @param content The content the vertex represents. 
	 * @return The index representing the new vertex.
	 * @throws MaximumSizeReachedException
	 */
	private int addVertexFunctionality(String label, V content) throws MaximumSizeReachedException{
		if(numVertices >= Integer.MAX_VALUE)
			throw new MaximumSizeReachedException("Maximum number of vertices reached. Number of vertices cannot exceed the maximum size");
		addVertexImplementation();
		numVertices += 1;
		if(label != null)
			vertexLabel.put(numVertices - 1, label);
		if(content != null)
			vertexContent.put((numVertices - 1), content);
		return numVertices - 1;
	}
	
	/**
	 * Adds an edge to the graph calls the implementation specific version
	 * of the add edge function.
	 * @param v1 Vertex from which the edge is originating. 
	 * @param v2 Vertex from which the edge is terminating.
	 * @throws InvalidVertexIndexException
	 */
	public void addEdge(int v1, int v2) throws InvalidVertexIndexException {
		addEdgeFunctionality(v1, v2, null, null);
	}
	
	/**
	 * Adds an edge to the graph calls the implementation specific version
	 * of the add edge function.
	 * @param v1 Vertex from which the edge is originating. 
	 * @param v2 Vertex from which the edge is terminating.
	 * @param label Label to associate to the edge.
	 * @param content Content to associate to the edge.
	 * @throws InvalidVertexIndexException
	 */
	public void addEdge(int v1, int v2, String label, E content) throws InvalidVertexIndexException {
		addEdgeFunctionality(v1, v2, label, content);
	}
	
	/**
	 * Adds an edge to the graph. Calls the implementation specific version 
	 * of the add edge function. 
	 * @param v1 Vertex from which the edge is originating. 
	 * @param v2 Vertex from which the edge is terminating.
	 * @param label Label to associate to the edge.
	 * @param content Content to associate to the edge.
	 * @throws InvalidVertexIndexException
	 */
	private void addEdgeFunctionality(int v1, int v2, String label, E content) throws InvalidVertexIndexException{
		if(v1 < 0 || v2 < 0)
			throw new InvalidVertexIndexException("Vertex index cannot be less than zero");
		if(v1 >= numVertices || v2 >= numVertices)
			throw new InvalidVertexIndexException("Vertex index cannot be greater than the number of vertices in the graph");
		if(label != null)
			edgeLabel.put(new Pair<Integer, Integer>(v1, v2), label);
		if(content != null)
			edgeContent.put(new Pair<Integer, Integer>(v1, v2), content);
		addEdgeImplementation(v1, v2);
	}
	
	/**
	 * Implementation specific add vertex function. Adds the vertex to
	 * the data structure that represents the graph. 
	 */
	public abstract void addVertexImplementation();
	
	/**
	 * Implementation specific add edge function. Adds the edge to
	 * the data structure that represents the graph.
	 * @param v1 Vertex from which the edge is originating.  
	 * @param v2 Vertex from which the edge is terminating.
	 * @throws InvalidVertexIndexException 
	 */
	public abstract void addEdgeImplementation(int v1, int v2) throws InvalidVertexIndexException;
	
	/**
	 * Gets a list of (out-)neighbors (adjacent vertices) to the specified vertex.
	 * Adjacent vertices are those vertices that can be reached by a single 
	 * outgoing edge. 
	 * @param v The vertex to find neighbors.
	 * @return The list of integers that represent the neighbors.
	 * @throws InvalidVertexIndexException 
	 */
	public abstract HashSet<Integer> getNeighbors(int v) throws InvalidVertexIndexException;
	
	/**
	 * Gets a list of in-neighbors (adjacent vertices) to the specified vertex.
	 * Adjacent vertices are those vertices that can be reached by a single
	 * incoming edge. Vertices that can reach the specified vertex. 
	 * @param v The vertex to find the in-neighbors of. 
	 * @return The list of integers that represent the neighbors. 
	 * @throws InvalidVertexIndexException 
	 */
	public abstract HashSet<Integer> getInNeighbors(int v) throws InvalidVertexIndexException;
	
	/**
	 * Gets a list of vertices that are a distance of two edges from the specified 
	 * vertex. 
	 * @param v The specified vertex to start from. 
	 * @return The list of vertices that are 2 degrees from the specified vertex.
	 * @throws InvalidVertexIndexException 
	 */
	public abstract HashSet<Integer> getSecondDegree(int v) throws InvalidVertexIndexException;
	
	/**
	 * Generates a string that represents the adjacency list of the graph. 
	 * @return The string representation of the graph. 
	 */
	public abstract String toAdjacencyString();
	
	/**
	 * Adds the content to the specified vertex. Replaces the content
	 * if it already exists for the vertex v.
	 * @param v The index of the vertex represented.
	 * @param content The content the vertex represents. 
	 */
	public void addVertexContent(int v, V content){
		vertexContent.put(v, content);
	}
	
	/**
	 * Gets the content of the vertex at a given index. 
	 * @param v The index of the vertex to retrieve content for. 
	 * @return The content represented by the vertex. Returns null if not found.
	 */
	public V getVertexContent(int v){
		if(vertexContent.containsKey(v)){
			return vertexContent.get(v);
		}else{
			return null;
		}
	}
	
	/**
	 * Adds the label to the specified edge. Replaces the content 
	 * if it already exists for the edge e.
	 * @param e The index of the edge represented.
	 * @param content The content the edge represents.
	 */
	public void addEdgeContent(Pair<Integer, Integer> e, E content){
		edgeContent.put(e, content);
	}
	
	/**
	 * Gets the content of the edge at a given index.
	 * @param e The index of the edge to retrieve content for.
	 * @return The content represented by the edge. Returns null if not found.
	 */
	public E getEdgeContent(Pair<Integer, Integer> e){
		if(edgeContent.containsKey(e)){
			return edgeContent.get(e);
		}else{
			return null;
		}
	}
	
	/**
	 * Adds the label to the specified vertex. Replaces the label 
	 * if it already exists for the vertex v.
	 * @param v The index of the vertex represented.
	 * @param label The label the vertex represents.
	 */
	public void addVertexLabel(int v, String label){
		vertexLabel.put(v, label);
	}
	
	/**
	 * Gets the label of the vertex at a given index.
	 * @param v The index of the vertex to retrieve label for.
	 * @return The label represented by the vertex. Returns null if not found.
	 */
	public String getVertexLabel(int v){
		if(vertexLabel.containsKey(v)){
			return vertexLabel.get(v);
		}else{
			return null;
		}
	}
	
	/**
	 * Adds the label to the specified edge. Replaces the label 
	 * if it already exists for the edge e.
	 * @param e The index of the edge represented.
	 * @param label The label the edge represents.
	 */
	public void addEdgeLabel(Pair<Integer, Integer> e, String label){
		edgeLabel.put(e, label);
	}
	
	/**
	 * Gets the label of the edge at a given index.
	 * @param e The index of the edge to retrieve label for.
	 * @return The label represented by the edge. Returns null if not found.
	 * @throws InvalidVertexIndexException
	 */
	public String getEdgeLabel(Pair<Integer, Integer> e){
		if(edgeLabel.containsKey(e)){
			return edgeLabel.get(e);
		}else{
			return null;
		}
	}
	
	/**
	 * String representation of the object.
	 * @return The string representation of the object. 
	 */
	public String toString(){
		return "";
	}
	
}
