/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.Product;
import com.artisans.inventory.vo.ProductVO;

/**
 * @author bjacob
 *
 */
public class ProductTransformer implements Transformer {

    public ProductVO transform(Object productObj)
    {
     	if(productObj == null)
    	{
    		throw new IllegalArgumentException("The input productObj is empty.");
    	}
    	else if(! (productObj instanceof Product))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToProductVO((Product)productObj);
    }
    	
	
	private static ProductVO transformToProductVO(Product product)
	{
		ProductVO productVO = new DozerBeanMapper().map(product, ProductVO.class);   
		return productVO;
	}	
}
