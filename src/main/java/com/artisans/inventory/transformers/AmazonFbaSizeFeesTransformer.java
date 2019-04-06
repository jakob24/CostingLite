/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.AmazonFbaSizeFees;
import com.artisans.inventory.vo.AmazonFbaSizeFeesVO;

/**
 * @author Jacob
 *
 */
public class AmazonFbaSizeFeesTransformer implements Transformer {

    public AmazonFbaSizeFeesVO transform(Object amazonFbaSizeFeesObj)
    {
     	if(amazonFbaSizeFeesObj == null)
    	{
    		throw new IllegalArgumentException("The input amazonFbaSizeFeesObj is empty.");
    	}
    	else if(! (amazonFbaSizeFeesObj instanceof AmazonFbaSizeFees))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToAmazonFbaSizeFeesVO((AmazonFbaSizeFees)amazonFbaSizeFeesObj);
    }
    	
	
	private static AmazonFbaSizeFeesVO transformToAmazonFbaSizeFeesVO(AmazonFbaSizeFees amazonFbaSizeFees)
	{
		AmazonFbaSizeFeesVO amazonFbaSizeFeesVO = new DozerBeanMapper().map(amazonFbaSizeFees, AmazonFbaSizeFeesVO.class);   
		return amazonFbaSizeFeesVO;
	}
}
