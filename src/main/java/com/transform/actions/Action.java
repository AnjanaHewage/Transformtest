/**
 * 
 */
package com.transform.actions;

/**
 * The interface all Action classes should implement. The invoke() will
 * contain the actual action to be carried out.
 * 
 * @author Anjana.Hewage
 *
 */
public interface Action {
	
	/** This should implement what happens when the action is invoked*/
	public void invoke();
}
