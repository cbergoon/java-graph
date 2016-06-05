package com.cbergoon.algorithm.search;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

import com.cbergoon.exception.ImproperGraphBuildException;
import com.cbergoon.exception.InvalidVertexIndexException;
import com.cbergoon.graph.Graph;
import com.cbergoon.graph.model.EdgeBase;
import com.cbergoon.graph.model.VertexBase;

/**
 * Depth first search implementation for the graph. Search provides
 * an extended functionality set to allow for no target and start-less
 * (no entry point) searches. 
 * @author cbergoon
 *
 * @param <V>
 * @param <E>
 */
public class DFS<V extends VertexBase, E extends EdgeBase> extends GraphSearch<V, E> {

	/**
	 * Queue of vertices to be visited in search. 
	 */
	private Stack<V> toVisit;
	
	/**
	 * Constructor with graph only. This will set the search up for no target 
	 * with no origin point. 
	 * @param g Graph to search. 
	 */
	public DFS(Graph<V, E> g) {
		super(g);
		toVisit = new Stack<V>();
	}
	
	/**
	 * Constructor with graph and target. This will set the search up for a
	 * targeted search with no origin. 
	 * @param g Graph to search.
	 * @param target Target of the search. 
	 */
	public DFS(Graph<V, E> g, V target){
		super(g, target);
		toVisit = new Stack<V>();
	}
	
	/**
	 * Constructor with graph, start and, target. This will set the search up
	 * for a targeted search with an origin. 
	 * @param g Graph to search. 
	 * @param start Entry point of the graph. 
	 * @param target Target of the search.
	 */
	public DFS(Graph<V, E> g, V start, V target){
		super(g, start, target);
		toVisit = new Stack<V>();
	}
	
	/**
	 * Gets the queue of vertices (not before seen) to visit. 
	 * @return The queue of vertices to visit. 
	 */
	public Stack<V> getToVisit() {
		return toVisit;
	}

	/**
	 * Sets the queue of vertices (not before seen) to visit. 
	 * @return The queue of vertices to visit. 
	 */
	public void setToVisit(Stack<V> toVisit) {
		this.toVisit = toVisit;
	}

	/**
	 * DFS specific implementation of search. 
	 */
	@Override
	public V searchImplementation() throws ImproperGraphBuildException {
		if(start == null){
			start = graph.getRootVertex();
		}
		Set<V> seen = new HashSet<V>();
		toVisit.add(start);
		while(!toVisit.isEmpty()){
			V v = toVisit.pop();
			if(!seen.contains(v)){
				seen.add(v);
				try {
					for(Integer w : graph.getNeighbors(v.getIndex())){
						if(target != null && target.isEqualTo(graph.getVertexContent(w), "")){
							return target;
						}
						toVisit.push(graph.getVertexContent(w));
					}
				} catch (InvalidVertexIndexException e) {
					throw new ImproperGraphBuildException("Graph is not built properly; check indexes and links.");
				}
			}
		}
		return null;
	}
	
}