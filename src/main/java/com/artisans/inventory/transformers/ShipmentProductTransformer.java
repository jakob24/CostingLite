/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.ShipmentProduct;
import com.artisans.inventory.vo.ShipmentProductVO;

/**
 * @author bjacob
 *
 */
public class ShipmentProductTransformer implements Transformer {

    public ShipmentProductVO transform(Object shipmentProductObj)
    {
     	if(shipmentProductObj == null)
    	{
    		throw new IllegalArgumentException("The input shipmentProductObj is empty.");
    	}
    	else if(! (shipmentProductObj instanceof ShipmentProduct))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToShipmentProductVO((ShipmentProduct)shipmentProductObj);
    }
    	
	
	private static ShipmentProductVO transformToShipmentProductVO(ShipmentProduct shipmentProduct)
	{
		ShipmentProductVO shipmentProductVO = new DozerBeanMapper().map(shipmentProduct, ShipmentProductVO.class);   
		return shipmentProductVO;
	}
}
