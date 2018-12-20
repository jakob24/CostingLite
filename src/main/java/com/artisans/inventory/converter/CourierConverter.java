/**
 * 
 */
package com.artisans.inventory.converter;

import java.io.Serializable;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.artisans.inventory.controller.ReferenceDataController;
import com.artisans.inventory.vo.CourierVO;

/**
 * @author bjacob
 *
 */
@SuppressWarnings("rawtypes")
@Component(value = "CourierConverter")
@FacesConverter("com.artisans.inventory.converter.CourierConverter")

public class CourierConverter implements Converter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	@Autowired
	private ReferenceDataController referenceDataController;		

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		Object selectedCourier = null;		
		List<CourierVO>courier = referenceDataController.getCourierVOList();			
		for(CourierVO courierVO : courier)
		{
			if(courierVO.getCourierId() == new Long(value).longValue())
			{
				selectedCourier = courierVO;
				break;
			}
		}		
		
		return selectedCourier;
	}
				
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		if( null != value && value != "")
		{
			return new Long(((CourierVO) value).getCourierId()).toString(); 
		}
		else
		{
			return value==null ? "": value.toString();
		}		
	}	
}
