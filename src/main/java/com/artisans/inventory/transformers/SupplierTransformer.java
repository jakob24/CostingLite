/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.Supplier;
import com.artisans.inventory.vo.SupplierVO;

/**
 * @author Jacob
 *
 *Converts List of Supplier objects to List of SupplierVO objects
 */
public class SupplierTransformer implements Transformer {

    public SupplierVO transform(Object supplierObj)
    {
     	if(supplierObj == null)
    	{
    		throw new IllegalArgumentException("The input supplierObj is empty.");
    	}
    	else if(! (supplierObj instanceof Supplier))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToSupplierVO((Supplier)supplierObj);
    }
    	
	
	private static SupplierVO transformToSupplierVO(Supplier supplier)
	{
		SupplierVO supplierVO = new DozerBeanMapper().map(supplier, SupplierVO.class);   
		return supplierVO;
	}	
}
