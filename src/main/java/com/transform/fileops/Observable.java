/**
 * 
 */
package com.transform.fileops;

/**
 * The interface to be implemented by events to be watched
 * 
 * @author Anjana.Hewage
 *
 */
public interface Observable {

	public void addObserver(Observer o);
	
	public void notifyObververs();
	
}
