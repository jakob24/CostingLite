/**
 * 
 */
package com.artisans.inventory.helper;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.FacesContext;

/**
 * @author Jacob
 *
 */

/**
 * Generic class to display error messages
 * @author Jacob
 *
 */
public class UIMessageHelper
{
	
	 public static final String BUNDLENAME_COSTONG_LITE = "messages";
	 
	 
	 private static UIMessageHelper instance = new UIMessageHelper();
	 
	 private ResourceBundle resourceBundle;
	 
	 private UIMessageHelper()
	 {}
	 
	 /**
	  * Return singleton instance of this class
	  * @return singleton instance
	  */
	 public synchronized static UIMessageHelper  getInstance() {
	     return instance;
	 }	 
	
	 public String get(String key, String bundleName)
	 {
		 Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
		 resourceBundle = ResourceBundle.getBundle(bundleName, locale);
		 return resourceBundle.getString(key);
	 }	 
	 
	 public String getMessage(String key)
	 {
		 return get(key, BUNDLENAME_COSTONG_LITE);
	 }
	 
	 public void displayUIMessage(String key, Severity severity)
	 {	 
		 String displayName = getInstance().get(key, BUNDLENAME_COSTONG_LITE); 		    
		 FacesContext.getCurrentInstance().addMessage(null,
             new FacesMessage(severity, displayName, ""));		 
	 }
	 
	 public void displayUIMessage(String key, Severity severity, Object[] params)
	 {	 
		 String displayMessage = getInstance().get(key, BUNDLENAME_COSTONG_LITE); 	
		 FacesContext.getCurrentInstance().addMessage(null,
             new FacesMessage(severity, MessageFormat.format(displayMessage, params), ""));		 
	 }	 
}
