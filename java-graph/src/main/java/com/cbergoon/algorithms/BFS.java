package com.cbergoon.algorithms;

import java.util.LinkedList;
import java.util.Queue;

import com.cbergoon.graph.Graph;
import com.cbergoon.graph.model.EdgeBase;
import com.cbergoon.graph.model.VertexBase;

public class BFS<V extends VertexBase, E extends EdgeBase> extends GraphSearch<V, E> {
	
	protected Queue<V> queue;

	public BFS(Graph<V, E> g) {
		super(g);
		queue = new LinkedList<V>();
	}
	
	public BFS(Graph<V, E> g, V target){
		super(g, target);
		queue = new LinkedList<V>();
	}
	
	public BFS(Graph<V, E> g, V start, V target){
		super(g, start, target);
		queue = new LinkedList<V>();
	}
	
	public Queue<V> getQueue() {
		return queue;
	}

	public void setQueue(Queue<V> queue) {
		this.queue = queue;
	} 

	@Override
	public V searchImplementation() {
		return null;
	}
	
}
