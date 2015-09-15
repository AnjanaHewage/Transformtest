/**
 * 
 */
package com.transform.triggers;

import org.apache.log4j.Logger;

import com.transform.actions.ActionFactory;
import com.transform.actions.LogTriggerAction;
import com.transform.fileops.Observer;
import com.transforrm.exception.TransformException;

/**
 * The trigger that reacts to a keyword found in a log file. This can be used
 * to monitor the log file for different keywords
 * i.e To monitor for the word 'danger' instantiate 
 * 		LogListenerTrigger logListenerTrigger = new LogListenerTrigger("danger"); 
 * 
 * 
 * @author Anjana.Hewage
 *
 */
public class LogListenerTrigger implements Trigger,Observer {

	/** The keyword this trigger is watching for */
	private String keyWord;
	

	/** Logging context. */
	static Logger log = Logger.getLogger(LogListenerTrigger.class);

	/**
	 * Constructor
	 * 
	 * @param keyWord
	 */
	public LogListenerTrigger(String keyWord) {
		this.keyWord = keyWord;
	}
		
	/**
	 * Returns the keyword to look for
	 * 
	 * @return
	 */
	public String getKeyWord() {
		return keyWord;
	}
	
	/**
	 * The implementation of the overridden callAction() 
	 * 
	 */
	@Override
	public void callAction() {		
		try {
			//Use the ActionFactory to create get an instance of the Action to perform.
			LogTriggerAction logAction = (LogTriggerAction)ActionFactory.getActionInstnce("com.transform.actions.LogTriggerAction");
			
			//invoke the action
			logAction.invoke();	
		} catch (TransformException te){
			log.error("Error calling action "+LogTriggerAction.class.getName(),te);
		}
	
	}

	/**
	 * Over-ridden method from the Observer interface
	 */
	@Override
	public void update() {
		//The word detected fire the trigger method
		callAction();
		
	}
	
	
	
}
