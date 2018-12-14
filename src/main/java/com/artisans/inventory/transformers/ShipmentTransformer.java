/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.Shipment;
import com.artisans.inventory.vo.ShipmentVO;

/**
 * @author bjacob
 *
 */
public class ShipmentTransformer implements Transformer {

    public ShipmentVO transform(Object shipmentObj)
    {
     	if(shipmentObj == null)
    	{
    		throw new IllegalArgumentException("The input shipmentObj is empty.");
    	}
    	else if(! (shipmentObj instanceof Shipment))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToShipmentVO((Shipment)shipmentObj);
    }
    	
	
	private static ShipmentVO transformToShipmentVO(Shipment shipment)
	{
		ShipmentVO shipmentProductVO = new DozerBeanMapper().map(shipment, ShipmentVO.class);   
		return shipmentProductVO;
	}
}
