package com.cbergoon.exceptions;

/**
 * Exception to handle invalid vertex indexes.
 * @author cbergoon
 */
public class InvalidVertexIndexException extends Exception {

	private static final long serialVersionUID = 1L;

	public InvalidVertexIndexException(String message){
        super(message);
    }
	
	public InvalidVertexIndexException(String message, Throwable t){
        super(message, t);
    }
	
}
