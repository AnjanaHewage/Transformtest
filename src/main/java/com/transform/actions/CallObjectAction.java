/**
 * 
 */
package com.transform.actions;

import org.apache.log4j.Logger;

/**
 * @author Anjana.Hewage
 *
 */
public class CallObjectAction implements Action {

	/** Logging context. */
	static Logger log = Logger.getLogger(CallObjectAction.class);
	
	/* (non-Javadoc)
	 * @see com.transform.actions.Action#invoke()
	 */
	@Override
	public void invoke() {
		//Call the method of a new object
		VeryImportantObject veryImportantObject = new VeryImportantObject();
		
		veryImportantObject.veryImportantMethod();

	}

}
