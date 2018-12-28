/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.Shipment;
import com.artisans.inventory.vo.ShipmentVO;

/**
 * @author Jacob
 *
 */
public class ShipmentVOTransformer implements Transformer {

    public Shipment transform(Object shipmentVOObj)
    {
     	if(shipmentVOObj == null)
    	{
    		throw new IllegalArgumentException("The input shipmentVOObj is empty.");
    	}
    	else if(! (shipmentVOObj instanceof ShipmentVO))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToShipment((ShipmentVO)shipmentVOObj);
    }
    	
	
	private static Shipment transformToShipment(ShipmentVO shipmentVO)
	{
		Shipment shipment = new DozerBeanMapper().map(shipmentVO, Shipment.class);   
		return shipment;
	}
}
