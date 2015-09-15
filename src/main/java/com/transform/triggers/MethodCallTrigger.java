/**
 * 
 */
package com.transform.triggers;

import org.apache.log4j.Logger;

import com.transform.actions.ActionFactory;
import com.transform.actions.CallObjectAction;
import com.transforrm.exception.TransformException;

/**
 * The trigger called by an object to say something has happened.
 * 
 * 
 * @author Anjana.Hewage
 *
 */
public class MethodCallTrigger implements Trigger {

	/** The event reported by the external object*/
	private String event; 
	
	/** Logging context. */
	static Logger log = Logger.getLogger(MethodCallTrigger.class);
	
	/**
	 * Constructor with the event as the parameter
	 * 
	 * @param event a code or the description of the event
	 */
	public MethodCallTrigger(String event) {
		this.event = event;
	}
	
	/* (non-Javadoc)
	 * @see com.transform.triggers.Trigger#callAction()
	 */
	@Override
	public void callAction() {
				
		try {
			//Use the ActionFactory to create get an instance of the Action to perform.
			CallObjectAction callObjectAction = (CallObjectAction)ActionFactory.getActionInstnce("com.transform.actions.CallObjectAction");
		
			//invoke the action
			callObjectAction.invoke();	
		} catch (TransformException te) {
			log.error("Error calling "+CallObjectAction.class.getName(), te);
		}

	}

}
