package com.cbergoon.graph.model;

/**
 * Vertex decorator class to be linked to each vertex by index. Intended 
 * to be extended. 
 * @author cbergoon
 * TODO Override implementation of equals.
 */
public class VertexBase {

	/**
	 * Index of the decorator. 
	 */
	private int index;

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
	
}
