/**
 * 
 */
package com.artisans.inventory.transformers;

import org.apache.commons.collections.Transformer;
import org.dozer.DozerBeanMapper;

import com.artisans.inventory.model.Invoice;
import com.artisans.inventory.vo.InvoiceVO;

/**
 * @author bjacob
 *
 * Convert Invoice to InvoiceVO 
 */
public class InvoiceTransformer implements Transformer {

    public InvoiceVO transform(Object invoiceObj)
    {
     	if(invoiceObj == null)
    	{
    		throw new IllegalArgumentException("The input invoiceObj is empty.");
    	}
    	else if(! (invoiceObj instanceof Invoice))
    	{
    		throw new IllegalArgumentException("Invalid object passed for transformation");
    	}
     	return transformToInvoiceVO((Invoice)invoiceObj);
    }
    	
	
	private static InvoiceVO transformToInvoiceVO(Invoice invoice)
	{
		InvoiceVO invoiceVO = new DozerBeanMapper().map(invoice, InvoiceVO.class);   
		return invoiceVO;
	}
}
