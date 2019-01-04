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
public class ProductVOTransformer implements Transformer {

    public Product transform(Object productVObj)
    {
     	if(productVObj == null)
    	{
    		throw new IllegalArgumentException("The input productVObj is empty.");
    	}
    	else if(! (productVObj instanceof ProductVO))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToProduct((ProductVO)productVObj);
    }
    	
	
	private static Product transformToProduct(ProductVO productVO)
	{
		Product product = new DozerBeanMapper().map(productVO, Product.class);   
		return product;
	}		
}
