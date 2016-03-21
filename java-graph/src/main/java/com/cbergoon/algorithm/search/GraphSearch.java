package com.cbergoon.algorithm.search;

import java.util.ArrayList;

import com.cbergoon.exception.ImproperGraphBuildException;
import com.cbergoon.graph.Graph;
import com.cbergoon.graph.model.EdgeBase;
import com.cbergoon.graph.model.VertexBase;

/**
 * Base class for all searches on the graph class. Search classes all utilize the 
 * content (decorators) for search. This means the properties of the content base 
 * classes is used to link a node to the graph and define other characteristics. 
 * @author cbergoon
 */
public abstract class GraphSearch<V extends VertexBase, E extends EdgeBase> {
	
	/**
	 * List of nodes visited while searching. 
	 */
	protected ArrayList<V> visited;

	/**
	 * (Optional) Start (entry) point for the graph search.
	 * In case the starting point is not present the root is used.
	 */
	protected V start;
	
	/**
	 * (Optional) Target (terminal) point for the graph search. 
	 * In case the target is not present it is assumed the search
	 * will be used to determine connected nodes and the visited
	 * property can be used to determine all reachable vertices.
	 */
	protected V target;
	
	/**
	 * Reference to the graph to search. 
	 * TODO Add template parameters. 
	 */
	protected Graph<V, E> graph;
	
	/**
	 * Default constructor for graph search class. 
	 * @param g Graph to search on.
	 */
	public GraphSearch(Graph<V, E> g){
		visited = new ArrayList<V>();
		this.graph = g;
		start = null;
		target = null;
	}
	
	/**
	 * Constructor with target for the graph search class.
	 * @param g Graph to search on.
	 * @param target Target of search.
	 */
	public GraphSearch(Graph<V, E> g, V target){
		visited = new ArrayList<V>();
		this.graph = g;
		start = null;
		target = null;
	}
	
	/**
	 * Constructor with target and start for graph search class. 
	 * @param g Graph to search on.
	 * @param start Start point of search. 
	 * @param target Target of search.
	 */
	public GraphSearch(Graph<V, E> g, V start, V target){
		visited = new ArrayList<V>();
		this.graph = g;
		start = null;
		target = null;
	}
	
	/**
	 * Wrapper of specific search implementation. 
	 * @return VertexBase that represents the found vertex. Null if not found. 
	 * @throws ImproperGraphBuildException 
	 */
	public V search() throws ImproperGraphBuildException{
		return searchImplementation();
	}

	/**
	 * Implementation specific version of the search.
	 * @return VertexBase that represents the found vertex. Null if not found. 
	 * @throws ImproperGraphBuildException 
	 */
	public abstract V searchImplementation() throws ImproperGraphBuildException;

	/**
	 * Get the specified start vertex.
	 * @return VertexBase representing the start vertex.
	 */
	public V getStart() {
		return start;
	}

	/**
	 * Set the start vertex. 
	 * @param start The value of the start vertex. 
	 */
	public void setStart(V start) {
		this.start = start;
	}

	/**
	 * Get the specified target vertex. 
	 * @return VertexBase of the target vertex.
	 */
	public VertexBase getTarget() {
		return target;
	}

	/**
	 * Set the target vertex. 
	 * @param target The value of the target vertex.
	 */
	public void setTarget(V target) {
		this.target = target;
	}

	/**
	 * Get visited node list. 
	 * @return List of visited nodes. 
	 */
	public ArrayList<V> getVisited() {
		return visited;
	}

	/**
	 * Set the visited node list.
	 * @param visited List of visited nodes. 
	 */
	public void setVisited(ArrayList<V> visited) {
		this.visited = visited;
	}
	
}
