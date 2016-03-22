package com.cbergoon.algorithm.verify;

/**
 * Class providing capability to verify that graph is valid. 
 * @author cbergoon
 */
public class GraphVerification {

	/**
	 * Status codes for verify.
	 */
	public final int OKAY = 0; /* Verification found no errors. */
	public final int BROKEN_CONNECTION = 0; /* One or more connections are broken.  */
	public final int VERTEX_MISSING_CONTENT = 0; /* Vertex is missing content. */
	public final int VERTEX_MISSING_LABEL = 0; /* Vertex is missing label. */
	public final int EDGE_MISSING_CONTENT = 0; /* Edge is missing content. */
	public final int EDGE_MISSING_LABEL = 0; /* Edge is missing label. */
	
	/**
	 * Verifies graph is valid. (i.e. proper connections, 
	 * content and labels exist, etc.)
	 * @return 0 if okay, appropriate code defined below 
	 * otherwise. 
	 */
	public int verifyGraph(){
		return 0;
	}
	
}
