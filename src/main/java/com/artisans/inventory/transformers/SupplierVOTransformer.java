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
 */
public class SupplierVOTransformer implements Transformer
{
    public Supplier transform(Object supplierVOObj)
    {
     	if(supplierVOObj == null)
    	{
    		throw new IllegalArgumentException("The input supplierVOObj is empty.");
    	}
    	else if(! (supplierVOObj instanceof SupplierVO))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToSupplier((SupplierVO)supplierVOObj);
    }
    	
	
	private static Supplier transformToSupplier(SupplierVO supplierVO)
	{
		Supplier supplier = new DozerBeanMapper().map(supplierVO, Supplier.class);   
		return supplier;
	}
}
