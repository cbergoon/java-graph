package com.cbergoon.exceptions;

/**
 * Exception to handle invalid edges.
 * @author cbergoon
 */
public class InvalidEdgeException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidEdgeException(String message){
        super(message);
    }
	
	public InvalidEdgeException(String message, Throwable t){
        super(message, t);
    }
	
}
