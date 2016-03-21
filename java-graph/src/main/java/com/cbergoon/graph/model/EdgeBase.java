package com.cbergoon.graph.model;

import com.cbergoon.utility.Pair;

/**
 * Edge decorator class to be linked to each edge by index. Intended 
 * to be extended. 
 * @author cbergoon
 * TODO Override implementation of equals.
 */
public class EdgeBase {
	
	/**
	 * Index of the decorator. 
	 */
	private int index;
	
	/**
	 * Connection the decorator represents.
	 */
	private Pair<Integer, Integer> connection;
	
	/**
	 * Gets the index of the decorator. 
	 * @return The index of the decorator.
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * Sets the index of the decorator.
	 * @param index Index of the decorator.
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * Gets the connection of the decorator. 
	 * @return The connection of the decorator.
	 */
	public Pair<Integer, Integer> getConnection() {
		return connection;
	}
	
	/**
	 * Sets the connection of the decorator.
	 * @param connection The connection of the decorator. 
	 */
	public void setConnection(Pair<Integer, Integer> connection) {
		this.connection = connection;
	}
	
}
