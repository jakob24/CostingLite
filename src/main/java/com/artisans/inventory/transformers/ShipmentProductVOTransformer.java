/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.ShipmentProduct;
import com.artisans.inventory.vo.ShipmentProductVO;

/**
 * @author Jacob
 *
 */
public class ShipmentProductVOTransformer implements Transformer {
	
    public ShipmentProduct transform(Object shipmentProductVOObj)
    {
     	if(shipmentProductVOObj == null)
    	{
    		throw new IllegalArgumentException("The input shipmentProductVOObj is empty.");
    	}
    	else if(! (shipmentProductVOObj instanceof ShipmentProductVO))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToShipmentProduct((ShipmentProductVO)shipmentProductVOObj);
    }
    	
	
	private static ShipmentProduct transformToShipmentProduct(ShipmentProductVO shipmentProductVO)
	{
		ShipmentProduct shipmentProduct = new DozerBeanMapper().map(shipmentProductVO, ShipmentProduct.class);   
		return shipmentProduct;
	}
}
