package com.cbergoon.algorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

import com.cbergoon.exceptions.ImproperGraphBuildException;
import com.cbergoon.exceptions.InvalidVertexIndexException;
import com.cbergoon.graph.Graph;
import com.cbergoon.graph.model.EdgeBase;
import com.cbergoon.graph.model.VertexBase;

public class BFS<V extends VertexBase, E extends EdgeBase> extends GraphSearch<V, E> {
	
	protected Queue<V> toVisitQueue;

	public BFS(Graph<V, E> g) {
		super(g);
		toVisitQueue = new LinkedList<V>();
	}
	
	public BFS(Graph<V, E> g, V target){
		super(g, target);
		toVisitQueue = new LinkedList<V>();
	}
	
	public BFS(Graph<V, E> g, V start, V target){
		super(g, start, target);
		toVisitQueue = new LinkedList<V>();
	}
	
	public Queue<V> getQueue() {
		return toVisitQueue;
	}

	public void setQueue(Queue<V> queue) {
		this.toVisitQueue = queue;
	} 

	@Override
	public V searchImplementation() throws ImproperGraphBuildException {
		if(start == null){
			start = graph.getRootVertex();
		}
		toVisitQueue.add(start);
		while(!toVisitQueue.isEmpty()){
			if(!visited.contains(toVisitQueue.peek())){ 
				visited.add(toVisitQueue.peek());
				if(target != null && target.equals(toVisitQueue.peek())){
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
