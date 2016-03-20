package com.cbergoon.algorithms;

import com.cbergoon.graph.Graph;
import com.cbergoon.graph.model.VertexBase;

public class Dijkstra extends GraphSearch {

	public Dijkstra(Graph g) {
		super(g);
	}
	
	public Dijkstra(Graph g, VertexBase target){
		super(g, target);
	}
	
	public Dijkstra(Graph g, VertexBase start, VertexBase target){
		super(g, start, target);
	}

	@Override
	public void searchImplementation() {
		
	}

}
