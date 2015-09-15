/**
 * 
 */
package com.transform.fileops;

import org.apache.log4j.Logger;

import com.transform.triggers.LogListenerTrigger;

/**
 * The thread that monitors the log file for the phrase required. 
 * 
 * @author Anjana.Hewage
 *
 */
public class FileObserver implements Observable, Runnable{

	/** the observer */
	private LogListenerTrigger logListenerTrigger;
	
	
	/** true when the phrase is found in the log file*/
	private boolean pharseFound;
	
	
	/** Logging context. */
	static Logger log = Logger.getLogger(FileObserver.class);
		
	/**
	 * 
	 * @return true if the phrase has been found in the log file
	 */
	public boolean isPharseFound() {
		return pharseFound;
	}

	/**
	 * 
	 * @param pharseFound
	 */
	public void setPharseFound(boolean pharseFound) {
		this.pharseFound = pharseFound;
		
		//Let the concerned parties know
		notifyObververs();
	}

	/**
	 * Add an observer to this object
	 * 
	 * @param the observer 
	 */
	@Override
	public void addObserver(Observer o) {
		this.logListenerTrigger = (LogListenerTrigger) o;

	}

	/**
	 * Notify all the observers about what happened
	 */
	@Override
	public void notifyObververs() {
		//notify the observer
		log.debug("Letting the trigger know...");
		logListenerTrigger.update();

	}
	
	/**
	 * The method that does the hard work of watching the log file
	 */
	public void watchFile(){
		/**
		 * Do the work of monitoring the file and when phrase pops up
		 * call the method
		 * 
		 * @TODO All the file monitor code goes here
		 */
		
		
		log.debug("Phrase "+logListenerTrigger.getKeyWord()+"found in log file");
		setPharseFound(true);
		
	}

	@Override
	public void run() {
		//Call watchFile to do the actual work		
		watchFile();
		
	}

}
