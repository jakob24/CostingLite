/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.Payment;
import com.artisans.inventory.vo.PaymentVO;

/**
 * @author Jacob
 *
 */
public class PaymentsVOTransformer implements Transformer
{
    public Payment transform(Object paymentVOObj)
    {
     	if(paymentVOObj == null)
    	{
    		throw new IllegalArgumentException("The input paymentVOObj is empty.");
    	}
    	else if(! (paymentVOObj instanceof PaymentVO))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToPayment((PaymentVO)paymentVOObj);
    }
    	
	
	private static Payment transformToPayment(PaymentVO paymentVO)
	{
		Payment payment = new DozerBeanMapper().map(paymentVO, Payment.class);   
		return payment;
	}	
}
