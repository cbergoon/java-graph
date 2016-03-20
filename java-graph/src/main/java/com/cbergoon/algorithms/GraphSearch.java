package com.cbergoon.algorithms;

import java.util.Queue;

import com.cbergoon.graph.model.VertexBase;

public abstract class GraphSearch {
	
	private Queue<VertexBase> queue;

	private VertexBase start;
	private VertexBase target;
	
	public GraphSearch(){
		
	}
	
	public GraphSearch(VertexBase target){
		
	}
	
	public GraphSearch(VertexBase start, VertexBase target){
		
	}
	
	public void search(){
		searchImplementation();
	}

	public abstract void searchImplementation();

	public VertexBase getStart() {
		return start;
	}

	public void setStart(VertexBase start) {
		this.start = start;
	}

	public VertexBase getTarget() {
		return target;
	}

	public void setTarget(VertexBase target) {
		this.target = target;
	} 
	
}
