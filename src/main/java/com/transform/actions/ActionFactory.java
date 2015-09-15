/**
 * 
 */
package com.transform.actions;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import org.apache.log4j.Logger;

import com.transform.triggers.MethodCallTrigger;
import com.transforrm.exception.TransformException;

/**
 * Factory to return and instance of the required action class.
 * As new actions are added this class will not need to be modified as 
 * it uses reflection to find the required action class.
 * 
 * @author Anjana.Hewage
 *
 */
public class ActionFactory {

	/** Logging context. */
	static Logger log = Logger.getLogger(ActionFactory.class);
	
	/**
	 * This method returns an instance of the action class specified by the 
	 * actionClassName parameter. 
	 * 
	 * @param actionClassName Name of the Action class required
	 * @return an instance of an Action implementation
	 */
	public static Action getActionInstnce(String actionClassName) throws TransformException{
		Action actionClass = null;
				
		//Return the relevant action class for the name passed in
		try {						
			Class<?> c = Class.forName(actionClassName);
			Constructor<?> cons = c.getConstructor();
			actionClass = (Action) cons.newInstance();			
		} catch (ClassNotFoundException cnfe){
			throw new TransformException(cnfe);
		} catch (NoSuchMethodException nsme) {
			throw new TransformException(nsme);
		} catch (SecurityException se) {
			throw new TransformException(se);
		} catch (InstantiationException ie) {
			throw new TransformException(ie);
		} catch (IllegalAccessException iae) {
			throw new TransformException(iae);
		} catch (IllegalArgumentException iae) {
			throw new TransformException(iae);
		} catch (InvocationTargetException ite) {
			throw new TransformException(ite);
		}
		
		return actionClass;

	}	
	
}
