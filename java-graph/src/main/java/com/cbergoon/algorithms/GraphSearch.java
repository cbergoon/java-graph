package com.cbergoon.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.cbergoon.graph.Graph;
import com.cbergoon.graph.model.VertexBase;

public abstract class GraphSearch {
	
	protected ArrayList<Integer> visited;
	protected Queue<VertexBase> queue;

	protected VertexBase start;
	protected VertexBase target;
	
	//TODO Add template parameters.
	protected Graph graph;
	
	public GraphSearch(Graph g){
		visited = new ArrayList<Integer>();
		queue = new LinkedList<VertexBase>();
		this.graph = g;
	}
	
	public GraphSearch(Graph g, VertexBase target){
		visited = new ArrayList<Integer>();
		queue = new LinkedList<VertexBase>();
		this.graph = g;
	}
	
	public GraphSearch(Graph g, VertexBase start, VertexBase target){
		visited = new ArrayList<Integer>();
		queue = new LinkedList<VertexBase>();
		this.graph = g;
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

	public ArrayList<Integer> getVisited() {
		return visited;
	}

	public void setVisited(ArrayList<Integer> visited) {
		this.visited = visited;
	}

	public Queue<VertexBase> getQueue() {
		return queue;
	}

	public void setQueue(Queue<VertexBase> queue) {
		this.queue = queue;
	} 
	
}
