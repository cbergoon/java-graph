package com.cbergoon.algorithms;

import com.cbergoon.graph.Graph;
import com.cbergoon.graph.model.VertexBase;

public class BFS extends GraphSearch {

	public BFS(Graph g) {
		super(g);
	}
	
	public BFS(Graph g, VertexBase target){
		super(g, target);
	}
	
	public BFS(Graph g, VertexBase start, VertexBase target){
		super(g, start, target);
	}

	@Override
	public void searchImplementation() {
		
	}
	
}
