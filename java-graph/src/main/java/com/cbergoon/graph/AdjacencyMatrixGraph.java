package com.cbergoon.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import com.cbergoon.exceptions.InvalidVertexIndexException;
import com.cbergoon.utility.Pair;

/**
 * Adjacency matrix graph implementation. 
 * @author cbergoon
 * @param <T> The type that a vertex represents.
 * @param <V> The type that an edge represents.
 */
public class AdjacencyMatrixGraph<V, E> extends Graph<V, E> {
	
	/**
	 * Adjacency matrix data structure.
	 */
	private int[][] adjMatrix;
	
	/**
	 * Default constructor for the adjacency matrix class. 
	 */
	public AdjacencyMatrixGraph(){
		super();
		initAdjMatrix(50);
	}
	
	/**
	 * Constructor with size argument for initial size of the matrix.
	 * @param size Size of the adjacency matrix. 
	 */
	public AdjacencyMatrixGraph(int size){
		super();
		initAdjMatrix(size);
	}
	
	/**
	 * Initializes the adjacency matrix with all elements of value
	 * 0. The size of the matrix will be equal on both sides as 
	 * required by the graph. 
	 * @param size The size of the array; both sides. 
	 */
	private void initAdjMatrix(int size){
		adjMatrix = new int[size][size];
	}
	
	/**
	 * Increases the size of the adjacency matrix structure.
	 * @param size Size of the new matrix;
	 */
	private void increaseAdjMatrixSize(int size){
		int[][] newAdjMatrix = new int[size][size];
		for(int i = 0; i < adjMatrix.length; i++){
			for(int j = 0; j < adjMatrix[i].length; j++){
				newAdjMatrix[i][j] = adjMatrix[i][j];
			}	
		}
		adjMatrix = newAdjMatrix;
	}
	
	@Override
	public Set<Integer> getVerticesImplementation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Set<Pair<Integer, Integer>> getEdgesImplementation() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void addVertexImplementation() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEdgeImplementation(int v1, int v2) throws InvalidVertexIndexException {
		// TODO Auto-generated method stub

	}

	@Override
	public HashSet<Integer> getNeighbors(int v) throws InvalidVertexIndexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashSet<Integer> getInNeighbors(int v) throws InvalidVertexIndexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashSet<Integer> getSecondDegree(int v) throws InvalidVertexIndexException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toAdjacencyString() {
		// TODO Auto-generated method stub
		return null;
	}

}
