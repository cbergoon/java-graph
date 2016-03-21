package com.cbergoon.algorithm.search;

import com.cbergoon.graph.Graph;
import com.cbergoon.graph.model.EdgeBase;
import com.cbergoon.graph.model.VertexBase;

public class DFS<V extends VertexBase, E extends EdgeBase> extends GraphSearch<V, E> {

	public DFS(Graph<V, E> g) {
		super(g);
	}
	
	public DFS(Graph<V, E> g, V target){
		super(g, target);
	}
	
	public DFS(Graph<V, E> g, V start, V target){
		super(g, start, target);
	}

	@Override
	public V searchImplementation() {
		return null;
	}
	
}
