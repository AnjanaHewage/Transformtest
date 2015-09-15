/**
 * 
 */
package com.transform.actions;

import org.apache.log4j.Logger;

import com.transform.triggers.Trigger;

/**
 * @author Anjana.Hewage
 *
 */
public class LogTriggerAction implements Action {

	private Trigger trigger;
	
	/** Logging context. */
	static Logger log = Logger.getLogger(LogTriggerAction.class);

	/** 
	 * Log the name of the trigger that was fired and possibly 
	 * send out an email to sysadmins
	 * @see com.transform.actions.Action#invoke()
	 */
	@Override
	public void invoke() {
		//Call a method to log which trigger was fired
		log.warn(trigger.getClass().getName() + " has been fired!");
				
		
		//@TODO:Send an email to the admins	etc
	}
	
}
