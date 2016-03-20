package com.cbergoon.graph.model;

import com.cbergoon.utility.Pair;

/**
 * 
 * @author cbergoon
 */
public class EdgeBase {
	
	/**
	 * 
	 */
	private int index;
	
	/**
	 * 
	 */
	private Pair<Integer, Integer> connection;
	
	/**
	 * 
	 * @return
	 */
	public int getIndex() {
		return index;
	}
	
	/**
	 * 
	 * @param index
	 */
	public void setIndex(int index) {
		this.index = index;
	}
	
	/**
	 * 
	 * @return
	 */
	public Pair<Integer, Integer> getConnection() {
		return connection;
	}
	
	/**
	 * 
	 * @param connection
	 */
	public void setConnection(Pair<Integer, Integer> connection) {
		this.connection = connection;
	}
	
}
