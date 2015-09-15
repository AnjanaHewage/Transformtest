/**
 * 
 */
package com.transforrm.exception;

/**
 * Custom exception class to be thrown around the application.
 * 
 * @author Anjana.Hewage
 *
 */
/**
 * @author Anjana.Hewage
 *
 */
public class TransformException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * The original/root exception raised in the application
	 */
	private Exception rootException;
	
	/**
	 * Custom error message
	 */
	private String customMessage;
			
	
	/**
	 * 
	 * 
	 * @param rootException the original exception
	 * @param customMessage custom error message
	 */
	public TransformException(Exception rootException, String customMessage) {
		this.rootException = rootException;
		this.customMessage = customMessage;
	}

	/**
	 * @param customMessage custom error message
	 */
	public TransformException(String customMessage) {
		this.customMessage = customMessage;
	}

	/**
	 * @param rootException the original exception
	 */
	public TransformException(Exception rootException) {
		this.rootException = rootException;
	}

	
	
	/**
	 * @return returns the original exception
	 */
	public Exception getRootException() {
		return rootException;
	}

	/**
	 * @param the original exception
 	 */
	public void setRootException(Exception rootException) {
		this.rootException = rootException;
	}

	/**
	 * @return returns the custom error message
	 */
	public String getCustomMessage() {
		return customMessage;
	}

	/**
	 * @return sets the custom error message
	 */
	public void setCustomMessage(String customMessage) {
		this.customMessage = customMessage;
	}
	
		
}
