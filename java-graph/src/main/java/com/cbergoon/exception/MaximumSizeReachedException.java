package com.cbergoon.exception;

/**
 * Exception to handle max size reached.
 * @author cbergoon
 */
public class MaximumSizeReachedException extends Exception {

	private static final long serialVersionUID = 1L;

	public MaximumSizeReachedException(String message){
        super(message);
    }
	
	public MaximumSizeReachedException(String message, Throwable t){
        super(message, t);
    }
	
}
