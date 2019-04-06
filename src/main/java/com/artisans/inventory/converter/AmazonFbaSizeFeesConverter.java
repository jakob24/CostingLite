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
import com.artisans.inventory.vo.AmazonFbaSizeFeesVO;

/**
 * @author Jacob
 *
 */
@SuppressWarnings("rawtypes")
@Component(value = "AmazonFbaSizeFeesConverter")
@FacesConverter("com.artisans.inventory.converter.AmazonFbaSizeFeesConverter")
public class AmazonFbaSizeFeesConverter implements Converter, Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private ReferenceDataController referenceDataController;		

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value)
	{
		Object selectedAmazonFbaSizeFees = null;		
		List<AmazonFbaSizeFeesVO> amazonFbaSizeFees = referenceDataController.getAmazonFbaSizeFeesVOList();		
		for(AmazonFbaSizeFeesVO amazonFbaSizeFeesVO : amazonFbaSizeFees)
		{
			if(amazonFbaSizeFeesVO.getAmazonFbaSizeFeesId().intValue() == new Integer(value).intValue())
			{
				selectedAmazonFbaSizeFees = amazonFbaSizeFeesVO;
				break;
			}
		}		
		
		return selectedAmazonFbaSizeFees;
	}
				
	public String getAsString(FacesContext context, UIComponent component, Object value)
	{
		if( null != value && value != "")
		{
			return new Integer(((AmazonFbaSizeFeesVO) value).getAmazonFbaSizeFeesId()).toString(); 
		}
		else
		{
			return value==null ? "": value.toString();
		}		
	}		

}
