/**
 * 
 */
package com.artisans.inventory.helper;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;



/**
 * @author Jacob
 *
 */
public class BeanHelper
{
	private static Log log = LogFactory.getLog(BeanHelper.class);
	
	@SuppressWarnings("unchecked")
	public static <T> T findBean(String beanName) 
	{
	    FacesContext context = FacesContext.getCurrentInstance();
	    return (T) context.getApplication().evaluateExpressionGet(context, "#{" + beanName + "}", Object.class);
	}
	
	//https://community.jboss.org/thread/8446
	public static void clearComponentHierarchy(UIComponent pComponent) 
	{
		if (pComponent.isRendered()) 
		{
			if (pComponent instanceof EditableValueHolder) 
			{
				EditableValueHolder editableValueHolder = (EditableValueHolder) pComponent;
				editableValueHolder.setSubmittedValue(null);
				editableValueHolder.setValue(null);
				editableValueHolder.setLocalValueSet(false);
				editableValueHolder.setValid(true);
			}

			for (Iterator<UIComponent> iterator = pComponent.getFacetsAndChildren(); iterator.hasNext();) {
				clearComponentHierarchy(iterator.next());
			}

		}
	}
	
	
    
    public static String getDisplayDate(Date date)
    {
    	DateFormat dt = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault());   
    	return dt.format(date);
    }
	

    
    /**
     * Method to get the Next date of the parameter date
     * @param date
     * @return
     */
    public static Date getNextDay( Date date)
    {
    	Calendar cal = Calendar.getInstance();
    	cal.setTime(date);
    	cal.add(Calendar.DATE, 1);
    	return cal.getTime();
    }
    
    /**
     * Method to get the Next date of the parameter date
     * @param date
     * @return
     */
    public static Date getTomorrow()
    {
    	return getNextDay(new Date());
    }  
    
    /**
     * Method to get the Next date of the parameter date
     * @param date
     * @return
     */
    public static Date getToday()
    {
    	return new Date();
    } 
    
    /**
     * Get date 
     * @param timezoneDate
     * @return
     */
    public static Date getDateByTimeByZone(String timezoneDate)
    {
    	Date newDate = null;
    	SimpleDateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX");		
		try 
		{
			newDate = fmt.parse(timezoneDate);
		}
		catch (ParseException e) 
		{
			log.error("Error while parsing Date. " + timezoneDate);
		}
		return newDate;
    }
    

    
    /**
     * Get the date and time for the locale as String
     * @return
     */
    public static String getLocaleDateTime()
	{
		String date ="";
		Locale currentLocale = Locale.getDefault();
		DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, currentLocale);
		date = df.format(new Date());
		
		DateFormat tf = DateFormat.getTimeInstance(DateFormat.DEFAULT, currentLocale);
		String time = tf.format(new Date());
		date = date + " " + time;
		return date;
	}     
}
