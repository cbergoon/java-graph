package com.cbergoon.exceptions;

/**
 * Exception to handle errors in structure of graph.
 * @author cbergoon
 */
public class ImproperGraphBuildException extends Exception {

	private static final long serialVersionUID = 1L;

	public ImproperGraphBuildException(String message){
        super(message);
    }
	
	public ImproperGraphBuildException(String message, Throwable t){
        super(message, t);
    }
	
}
