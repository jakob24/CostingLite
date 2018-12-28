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
import com.artisans.inventory.vo.SupplierVO;


/**
 * @author bjacob
 *
 */


@SuppressWarnings("rawtypes")
@Component(value = "SupplierConverter")
@FacesConverter("com.artisans.inventory.converter.SupplierConverter")
public class SupplierConverter implements Converter, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	@Autowired
	private ReferenceDataController referenceDataController;


	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		Object selectedSupplier = null;	    
		List<SupplierVO>suppliers = referenceDataController.getSupplierVOList();			
		for(SupplierVO supplier : suppliers)
		{
			if(supplier.getSupplierId() == new Integer(value).intValue())
			{
				selectedSupplier =  supplier;
				break;
			}
		}			
		
		return selectedSupplier;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		if( null != value && value != "")
		{
			return new Integer(((SupplierVO) value).getSupplierId()).toString(); 
		}
		else
		{
			return value==null ? "": value.toString();
		}		
	}	

}
