/**
 * 
 */
package com.artisans.inventory.converter;

import java.io.Serializable;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.artisans.inventory.service.api.ShipmentService;
import com.artisans.inventory.vo.ShipmentVO;

/**
 * @author Jacob
 *
 */

@SuppressWarnings("rawtypes")
@Component(value = "ShipmentConverter")
@FacesConverter("com.artisans.inventory.converter.ShipmentConverter")
public class ShipmentConverter implements Converter, Serializable {

	@Autowired
	ShipmentService shipmentService;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public ShipmentVO getAsObject(FacesContext arg0, UIComponent arg1, String value) {
		if( null != value && value != "")
		{
			if(new Integer(value) >0 ) {
				return shipmentService.findShipment(new Integer(value));
			}
			else if(new Integer(value) == 0 ) {
				//Add new Shipment functionality
				//Bean creates an empty VO with id=0
				ShipmentVO addNewShipment = new ShipmentVO();
				addNewShipment.setShipmentId(0);
				return addNewShipment;
			}
			else {
				return null;
			}			
		}
		return null;
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object value) {
		
		if( null != value && value != "")
		{
			if(null == ((ShipmentVO) value).getShipmentId()) {
				return "";
			}else {
				return new Integer(((ShipmentVO) value).getShipmentId()).toString(); 
			}
		}
		else
		{
			return value==null ? "": value.toString();
		}	
	}

}
