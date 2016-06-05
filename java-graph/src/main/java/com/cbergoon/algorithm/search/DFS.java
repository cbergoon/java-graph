package com.cbergoon.algorithm.search;

import java.util.Stack;

import com.cbergoon.graph.Graph;
import com.cbergoon.graph.model.EdgeBase;
import com.cbergoon.graph.model.VertexBase;

public class DFS<V extends VertexBase, E extends EdgeBase> extends GraphSearch<V, E> {

	private Stack<V> s;
	
	public DFS(Graph<V, E> g) {
		super(g);
		s = new Stack<V>();
	}
	
	public DFS(Graph<V, E> g, V target){
		super(g, target);
		s = new Stack<V>();
	}
	
	public DFS(Graph<V, E> g, V start, V target){
		super(g, start, target);
		s = new Stack<V>();
	}

	@Override
	public V searchImplementation() {
		return null;
	}
	
}

//1  procedure DFS-iterative(G,v):
//2      let S be a stack
//3      S.push(v)
//4      while S is not empty
//5            v = S.pop()
//6            if v is not labeled as discovered:
//7                label v as discovered
//8                for all edges from v to w in G.adjacentEdges(v) do
//9                    S.push(w)