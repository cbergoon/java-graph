package com.cbergoon.algorithm.search;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import com.cbergoon.exception.ImproperGraphBuildException;
import com.cbergoon.exception.InvalidVertexIndexException;
import com.cbergoon.graph.Graph;
import com.cbergoon.graph.model.EdgeBase;
import com.cbergoon.graph.model.VertexBase;

/**
 * Breadth first search iimplementation for the graph. Search provides
 * an extended functionality set to allow for no target and start-less
 * (no entry point) searches. 
 * @author cbergoon
 *
 * @param <V>
 * @param <E>
 */
public class BFS<V extends VertexBase, E extends EdgeBase> extends GraphSearch<V, E> {
	
	/**
	 * Queue of vertices to be visited in search. 
	 */
	protected Queue<V> toVisitQueue;

	/**
	 * Constructor with graph only. This will set the search up for no target 
	 * with no origin point. 
	 * @param g Graph to search. 
	 */
	public BFS(Graph<V, E> g) {
		super(g);
		toVisitQueue = new LinkedList<V>();
	}
	
	/**
	 * Constructor with graph and target. This will set the search up for a
	 * targeted search with no origin. 
	 * @param g Graph to search.
	 * @param target Target of the search. 
	 */
	public BFS(Graph<V, E> g, V target){
		super(g, target);
		toVisitQueue = new LinkedList<V>();
	}
	
	/**
	 * Constructor with graph, start and, target. This will set the search up
	 * for a targeted search with an origin. 
	 * @param g Graph to search. 
	 * @param start Entry point of the graph. 
	 * @param target Target of the search.
	 */
	public BFS(Graph<V, E> g, V start, V target){
		super(g, start, target);
		toVisitQueue = new LinkedList<V>();
	}
	
	/**
	 * Gets the queue of vertices (not before seen) to visit. 
	 * @return The queue of vertices to visit. 
	 */
	public Queue<V> getQueue() {
		return toVisitQueue;
	}

	/**
	 * Sets the queue of vertices (not before seen) to visit. 
	 * @return The queue of vertices to visit. 
	 */
	public void setQueue(Queue<V> queue) {
		this.toVisitQueue = queue;
	} 

	/**
	 * BFS specific implementation of search. 
	 */
	@Override
	public V searchImplementation() throws ImproperGraphBuildException {
		if(start == null){
			start = graph.getRootVertex();
		}
		toVisitQueue.add(start);
		while(!toVisitQueue.isEmpty()){
			if(!visited.contains(toVisitQueue.peek())){ 
				visited.add(toVisitQueue.peek());
				if(target != null && target.isEqualTo(toVisitQueue.peek(), "")){
					return target;
				}
				try {
					HashSet<Integer> neighbors = graph.getNeighbors(toVisitQueue.poll().getIndex());
					for(Integer i : neighbors){
						toVisitQueue.add(graph.getVertexContent(i));
					}
				} catch (InvalidVertexIndexException e) {
					//TODO Possibly add code to dismiss and ignore the missing node.
					throw new ImproperGraphBuildException("Graph is not built properly; check indexes and links.");
				}
			}else{
				toVisitQueue.poll();
			}
		}
		return null;
	}
	
}
