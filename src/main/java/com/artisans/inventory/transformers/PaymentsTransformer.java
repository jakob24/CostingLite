/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.Payment;
import com.artisans.inventory.vo.PaymentVO;

/**
 * @author bjacob
 *
 */
public class PaymentsTransformer implements Transformer {

    public PaymentVO transform(Object paymentObj)
    {
     	if(paymentObj == null)
    	{
    		throw new IllegalArgumentException("The input paymentObj is empty.");
    	}
    	else if(! (paymentObj instanceof Payment))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToPaymentsVO((Payment)paymentObj);
    }
    	
	
	private static PaymentVO transformToPaymentsVO(Payment payment)
	{
		PaymentVO paymentVO = new DozerBeanMapper().map(payment, PaymentVO.class);   
		return paymentVO;
	}	
}
