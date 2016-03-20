package com.cbergoon.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.cbergoon.exceptions.InvalidVertexIndexException;
import com.cbergoon.graph.model.EdgeBase;
import com.cbergoon.graph.model.VertexBase;
import com.cbergoon.utility.Pair;

/**
 * Implementation of adjacency list graph.
 * @param <T> The type that a vertex represents.
 * @param <V> The type that an edge represents.
 */
public class AdjacencyListGraph<V extends VertexBase, E extends EdgeBase> extends Graph<V, E> {

	/**
	 * Graph adjacency list representation.
	 */
	private HashMap<Integer, HashSet<Integer>> adjList;
	
	/**
	 * Constructor for graph class.
	 */
	public AdjacencyListGraph(){
		super();
		this.adjList = new HashMap<Integer, HashSet<Integer>>();
	}
	
	/**
	 * Get all vertices in the graph. 
	 * @return Set of all vertices in the graph. 
	 */
	public Set<Integer> getVerticesImplementation(){
		return adjList.keySet();
	}
	
	/**
	 * Get all edges in the graph. 
	 * @return Set of all edges in the graph. 
	 */
	public Set<Pair<Integer, Integer>> getEdgesImplementation(){
		HashSet<Pair<Integer, Integer>> edges = new HashSet<Pair<Integer, Integer>>(); 
		for(Integer i : getVertices())
			for(Integer j : adjList.get(i))
				edges.add(new Pair<Integer, Integer>(i, j));
		return edges;
	}
	
	/**
	 * Adds a vertex to the graph. Called only by the super class.
	 */
	@Override
	public void addVertexImplementation() {
		Integer vertex = getNumVertices();
		if(!adjList.containsKey(vertex))
			adjList.put(vertex, new HashSet<Integer>());
	}

	/**
	 * Adds an edge to the graph. Called only by the super class. 
	 * @param v1 Integer representing the vertex from which the edge is originating. 
	 * @param v2 Integer representing the vertex from which the edge is terminating.
	 */
	@Override
	public void addEdgeImplementation(int v1, int v2){
		if(!adjList.get(v1).contains(v2))
			adjList.get(v1).add(v2);
	}

	/**
	 * Gets a set of all of the first degree neighbors of a specified vertex. 
	 * @param v The vertex to find neighbors of.
	 * @return The set of all vertices that are neighbors to the specified vertex.
	 * @throws InvalidVertexIndexException
	 */
	@Override
	public HashSet<Integer> getNeighbors(int v) throws InvalidVertexIndexException {
		if(!adjList.containsKey(v))
			throw new InvalidVertexIndexException("No vertex found for index.");
		return adjList.get(v);
	}

	/**
	 * Gets a list of all the in-neighbors. This means the neighbors that can 
	 * reach the specified vertex by following a single edge.
	 * @param v The vertex to find in-neighbors of.
	 * @return The set of in-neighbors.
	 * @throws InvalidVertexIndexException
	 */
	@Override
	public HashSet<Integer> getInNeighbors(int v) throws InvalidVertexIndexException {
		if(!adjList.containsKey(v))
			throw new InvalidVertexIndexException("No vertex found for index");
		HashSet<Integer> ins = new HashSet<Integer>();
		for(Integer i : adjList.keySet())
			for(Integer j : adjList.get(i))
				if(j.equals(v))
					ins.add(i);
		return ins;
	}

	/**
	 * Gets a set of all second degree (2-hop) vertices. Reachable from the specified 
	 * vertex.
	 * @param v The vertex from which the search should begin.
	 * @return A set of integers that are 2 degree connections to the specified vertex.
	 * @throws InvalidVertexIndexException
	 */
	@Override
	public HashSet<Integer> getSecondDegree(int v) throws InvalidVertexIndexException {
		if(!adjList.containsKey(v))
			throw new InvalidVertexIndexException("No vertex found for index");
		HashSet<Integer> secdeg = new HashSet<Integer>();
		HashSet<Integer> firstdeg = getNeighbors(v);
		for(Integer i : firstdeg)
			secdeg.addAll(getNeighbors(i));
		return secdeg;
	}
	
	/**
	 * Gets the adjacency list represented as a string.
	 * @return The string representation of the graph. 
	 */
	@Override
	public String toAdjacencyString() {
		String res = "";
		for(Integer k : adjList.keySet()){
			res += k + ": ";
			for(Integer i : adjList.get(k)){
				res += i + ", ";
			}
			res += "\n";
		}
		return res;
	}

}
