/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.Courier;
import com.artisans.inventory.vo.CourierVO;

/**
 * @author bjacob
 *
 */
public class CourierTransformer implements Transformer {
	
    public CourierVO transform(Object courierObj)
    {
     	if(courierObj == null)
    	{
    		throw new IllegalArgumentException("The input courierObj is empty.");
    	}
    	else if(! (courierObj instanceof Courier))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToSupplierVO((Courier)courierObj);
    }
    	
	
	private static CourierVO transformToSupplierVO(Courier courier)
	{
		CourierVO courierVO = new DozerBeanMapper().map(courier, CourierVO.class);   
		return courierVO;
	}
}
