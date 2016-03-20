package com.cbergoon.algorithms;

import com.cbergoon.graph.Graph;
import com.cbergoon.graph.model.VertexBase;

public class DFS extends GraphSearch {

	public DFS(Graph g) {
		super(g);
	}
	
	public DFS(Graph g, VertexBase target){
		super(g, target);
	}
	
	public DFS(Graph g, VertexBase start, VertexBase target){
		super(g, start, target);
	}

	@Override
	public void searchImplementation() {
		
	}
	
}
